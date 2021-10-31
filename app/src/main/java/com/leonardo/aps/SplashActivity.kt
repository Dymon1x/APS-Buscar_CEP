package com.leonardo.aps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leonardo.aps.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private var scope = CoroutineScope(Dispatchers.Main)
    private lateinit var bind: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_splash)
        bind = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(bind.root)

        goMain()
    }

    private fun goMain(){
        bind.apply {
            scope.launch {
                delay(3000)
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            }
        }
    }
}