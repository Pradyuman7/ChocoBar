package com.pd.chocobarKotlin

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.v4.graphics.drawable.DrawableCompat

object ChocoBarUtils {
    fun tintDrawable(drawable: Drawable, @ColorInt color: Int): Drawable {
        var drawableVar = drawable
        drawableVar = DrawableCompat.wrap(drawableVar)
        drawableVar = drawableVar.mutate()
        DrawableCompat.setTint(drawableVar, color)

        return drawableVar
    }

    fun makeTransparentDrawable(context: Context, width: Int, height: Int): Drawable {
        val conf = Bitmap.Config.ARGB_8888
        val bmp = Bitmap.createBitmap(width, height, conf)
        return BitmapDrawable(context.resources, bmp)
    }
}