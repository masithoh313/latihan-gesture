package com.example.gesture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {

    var gDetector: GestureDetectorCompat?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.gDetector= GestureDetectorCompat(this,this)
        gDetector?.setOnDoubleTapListener(this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        this.gDetector?.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun onDown(event: MotionEvent): Boolean {
        gesture_status.text="on Down"
        return true
    }

    override fun onFling(
        event1: MotionEvent?,
        event2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        gesture_status.text="on Fling"
        return true
    }

    override fun onLongPress(event: MotionEvent?) {
        gesture_status.text="on Long Press"

    }

    override fun onScroll(
        event1: MotionEvent?,
        event2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        gesture_status.text="on Scro0ll"
        return true
    }

    override fun onShowPress(event: MotionEvent?) {
        gesture_status.text="on Show Press"
    }

    override fun onSingleTapUp(event: MotionEvent?): Boolean {
        gesture_status.text="on Single Tap Up"
        return true
    }

    override fun onDoubleTap(event: MotionEvent?): Boolean {
        gesture_status.text="on Double Tap"
        return true
    }

    override fun onDoubleTapEvent(event: MotionEvent?): Boolean {
        gesture_status.text="on Double Tap Event"
        return true
    }

    override fun onSingleTapConfirmed(event: MotionEvent?): Boolean {
        gesture_status.text="on Single Tap Confirmed"
        return true
    }

}
