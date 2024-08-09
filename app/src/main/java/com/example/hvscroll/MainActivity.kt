package com.example.hvscroll

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ScrollView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var mx = 0f
    private var my = 0f

    private var vScroll: ScrollView? = null
    private var hScroll: HorizontalScrollView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        vScroll = findViewById<View>(R.id.vScroll) as ScrollView
        hScroll = findViewById<View>(R.id.hScroll) as HorizontalScrollView
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val curX: Float
        val curY: Float

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                mx = event.x
                my = event.y
            }

            MotionEvent.ACTION_MOVE -> {
                curX = event.x
                curY = event.y
                vScroll!!.scrollBy((mx - curX).toInt(), (my - curY).toInt())
                hScroll!!.scrollBy((mx - curX).toInt(), (my - curY).toInt())
                mx = curX
                my = curY
            }

            MotionEvent.ACTION_UP -> {
                curX = event.x
                curY = event.y
                vScroll!!.scrollBy((mx - curX).toInt(), (my - curY).toInt())
                hScroll!!.scrollBy((mx - curX).toInt(), (my - curY).toInt())
            }
        }
        return true
    }
}
