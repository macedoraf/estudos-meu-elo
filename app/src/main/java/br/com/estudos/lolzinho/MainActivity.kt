package br.com.estudos.lolzinho

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import br.com.estudos.lolzinho.entidades.Elo
import br.com.estudos.lolzinho.entidades.Invocador

class MainActivity : AppCompatActivity() {

    lateinit var btnEntrar: Button
    lateinit var etInvocador: TextView
    lateinit var spElo: Spinner
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
        spElo = findViewById(R.id.sp_elo)
        etDivisao = findViewById(R.id.et_divisao)
        etPdl = findViewById(R.id.et_pdl)
        etCampeao = findViewById(R.id.et_campeao)
        etVitorias = findViewById(R.id.et_vitorias)

        realizaConfiguracao()

    }

    private fun realizaConfiguracao() {
        btnEntrar.setOnClickListener(View.OnClickListener {
            if (osCamposSaoValidos()) {
                navegaParaOutraTela()
            } else {
                Toast.makeText(this.baseContext, "$textoDeErro", Toast.LENGTH_LONG).show()
            }
        })

        spElo.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayOf(
            "Ferro", "Bronze",
            "Prata", "Ouro",
            "Platina", "Diamante",
            "Mestre", "Grão-Mestre",
            "Desafiante"
        ))
    }

    fun adicionaTexto(param: String) {
        if (textoDeErro == "") {
            textoDeErro += param
        } else {
            textoDeErro += "\n" + param
        }
    }

    fun osCamposSaoValidos(): Boolean {

        textoDeErro = ""
        var nomeDoInvocador = etInvocador.text.toString()
        var divisao = etDivisao.text.toString()
        var pdl = etPdl.text.toString()
        var campeao = etCampeao.text.toString()
        var vitorias = etVitorias.text.toString()

        if (nomeDoInvocador == "") {
            adicionaTexto("Nome de invocador inválido")
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
        val nomeDoInvocador = etInvocador.text.toString()
        val nomeDoCampeaoMaisJogado = etCampeao.text.toString()
        val nomeDaDivisao = etDivisao.text.toString()
        val quantidadeDePdls = etPdl.text.toString().toInt()
        val quantidadeDeVitorias = etVitorias.text.toString().toFloat()
        val elo = Elo("", nomeDaDivisao, quantidadeDePdls, quantidadeDeVitorias)
        val invocador = Invocador(nomeDoInvocador, nomeDoCampeaoMaisJogado, elo)

        val myIntent = Intent(this, PerfilActivity::class.java)
        myIntent.putExtra("invocador", invocador)
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
