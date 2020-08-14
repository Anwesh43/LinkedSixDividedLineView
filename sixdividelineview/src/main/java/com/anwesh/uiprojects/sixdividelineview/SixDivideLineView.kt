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
val scGap : Float = 0.02f / parts
val strokeFactor : Int = 90
val sizeFactor : Float = 4.8f
val foreColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()
