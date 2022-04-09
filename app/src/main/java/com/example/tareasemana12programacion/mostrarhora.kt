package com.example.tareasemana12programacion

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Handler
import android.os.IBinder
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class mostrarhora : Service() {
    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mHandler = Handler()
        mRunnable = Runnable {
            lahora()
        }
        mHandler.postDelayed(mRunnable, 2000)
        return Service.START_STICKY
    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "El servicio se ha apagado", Toast.LENGTH_LONG).show()
        mHandler.removeCallbacks(mRunnable)
    }
    private fun lahora(){
        val sdf = SimpleDateFormat("hh:mm:ss")
        val currentDate = sdf.format(Date())
        toast("Hora: "+currentDate)
        mHandler.postDelayed(mRunnable, 2000)
    }
}