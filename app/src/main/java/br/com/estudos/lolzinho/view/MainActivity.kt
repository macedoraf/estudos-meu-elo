package br.com.estudos.lolzinho.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import br.com.estudos.lolzinho.*
import br.com.estudos.lolzinho.model.entidades.Elo
import br.com.estudos.lolzinho.model.entidades.Invocador

class MainActivity : AppCompatActivity() {

    lateinit var btnEntrar: Button
    lateinit var etInvocador: TextView
    lateinit var etPdl: TextView
    lateinit var etCampeao: TextView
    lateinit var etVitorias: TextView
    val listaHighElo: Array<String> = arrayOf(
        "-"
    )
    var listaDivisao: Array<String> = arrayOf(
        "I",
        "II",
        "III",
        "IV"
    )
    val listaElo: Array<String> = arrayOf(
        TEXTO_FERRO,
        TEXTO_BRONZE,
        TEXTO_PRATA,
        TEXTO_OURO,
        TEXTO_PLATINA,
        TEXTO_DIAMENTE,
        TEXTO_MESTRE,
        TEXTO_GMESTRE,
        TEXTO_DESAFIANTE
    )
    lateinit var spElo: Spinner
    lateinit var spDivisao: Spinner
    var textoDeErro = ""
    var eloSelecionado = ""
    var divisaoSelecionada = ""
    var listaDivisaoSelecionada = listaDivisao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnEntrar = findViewById(R.id.bt_perfil)
        etInvocador = findViewById(R.id.et_invocador)
        spElo = findViewById(R.id.sp_elo)
        spDivisao = findViewById(R.id.sp_divisao)
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

        spElo.adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_item, listaElo
        )

        spDivisao.adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_item, listaDivisaoSelecionada
        )

        spElo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                Log.i("teste", "${listaElo[position]}")
                eloSelecionado = listaElo[position]
                if (listaElo[position] == TEXTO_MESTRE ||
                    listaElo[position] == TEXTO_GMESTRE ||
                    listaElo[position] == TEXTO_DESAFIANTE
                ) {
                    listaDivisaoSelecionada = listaHighElo
                } else {
                    listaDivisaoSelecionada = listaDivisao
                }
                spDivisao.adapter = ArrayAdapter(
                    this@MainActivity, android.R.layout.simple_spinner_item, listaDivisaoSelecionada
                )

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        spDivisao.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                Log.i("teste", "${listaDivisaoSelecionada[position]}")
                divisaoSelecionada = listaDivisaoSelecionada[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
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
        var pdl = etPdl.text.toString()
        var campeao = etCampeao.text.toString()
        var vitorias = etVitorias.text.toString()

        if (nomeDoInvocador == "") {
            adicionaTexto("Nome de invocador inválido")
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
        val quantidadeDePdls = etPdl.text.toString().toInt()
        val quantidadeDeVitorias = etVitorias.text.toString().toFloat()
        val elo = Elo(eloSelecionado, divisaoSelecionada, quantidadeDePdls, quantidadeDeVitorias)
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
