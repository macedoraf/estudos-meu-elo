package br.com.estudos.lolzinho.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.estudos.lolzinho.R

class RankedInfoActivity : AppCompatActivity() {

    companion object {
        const val SUMMONER_INFO_PARAM = "summoner_info"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_ranked_info)
        initialize()
        setupListeners()
    }

    private fun setupListeners() {
        TODO("Not yet implemented")
    }


    private fun initialize() {

    }
}