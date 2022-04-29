package br.com.estudos.lolzinho

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PerfilActivity : AppCompatActivity() {
    lateinit var invocador: TextView
    lateinit var elo : TextView
    lateinit var divisao : TextView
    lateinit var pdl : TextView
    lateinit var campeao: TextView
    lateinit var vitorias : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        invocador = findViewById(R.id.tv_invocador)
        elo = findViewById(R.id.tv_elo)
        divisao = findViewById(R.id.tv_divisao)
        pdl = findViewById(R.id.tv_pdl)
        campeao = findViewById(R.id.tv_campeao)
        vitorias = findViewById(R.id.tv_vitorias)

        invocador.text = intent.extras?.getString("invocador")
        elo.text = intent.extras?.getString("elo")
        divisao.text = intent.extras?.getString("divisao")
        pdl.text = intent.extras?.getString("pdl")
        campeao.text = intent.extras?.getString("campeao")
        vitorias.text = intent.extras?.getString("vitorias")
    }
}