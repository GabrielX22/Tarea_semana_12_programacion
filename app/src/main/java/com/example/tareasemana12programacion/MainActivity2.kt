package com.example.tareasemana12programacion

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val serviceClass = mostrarhora::class.java
        val intent = Intent(applicationContext, serviceClass)

        imageiniciar.setOnClickListener {
            if (!activadorservicio(serviceClass)) {
                startService(intent)
                toast("Se ha iniciado el servicio")
            } else {
                toast("El servicio ya esta iniciado")
            }
        }

        imageparar.setOnClickListener {
            if (activadorservicio(serviceClass)) {
                stopService(intent)
                toast("Se ha apagado el servicio")
            } else {
                toast("El servicio ya esta apagado")
            }
        }

        imageestado.setOnClickListener {
            if (activadorservicio(serviceClass)) {
                toast("El servicio esta activo")
            } else {
                toast("El servicio esta apagado")
            }
        }
    }
    private fun activadorservicio(serviceClass: Class<*>): Boolean {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service in activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                return true
            }
        }
        return false
    }
}
fun Context.toast(message:String){
    Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
}

