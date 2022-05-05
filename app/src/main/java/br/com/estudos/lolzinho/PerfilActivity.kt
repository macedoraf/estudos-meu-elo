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
        campeao.text = entidadeInvocador.capeaoMaisJogado
        var percentVitorias = entidadeInvocador.elo.vitorias
        var eloDesk = entidadeInvocador.elo.nome

        if (percentVitorias > 50) {
            vitorias.setTextColor(resources.getColor(R.color.green))
        } else if (percentVitorias < 50) {
            vitorias.setTextColor(resources.getColor(R.color.red))
        } else {
            vitorias.setTextColor(resources.getColor(R.color.gray))
        }
        vitorias.text = "${percentVitorias}%"

        if (eloDesk == "ferro" || eloDesk == "Ferro") {
            emblema.setImageResource(R.drawable.emblem_ferro)
        } else if (eloDesk == "bronze" || eloDesk == "Bronze") {
            emblema.setImageResource(R.drawable.emblem_bronze)
        } else if (eloDesk == "prata" || eloDesk == "Prata") {
            emblema.setImageResource(R.drawable.emblem_silver)
        } else if (eloDesk == "ouro" || eloDesk == "Ouro") {
            emblema.setImageResource(R.drawable.emblem_gold)
        } else if (eloDesk == "platina" || eloDesk == "Platina") {
            emblema.setImageResource(R.drawable.emblem_platinum)
        } else if (eloDesk == "diamante" || eloDesk == "Diamante") {
            emblema.setImageResource(R.drawable.emblem_diamond)
        } else if (eloDesk == "mestre" || eloDesk == "Mestre") {
            emblema.setImageResource(R.drawable.emblem_master)
        } else if (eloDesk == "grao mestre" || eloDesk == "Grao Mestre") {
            emblema.setImageResource(R.drawable.emblem_grandmaster)
        } else if (eloDesk == "desafiante" || eloDesk == "Desafiante") {
            emblema.setImageResource(R.drawable.emblem_challenger)
        }
    }
}