package com.example.tareasemana12programacion

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viview.setVideoURI(Uri.parse("android.resource://"
                + packageName + "/" + R.raw.splash))
        viview.start()
        startTimer()
    }
    fun startTimer(){
        object: CountDownTimer(5000,1000){
            override fun onTick(p0: Long) {

            }
            override fun onFinish() {
                val intento = Intent(applicationContext, MainActivity2::class.java)
                startActivity(intento)
                finish()
            }
        }.start()
    }
}