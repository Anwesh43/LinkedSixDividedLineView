package com.anwesh.uiprojects.sixdividelineview

/**
 * Created by anweshmishra on 15/08/20.
 */

import android.view.View
import android.view.MotionEvent
import android.graphics.*
import android.app.Activity
import android.content.Context

val colors : Array<String> = arrayOf("#3F51B5", "#4CAF50", "#F44336", "#2196F3", "#009688")
val parts : Int = 2
val lines : Int = 6
val scGap : Float = 0.02f / (parts * lines)
val strokeFactor : Int = 90
val sizeFactor : Float = 4.8f
val foreColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawSixDivideLine(i : Int, scale : Float, w : Float, h : Float, paint : Paint) {
    val sf : Float = scale.sinify()
    val sf1 : Float = sf.divideScale(0, parts)
    val sf2 : Float = sf.divideScale(1, parts)
    val sf1i : Float = sf1.divideScale(i, lines)
    val sf2i : Float = sf2.divideScale(lines - 1 - i, lines)
    val size : Float = Math.min(w, h) / sizeFactor
    val gap : Float = size / lines
    save()
    translate(gap * i + (w - size) * sf2i, h / 2)
    drawLine(0f, 0f, gap * sf1i, 0f, paint)
    restore()
}

fun Canvas.drawSDLNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = Color.parseColor(colors[i])
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    for (j in 0..(parts - 1)) {
        drawSixDivideLine(j, scale, w, h, paint)
    }
}
