package com.rich.spannable

import android.graphics.Color
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.spannable.SpannableImpl
import com.rich.spannable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = "debug_MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val param = "test"
        val str = "这是一段测试文案 %s"

        val text = String.format(str, param)

        binding.tvTest.movementMethod = LinkMovementMethod.getInstance()
        val span = SpannableImpl.get().init(text).commonParams(param).color(Color.GREEN)
            .italic()
            .bold().size(58).clickableSpan(Color.BLUE, param) {
                Toast.makeText(this, "click test", Toast.LENGTH_SHORT).show()
            }.getSpan()
        binding.tvTest.highlightColor = 0
        binding.tvTest.text = span
        binding.tvTest.setOnClickListener {
            Log.d(TAG, "26:onCreate: =========")
        }
    }
}