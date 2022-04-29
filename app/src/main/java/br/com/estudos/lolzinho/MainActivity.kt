package br.com.estudos.lolzinho

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnEntrar : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnEntrar = findViewById(R.id.bt_perfil)

        btnEntrar.setOnClickListener(View.OnClickListener {
            val myIntent = Intent(this, PerfilActivity::class.java)
            this.startActivity(myIntent)
        })
    }
}