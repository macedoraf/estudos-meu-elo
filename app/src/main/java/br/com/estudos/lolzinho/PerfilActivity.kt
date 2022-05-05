package br.com.estudos.lolzinho

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.estudos.lolzinho.entidades.Invocador

class PerfilActivity : AppCompatActivity() {
    lateinit var invocador: TextView
    lateinit var divisao: TextView
    lateinit var pdl: TextView
    lateinit var campeao: TextView
    lateinit var vitorias: TextView
    lateinit var emblema: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        invocador = findViewById(R.id.tv_invocador)
        divisao = findViewById(R.id.tv_divisao)
        pdl = findViewById(R.id.tv_pdl)
        campeao = findViewById(R.id.tv_campeao)
        vitorias = findViewById(R.id.tv_vitorias)
        emblema = findViewById(R.id.img_elo)

        val entidadeInvocador = intent.extras?.getSerializable("invocador") as Invocador

        invocador.text = entidadeInvocador.nome
        pdl.text = entidadeInvocador.elo.pdls.toString()
        divisao.text = entidadeInvocador.elo.divisao
        campeao.text = entidadeInvocador.campeaoMaisJogado
        var percentVitorias = entidadeInvocador.elo.vitorias

        when {
            percentVitorias > 50 -> {
                vitorias.setTextColor(resources.getColor(R.color.green))
            }
            percentVitorias < 50 -> {
                vitorias.setTextColor(resources.getColor(R.color.red))
            }
            else -> {
                vitorias.setTextColor(resources.getColor(R.color.gray))
            }
        }
        vitorias.text = "${percentVitorias}%"

        when (entidadeInvocador.elo.nome) {
            "ferro", "Ferro" -> {
                emblema.setImageResource(R.drawable.emblem_ferro)
            }
            "bronze", "Bronze" -> {
                emblema.setImageResource(R.drawable.emblem_bronze)
            }
            "prata", "Prata" -> {
                emblema.setImageResource(R.drawable.emblem_silver)
            }
            "ouro", "Ouro" -> {
                emblema.setImageResource(R.drawable.emblem_gold)
            }
            "platina", "Platina" -> {
                emblema.setImageResource(R.drawable.emblem_platinum)
            }
            "diamante", "Diamante" -> {
                emblema.setImageResource(R.drawable.emblem_diamond)
            }
            "mestre", "Mestre" -> {
                emblema.setImageResource(R.drawable.emblem_master)
            }
            "grao mestre", "Grao Mestre" -> {
                emblema.setImageResource(R.drawable.emblem_grandmaster)
            }
            "desafiante", "Desafiante" -> {
                emblema.setImageResource(R.drawable.emblem_challenger)
            }
            else -> {}
        }
    }
}