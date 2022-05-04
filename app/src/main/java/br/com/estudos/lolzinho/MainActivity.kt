package br.com.estudos.lolzinho

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.time.Duration

class MainActivity : AppCompatActivity() {

    lateinit var btnEntrar: Button
    lateinit var etInvocador: TextView
    lateinit var etElo: TextView
    lateinit var etDivisao: TextView
    lateinit var etPdl: TextView
    lateinit var etCampeao: TextView
    lateinit var etVitorias: TextView
    var textoDeErro: String = ""

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
            if (osCamposSaoValidos()) {
                navegaParaOutraTela()
            } else {
                Toast.makeText(this.baseContext, "$textoDeErro", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun adicionaTexto(param:String){
        if (textoDeErro == ""){
            textoDeErro += param
        } else {
            textoDeErro += "\n" + param
        }
    }

    fun osCamposSaoValidos(): Boolean {

        textoDeErro = ""
        var nomeDoInvocador = etInvocador.text.toString()
        var elo = etElo.text.toString()
        var divisao = etDivisao.text.toString()
        var pdl = etPdl.text.toString()
        var campeao = etCampeao.text.toString()
        var vitorias = etVitorias.text.toString()

        if (nomeDoInvocador == "") {
            adicionaTexto("Nome de invocador inválido")
        }
        if (elo == "") {
            adicionaTexto("Elo inválido")
        }
        if (divisao == "") {
            adicionaTexto("Divisão inválida")
        }
        if (pdl == "" || !isNumeric(pdl)) {
            adicionaTexto("PDLs inválidos")
        }
        if (campeao == "") {
            adicionaTexto("Campeão inválido")
        }
        if (vitorias == "" || !isNumeric(vitorias)) {
            adicionaTexto("Vitorias inválidas")
        }
        return textoDeErro == ""

    }

    fun navegaParaOutraTela() {
        val myIntent = Intent(this, PerfilActivity::class.java)
        myIntent.putExtra("invocador", etInvocador.text.toString())
        myIntent.putExtra("elo", etElo.text.toString())
        myIntent.putExtra("divisao", etDivisao.text.toString())
        myIntent.putExtra("pdl", etPdl.text.toString())
        myIntent.putExtra("campeao", etCampeao.text.toString())
        myIntent.putExtra("vitorias", etVitorias.text.toString().toInt())
        this.startActivity(myIntent)
    }

    fun isNumeric(str: String): Boolean {
        return try {
            str.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
}
