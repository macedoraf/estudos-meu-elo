package br.com.estudos.lolzinho

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btnEntrar: Button
    lateinit var etInvocador: TextView
    lateinit var etElo: TextView
    lateinit var etDivisao: TextView
    lateinit var etPdl: TextView
    lateinit var etCampeao: TextView
    lateinit var etVitorias: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnEntrar = findViewById(R.id.bt_perfil)
        etInvocador = findViewById(R.id.et_invocador)
        etElo = findViewById(R.id.et_elo)
        etDivisao = findViewById(R.id.et_divisao)
        etPdl = findViewById(R.id.et_pdl)
        etCampeao = findViewById(R.id.et_campeao)
        etVitorias = findViewById(R.id.et_vitorias)

        btnEntrar.setOnClickListener(View.OnClickListener {
            val myIntent = Intent(this, PerfilActivity::class.java)
            myIntent.putExtra("invocador", etInvocador.text.toString())
            myIntent.putExtra("elo", etElo.text.toString())
            myIntent.putExtra("divisao", etDivisao.text.toString())
            myIntent.putExtra("pdl", etPdl.text.toString())
            myIntent.putExtra("campeao", etCampeao.text.toString())
            myIntent.putExtra("vitorias", etVitorias.text.toString().toInt())
            this.startActivity(myIntent)
        })
    }
}