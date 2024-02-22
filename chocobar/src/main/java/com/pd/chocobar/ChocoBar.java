package com.pd.chocobar;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntDef;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import com.google.android.material.snackbar.Snackbar;
import androidx.core.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP;


public class ChocoBar {

    private enum Type {
        DEFAULT(null, null, null, null, null),
        GREEN(Color.parseColor("#388E3C"), R.drawable.check_mark, Color.WHITE, "SUCCESS !", Color.WHITE),
        RED(Color.parseColor("#D50000"), R.drawable.cross_mark, Color.WHITE, "ERROR !", Color.WHITE),
        CYAN(Color.parseColor("#e0ffff"), R.drawable.info_mark, Color.WHITE, "CYAN", Color.WHITE),
        ORANGE(Color.parseColor("#ffa500"), R.drawable.warning_mark, Color.BLACK, "WARNING !", Color.BLACK),
        GOOD(Color.parseColor("#C5BEBE"), R.drawable.good_mark, Color.WHITE, "GRAY_GOOD", Color.WHITE),
        BAD(Color.parseColor("#C5BEBE"), R.drawable.bad_mark, Color.WHITE, "GRAY_BAD", Color.WHITE),
        BLACK(Color.parseColor("#000000"), R.drawable.off_notification_mark, Color.WHITE, "Black", Color.WHITE),
        LOVE(Color.parseColor("#E8290B"), R.drawable.ic_love, Color.BLACK, "LOVE", Color.BLACK),
        BLOCKED(Color.parseColor("#E8290B"), R.drawable.blocked_mark, Color.BLACK, "BLOCKED", Color.BLACK),
        NOTIFICATION_ON(Color.parseColor("#000000"), R.drawable.on_notification_mark, Color.WHITE, "NOTIFICATIONS ON", Color.WHITE),
        INFOGRAY(Color.parseColor("#BB353535"), R.drawable.info_mark, Color.WHITE,"INFO GRAYBLUE", Color.parseColor("#4895ED"));

        private Integer color;
        private Integer iconResId;
        private Integer standardTextColor;
        private CharSequence text;
        private Integer iconTint;

        Type(@ColorInt Integer color, @DrawableRes Integer iconResId, @ColorInt Integer standardTextColor, CharSequence text, @ColorInt Integer iconTint) {
            this.color = color;

            this.iconResId = iconResId;
            this.standardTextColor = standardTextColor;

            this.text = text;
            this.iconTint = iconTint;
        }

        public Integer getColor() {
            return color;
        }

        public Drawable getIcon(Context context) {
            if (iconResId == null)
                return null;

            Drawable drawable = ContextCompat.getDrawable(context, iconResId);

            if (drawable != null)
                drawable = ChocoBarUtils.tintDrawable(drawable, standardTextColor);

            return drawable;
        }


        public Integer getStandardTextColor() {
            return standardTextColor;
        }

        public CharSequence getText() {
            return text;
        }

        public Integer getIconTint(){return iconTint;}
    }

    private final Builder builder;

    private ChocoBar(Builder builder) {
        this.builder = builder;
    }

    private Snackbar make() {

        if(builder.text == null) {
            builder.text = builder.type.getText();
        }

        Snackbar chocolate = Snackbar.make(builder.view, builder.text, builder.duration);

        if (builder.actionClickListener != null || builder.actionText != null) {
            if (builder.actionClickListener == null)
                builder.actionClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                };

            chocolate.setAction(builder.actionText, builder.actionClickListener);

            if (builder.actionTextColor == null)
                builder.actionTextColor = builder.type.getStandardTextColor();

            if (builder.actionTextColors != null)
                chocolate.setActionTextColor(builder.actionTextColors);

            else if (builder.actionTextColor != null)
                chocolate.setActionTextColor(builder.actionTextColor);

        }

        Snackbar.SnackbarLayout chocolateLayout = (Snackbar.SnackbarLayout) chocolate.getView();

        if (builder.backgroundColor == null)
            builder.backgroundColor = builder.type.getColor();

        if (builder.backgroundColor != null)
            chocolateLayout.setBackgroundColor(builder.backgroundColor);

        TextView actionText = chocolateLayout.findViewById(R.id.snackbar_action);

        if (builder.actionTextSize != null) {
            if (builder.actionTextSizeUnit != null)
                actionText.setTextSize(builder.actionTextSizeUnit, builder.actionTextSize);

            else
                actionText.setTextSize(builder.actionTextSize);
        }

        Typeface actionTextTypeface = actionText.getTypeface();

        if (builder.actionTextTypeface != null)
            actionTextTypeface = builder.actionTextTypeface;

        if (builder.actionTextTypefaceStyle != null)
            actionText.setTypeface(actionTextTypeface, builder.actionTextTypefaceStyle);

        else
            actionText.setTypeface(actionTextTypeface);


        TextView text = chocolateLayout.findViewById(R.id.snackbar_text);

        if (builder.textSize != null) {
            if (builder.textSizeUnit != null)
                text.setTextSize(builder.textSizeUnit, builder.textSize);

            else
                text.setTextSize(builder.textSize);
        }

        Typeface textTypeface = text.getTypeface();

        if (builder.textTypeface != null)
            textTypeface = builder.textTypeface;

        if (builder.textTypefaceStyle != null)
            text.setTypeface(textTypeface, builder.textTypefaceStyle);

        else
            text.setTypeface(textTypeface);

        if (builder.textColor == null)
            builder.textColor = builder.type.getStandardTextColor();

        if (builder.textColors != null)
            text.setTextColor(builder.textColors);

        else if (builder.textColor != null)
            text.setTextColor(builder.textColor);

        text.setMaxLines(builder.maxLines);
        text.setGravity(builder.centerText ? Gravity.CENTER : Gravity.CENTER_VERTICAL);

        if (builder.centerText && Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN)
            text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        if (builder.icon == null)
            builder.icon = builder.type.getIcon(builder.view.getContext());

        if (builder.icon != null) {

            Drawable transparentHelperDrawable = null;

            if (builder.centerText && TextUtils.isEmpty(builder.actionText)) {
                transparentHelperDrawable = ChocoBarUtils.makeTransparentDrawable(builder.view.getContext(),
                        builder.icon.getIntrinsicWidth(),
                        builder.icon.getIntrinsicHeight());
            }

            Configuration configuration = chocolateLayout.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && configuration.getLayoutDirection() == View.LAYOUT_DIRECTION_RTL)
                text.setCompoundDrawablesWithIntrinsicBounds(transparentHelperDrawable, null, builder.icon, null);
            else
                text.setCompoundDrawablesWithIntrinsicBounds(builder.icon, null, transparentHelperDrawable, null);

            if (Build.VERSION.SDK_INT >= 21 && builder.iconTint != null){
                builder.icon.setTint(builder.iconTint);
                Log.d("TAG","HERE");
            }
            else if(Build.VERSION.SDK_INT >= 21 && builder.iconTint == null ){
                builder.icon.setTint(builder.type.getIconTint());
                Log.d("TAG","NOHERE");
            }
            text.setCompoundDrawablePadding(text.getResources().getDimensionPixelOffset(R.dimen.icon_padding));
        }

        return chocolate;
    }

    public static Builder builder() {
        return new Builder();
    }

    @RestrictTo(LIBRARY_GROUP)
    @IntDef({LENGTH_INDEFINITE, LENGTH_SHORT, LENGTH_LONG})
    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    public static final int LENGTH_INDEFINITE = Snackbar.LENGTH_INDEFINITE;
    public static final int LENGTH_SHORT = Snackbar.LENGTH_SHORT;
    public static final int LENGTH_LONG = Snackbar.LENGTH_LONG;


    public static class Builder {

        private View view = null;
        private Type type = Type.DEFAULT;
        private int duration = Snackbar.LENGTH_SHORT;
        private CharSequence text = null;
        private int textResId = 0;
        private Integer textColor = null;
        private ColorStateList textColors = null;
        private Integer textSizeUnit = null;
        private Float textSize = null;
        private Integer textTypefaceStyle = null;
        private Typeface textTypeface = null;
        private Integer actionTextSizeUnit = null;
        private Float actionTextSize = null;
        private CharSequence actionText = "";
        private int actionTextResId = 0;
        private Integer actionTextTypefaceStyle = null;
        private Typeface actionTextTypeface = null;
        private View.OnClickListener actionClickListener = null;
        private Integer actionTextColor = null;
        private ColorStateList actionTextColors = null;
        private int maxLines = Integer.MAX_VALUE;
        private boolean centerText = false;
        private Drawable icon = null;
        private int iconResId = 0;
        private Integer backgroundColor = null;
        private Integer iconTint = null;

        private Builder() {
        }

        public Builder setActivity(Activity activity) {
            return setView(((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0));
        }

        public Builder setView(View view) {
            this.view = view;
            return this;
        }

        public Builder setText(@StringRes int resId) {
            this.textResId = resId;
            return this;
        }

        public Builder setText(CharSequence text) {
            this.textResId = 0;
            this.text = text;
            return this;
        }

        public Builder setTextColor(@ColorInt int color) {
            this.textColor = color;
            return this;
        }

        public Builder setTextColor(ColorStateList colorStateList) {
            this.textColor = null;
            this.textColors = colorStateList;
            return this;
        }

        public Builder setTextSize(float textSize) {
            this.textSizeUnit = null;
            this.textSize = textSize;
            return this;
        }

        public Builder setTextSize(int unit, float textSize) {
            this.textSizeUnit = unit;
            this.textSize = textSize;
            return this;
        }

        public Builder setTextTypeface(Typeface typeface) {
            this.textTypeface = typeface;
            return this;
        }

        public Builder setTextTypefaceStyle(int style) {
            this.textTypefaceStyle = style;
            return this;
        }

        public Builder centerText() {
            this.centerText = true;
            return this;
        }

        public Builder setActionTextColor(ColorStateList colorStateList) {
            this.actionTextColor = null;
            this.actionTextColors = colorStateList;
            return this;
        }

        public Builder setActionTextColor(@ColorInt int color) {
            this.actionTextColor = color;
            return this;
        }

        public Builder setActionText(@StringRes int resId) {
            this.actionTextResId = resId;
            return this;
        }

        public Builder setActionText(CharSequence text) {
            this.textResId = 0;
            this.actionText = text;
            return this;
        }

        public Builder setActionTextSize(float textSize) {
            this.actionTextSizeUnit = null;
            this.actionTextSize = textSize;
            return this;
        }

        public Builder setActionTextSize(int unit, float textSize) {
            this.actionTextSizeUnit = unit;
            this.actionTextSize = textSize;
            return this;
        }

        public Builder setActionTextTypeface(Typeface typeface) {
            this.actionTextTypeface = typeface;
            return this;
        }


        public Builder setActionTextTypefaceStyle(int style) {
            this.actionTextTypefaceStyle = style;
            return this;
        }

        public Builder setActionClickListener(View.OnClickListener listener) {
            this.actionClickListener = listener;
            return this;
        }

        public Builder setMaxLines(int maxLines) {
            this.maxLines = maxLines;
            return this;
        }

        public Builder setDuration(@Duration int duration) {
            this.duration = duration;
            return this;
        }

        public Builder setIcon(@DrawableRes int resId) {
            this.iconResId = resId;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.icon = drawable;
            return this;
        }

        public Builder setBackgroundColor(@ColorInt int color) {
            this.backgroundColor = color;
            return this;
        }

        public Builder setIconTint(@ColorInt int color){
            this.iconTint = color;
            return this;
        }

        public Snackbar build() {
            return make();
        }

        public Snackbar green() {
            type = Type.GREEN;
            return make();
        }

        public Snackbar cyan() {
            type = Type.CYAN;
            return make();
        }

        public Snackbar orange() {
            type = Type.ORANGE;
            return make();
        }

        public Snackbar red() {
            type = Type.RED;
            return make();
        }

        public Snackbar good() {
            type = Type.GOOD;
            return make();
        }

        public Snackbar bad() {
            type = Type.BAD;
            return make();
        }

        public Snackbar love() {
            type = Type.LOVE;
            return make();
        }


        public Snackbar black() {
            type = Type.BLACK;
            return make();
        }


        public Snackbar blocked() {
            type = Type.BLOCKED;
            return make();
        }


        public Snackbar notificationsOn()
        {
            type = Type.NOTIFICATION_ON;
            return make();
        }


        public Snackbar infoGray()
        {
            type = Type.INFOGRAY;
            return make();
        }

        private Snackbar make() {
            if (view == null)
                throw new IllegalStateException("ChocoBar Error: You must set an Activity or a View before making a snack");

            if (textResId != 0)
                text = view.getResources().getText(textResId);

            if (actionTextResId != 0)
                actionText = view.getResources().getText(actionTextResId);

            if (iconResId != 0)
                icon = ContextCompat.getDrawable(view.getContext(), iconResId);

            return new ChocoBar(this).make();
        }
    }
}
