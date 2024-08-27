package com.forkingcode.sample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.forkingcode.sample.R.layout
import com.google.android.material.appbar.AppBarLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.activity_main)
        val appBar: AppBarLayout = findViewById(R.id.appBar)

        val paddingLeft = appBar.paddingLeft
        val paddingRight = appBar.paddingRight
        val paddingTop = appBar.paddingTop

        ViewCompat.setOnApplyWindowInsetsListener(appBar) { view, insets ->

            val bars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or
                    WindowInsetsCompat.Type.displayCutout()
            )
            view.updatePadding(
                top = paddingTop + bars.top,
                left = paddingLeft + bars.left,
                right = paddingRight + bars.right,
            )

            insets
        }
    }
}