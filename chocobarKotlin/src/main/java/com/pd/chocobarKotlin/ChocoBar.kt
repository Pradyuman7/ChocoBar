package com.pd.chocobarKotlin

import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.annotation.IntDef
import android.support.annotation.IntRange
import android.support.annotation.RestrictTo
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.design.widget.Snackbar.SnackbarLayout
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ChocoBar private constructor(private val builder: Builder) {
    internal enum class Type(
        @param:ColorInt val color: Int?,
        @param:DrawableRes private val iconResId: Int?,
        @param:ColorInt val standardTextColor: Int?,
        val text: CharSequence?
    ) {

        DEFAULT(null, null, null, null), GREEN(
            Color.parseColor("#388E3C"),
            R.drawable.check_mark,
            Color.WHITE,
            "SUCCESS !"
        ),
        RED(
            Color.parseColor("#D50000"), R.drawable.cross_mark, Color.WHITE, "ERROR !"
        ),
        CYAN(Color.parseColor("#e0ffff"), R.drawable.info_mark, Color.WHITE, "CYAN"), ORANGE(
            Color.parseColor("#ffa500"), R.drawable.warning_mark, Color.BLACK, "WARNING !"
        ),
        GOOD(
            Color.parseColor("#C5BEBE"), R.drawable.good_mark, Color.WHITE, "GRAY_GOOD"
        ),
        BAD(Color.parseColor("#C5BEBE"), R.drawable.bad_mark, Color.WHITE, "GRAY_BAD"), BLACK(
            Color.parseColor("#000000"), R.drawable.off_notification_mark, Color.WHITE, "Black"
        ),
        LOVE(
            Color.parseColor("#E8290B"), R.drawable.ic_love, Color.BLACK, "LOVE"
        ),
        BLOCKED(
            Color.parseColor("#E8290B"),
            R.drawable.blocked_mark,
            Color.BLACK,
            "BLOCKED"
        ),
        NOTIFICATION_ON(
            Color.parseColor("#000000"),
            R.drawable.on_notification_mark,
            Color.WHITE,
            "NOTIFICATIONS ON"
        );

        fun getIcon(context: Context?): Drawable? {
            if (iconResId == null) return null
            var drawable = ContextCompat.getDrawable(context!!, iconResId)
            if (drawable != null) drawable =
                standardTextColor?.let { ChocoBarUtils.tintDrawable(drawable!!, it) }
            return drawable
        }
    }

    private fun make(): Snackbar {
        if (builder.text == null) {
            builder.text = builder.type.text
        }

        val chocolate = Snackbar.make(builder.view!!, builder.text!!, builder.duration)
        if (builder.actionClickListener != null || builder.actionText != null) {
            if (builder.actionClickListener == null) builder.actionClickListener =
                View.OnClickListener { }
            chocolate.setAction(builder.actionText, builder.actionClickListener)
            if (builder.actionTextColor == null) builder.actionTextColor =
                builder.type.standardTextColor
            if (builder.actionTextColors != null) chocolate.setActionTextColor(builder.actionTextColors) else if (builder.actionTextColor != null) chocolate.setActionTextColor(
                builder.actionTextColor!!
            )
        }

        val chocolateLayout = chocolate.view as SnackbarLayout
        if (builder.backgroundColor == null) builder.backgroundColor = builder.type.color
        if (builder.backgroundColor != null) chocolateLayout.setBackgroundColor(builder.backgroundColor!!)

        val actionText = chocolateLayout.findViewById<TextView>(R.id.snackbar_action)
        if (builder.actionTextSize != null) {
            if (builder.actionTextSizeUnit != null) actionText.setTextSize(
                builder.actionTextSizeUnit!!,
                builder.actionTextSize!!
            ) else actionText.textSize = builder.actionTextSize!!
        }

        var actionTextTypeface = actionText.typeface
        if (builder.actionTextTypeface != null) actionTextTypeface = builder.actionTextTypeface
        if (builder.actionTextTypefaceStyle != null) actionText.setTypeface(
            actionTextTypeface,
            builder.actionTextTypefaceStyle!!
        ) else actionText.typeface = actionTextTypeface

        val text = chocolateLayout.findViewById<TextView>(R.id.snackbar_text)
        if (builder.textSize != null) {
            if (builder.textSizeUnit != null) text.setTextSize(
                builder.textSizeUnit!!,
                builder.textSize!!
            ) else text.textSize = builder.textSize!!
        }

        var textTypeface = text.typeface
        if (builder.textTypeface != null) textTypeface = builder.textTypeface
        if (builder.textTypefaceStyle != null) text.setTypeface(
            textTypeface,
            builder.textTypefaceStyle!!
        ) else text.typeface = textTypeface
        if (builder.textColor == null) builder.textColor = builder.type.standardTextColor
        if (builder.textColors != null) text.setTextColor(builder.textColors) else if (builder.textColor != null) text.setTextColor(
            builder.textColor!!
        )
        text.maxLines = builder.maxLines
        text.gravity = if (builder.centerText) Gravity.CENTER else Gravity.CENTER_VERTICAL
        if (builder.centerText && Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) text.textAlignment =
            View.TEXT_ALIGNMENT_CENTER
        if (builder.icon == null) builder.icon = builder.type.getIcon(builder.view!!.context)
        if (builder.icon != null) {
            var transparentHelperDrawable: Drawable? = null
            if (builder.centerText && TextUtils.isEmpty(builder.actionText)) {
                transparentHelperDrawable = ChocoBarUtils.makeTransparentDrawable(
                    builder.view!!.context,
                    builder.icon!!.intrinsicWidth,
                    builder.icon!!.intrinsicHeight
                )
            }

            val configuration = chocolateLayout.resources.configuration
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && configuration.layoutDirection == View.LAYOUT_DIRECTION_RTL) text.setCompoundDrawablesWithIntrinsicBounds(
                transparentHelperDrawable,
                null,
                builder.icon,
                null
            ) else text.setCompoundDrawablesWithIntrinsicBounds(
                builder.icon, null, transparentHelperDrawable, null
            )

            text.compoundDrawablePadding =
                text.resources.getDimensionPixelOffset(R.dimen.icon_padding)
        }

        return chocolate
    }

    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
    @IntDef(LENGTH_INDEFINITE, LENGTH_SHORT, LENGTH_LONG)
    @IntRange(from = 1)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    annotation class Duration
    class Builder internal constructor() {
        internal var view: View? = null
        internal var type = Type.DEFAULT
        internal var duration = Snackbar.LENGTH_SHORT
        internal var text: CharSequence? = null
        private var textResId = 0
        internal var textColor: Int? = null
        internal var textColors: ColorStateList? = null
        internal var textSizeUnit: Int? = null
        internal var textSize: Float? = null
        internal var textTypefaceStyle: Int? = null
        internal var textTypeface: Typeface? = null
        internal var actionTextSizeUnit: Int? = null
        internal var actionTextSize: Float? = null
        internal var actionText: CharSequence? = ""
        private var actionTextResId = 0
        internal var actionTextTypefaceStyle: Int? = null
        internal var actionTextTypeface: Typeface? = null
        internal var actionClickListener: View.OnClickListener? = null
        internal var actionTextColor: Int? = null
        internal var actionTextColors: ColorStateList? = null
        internal var maxLines = Int.MAX_VALUE
        internal var centerText = false
        internal var icon: Drawable? = null
        private var iconResId = 0
        internal var backgroundColor: Int? = null

        fun setActivity(activity: Activity): Builder {
            return setView((activity.findViewById<View>(R.id.content) as ViewGroup).getChildAt(0))
        }

        fun setView(view: View?): Builder {
            this.view = view
            return this
        }

        fun setText(@StringRes resId: Int): Builder {
            textResId = resId
            return this
        }

        fun setText(text: CharSequence?): Builder {
            textResId = 0
            this.text = text
            return this
        }

        fun setTextColor(@ColorInt color: Int): Builder {
            textColor = color
            return this
        }

        fun setTextColor(colorStateList: ColorStateList?): Builder {
            textColor = null
            textColors = colorStateList
            return this
        }

        fun setTextSize(textSize: Float): Builder {
            textSizeUnit = null
            this.textSize = textSize
            return this
        }

        fun setTextSize(unit: Int, textSize: Float): Builder {
            textSizeUnit = unit
            this.textSize = textSize
            return this
        }

        fun setTextTypeface(typeface: Typeface?): Builder {
            textTypeface = typeface
            return this
        }

        fun setTextTypefaceStyle(style: Int): Builder {
            textTypefaceStyle = style
            return this
        }

        fun centerText(): Builder {
            centerText = true
            return this
        }

        fun setActionTextColor(colorStateList: ColorStateList?): Builder {
            actionTextColor = null
            actionTextColors = colorStateList
            return this
        }

        fun setActionTextColor(@ColorInt color: Int): Builder {
            actionTextColor = color
            return this
        }

        fun setActionText(@StringRes resId: Int): Builder {
            actionTextResId = resId
            return this
        }

        fun setActionText(text: CharSequence?): Builder {
            textResId = 0
            actionText = text
            return this
        }

        fun setActionTextSize(textSize: Float): Builder {
            actionTextSizeUnit = null
            actionTextSize = textSize
            return this
        }

        fun setActionTextSize(unit: Int, textSize: Float): Builder {
            actionTextSizeUnit = unit
            actionTextSize = textSize
            return this
        }

        fun setActionTextTypeface(typeface: Typeface?): Builder {
            actionTextTypeface = typeface
            return this
        }

        fun setActionTextTypefaceStyle(style: Int): Builder {
            actionTextTypefaceStyle = style
            return this
        }

        fun setActionClickListener(listener: View.OnClickListener?): Builder {
            actionClickListener = listener
            return this
        }

        fun setMaxLines(maxLines: Int): Builder {
            this.maxLines = maxLines
            return this
        }

        fun setDuration(@Duration duration: Int): Builder {
            this.duration = duration
            return this
        }

        fun setIcon(@DrawableRes resId: Int): Builder {
            iconResId = resId
            return this
        }

        fun setIcon(drawable: Drawable?): Builder {
            icon = drawable
            return this
        }

        fun setBackgroundColor(@ColorInt color: Int): Builder {
            backgroundColor = color
            return this
        }

        fun build(): Snackbar {
            return make()
        }

        fun green(): Snackbar {
            type = Type.GREEN
            return make()
        }

        fun cyan(): Snackbar {
            type = Type.CYAN
            return make()
        }

        fun orange(): Snackbar {
            type = Type.ORANGE
            return make()
        }

        fun red(): Snackbar {
            type = Type.RED
            return make()
        }

        fun good(): Snackbar {
            type = Type.GOOD
            return make()
        }

        fun bad(): Snackbar {
            type = Type.BAD
            return make()
        }

        fun love(): Snackbar {
            type = Type.LOVE
            return make()
        }

        fun black(): Snackbar {
            type = Type.BLACK
            return make()
        }

        fun blocked(): Snackbar {
            type = Type.BLOCKED
            return make()
        }

        fun notificationsOn(): Snackbar {
            type = Type.NOTIFICATION_ON
            return make()
        }

        private fun make(): Snackbar {
            checkNotNull(view) { "ChocoBar Error: You must set an Activity or a View before making a snack" }
            if (textResId != 0) text = view!!.resources.getText(textResId)
            if (actionTextResId != 0) actionText = view!!.resources.getText(actionTextResId)
            if (iconResId != 0) icon = ContextCompat.getDrawable(view!!.context, iconResId)
            return ChocoBar(this).make()
        }
    }

    companion object {
        fun builder(): Builder {
            return Builder()
        }

        const val LENGTH_INDEFINITE = Snackbar.LENGTH_INDEFINITE
        const val LENGTH_SHORT = Snackbar.LENGTH_SHORT
        const val LENGTH_LONG = Snackbar.LENGTH_LONG
    }
}