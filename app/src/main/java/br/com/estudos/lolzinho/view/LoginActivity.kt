package br.com.estudos.lolzinho.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.estudos.lolzinho.R
import br.com.estudos.lolzinho.model.data.RiotAPI
import br.com.estudos.lolzinho.model.data.request_model.RequestSummonerInfo
import br.com.estudos.lolzinho.model.data.response_model.SummonerInfoResponse
import br.com.estudos.lolzinho.view.examples.PerfilActivity
import com.google.gson.GsonBuilder
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {

    lateinit var btSighIn: Button
    lateinit var etSummonerName: EditText
    lateinit var riotAPI: RiotAPI
    lateinit var okHttpClient: OkHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_login)
        initialize()
        setupListeners()

    }

    private fun setupListeners() {
        btSighIn.setOnClickListener {
            val summonerName = etSummonerName.text.toString()

            if (summonerName.isNotBlank()) {
                findSummonerName(summonerName)
            } else {
                showErrorWhenInvalidInput()
            }
        }
    }

    private fun showErrorWhenInvalidInput() {
        showError("Nome do invocador inválido")
    }

    private fun showErrorWhenSummonerNotFound(messageError: String) {
        showError("Invocador não encontrado : $messageError")
    }

    private fun showGenericError(messageError: String) {
        showError("Deu ruim : $messageError")
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG)
            .show()
    }

    private fun findSummonerName(summonerName: String) {
        // Ele ta criando um processamento na camada segundaria pra nao travar o app
        GlobalScope.async {
            // Comeca segundo plano
            val response = riotAPI.request(RequestSummonerInfo(summonerName))

            withContext(Dispatchers.Main) { // Comeca primeiro plano

                if (response.isSuccess) {
                    response.body?.let { validateSuccess(it) }
                } else {
                    validateError(response.statusCode, response.messageCode)
                }
            } // Termina primeiro plano
            // Segundo plano
        }
    }


    private fun validateError(statusCode: Int, messageError: String) {
        when (statusCode) {
            404 -> {
                showErrorWhenSummonerNotFound(messageError)
            } //Quando o usuario nao existe / nao encontrado
            else -> {
                showGenericError(messageError)
            } // deu ruim...

        }
    }

    private fun validateSuccess(body: String) {
        // Jeito mais demorado

//        val jsonObject = JSONObject(body)
//        val id = jsonObject.getString("id")
//        SummonerInfoResponse(id, ...)

        val gson = GsonBuilder().create()
        val summonerInfo = gson.fromJson(body, SummonerInfoResponse::class.java)

        navigateToRankedInfoScreen(summonerInfo)
    }

    private fun navigateToRankedInfoScreen(summonerInfo: SummonerInfoResponse) {
        val myIntent = Intent(this, RankedInfoActivity::class.java)
        myIntent.putExtra(RankedInfoActivity.SUMMONER_INFO_PARAM, summonerInfo)
        startActivity(myIntent)
    }

    private fun initialize() {
        btSighIn = findViewById(R.id.bt_sigh_in)
        etSummonerName = findViewById(R.id.et_summoner_name)
        okHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()
        riotAPI = RiotAPI(okHttpClient)
    }


}