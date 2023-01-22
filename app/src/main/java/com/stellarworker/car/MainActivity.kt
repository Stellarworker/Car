package com.stellarworker.car

import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.ArcMotion
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.stellarworker.car.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainActivityCar.setOnClickListener { car ->
            val changeBounds = ChangeBounds()
            changeBounds.setPathMotion(ArcMotion())
            changeBounds.duration = ANIMATION_DURATION
            TransitionManager.beginDelayedTransition(
                binding.mainActivityRoot,
                changeBounds
            )
            val params = car.layoutParams as FrameLayout.LayoutParams
            params.gravity = Gravity.END or Gravity.BOTTOM
            car.layoutParams = params
        }
    }

    companion object {
        private const val ANIMATION_DURATION = 2000L
    }
}