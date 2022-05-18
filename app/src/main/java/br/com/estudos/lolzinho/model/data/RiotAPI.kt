package br.com.estudos.lolzinho.model.data

import br.com.estudos.lolzinho.model.data.request_model.RequestModel
import br.com.estudos.lolzinho.model.data.response_model.RiotResponse
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

class RiotAPI(
    private val okHttpClient: OkHttpClient
) {

    companion object {
        private const val API_KEY: String = "RGAPI-1f355d99-0edb-4184-88c3-87eea5dee576"
        private const val X_RIOT_TOKEN_KEY = "X-Riot-Token"
        private const val HOST_URL = "https://br1.api.riotgames.com"
        private const val APPLICATION_JSON = "application/json"
    }

    fun request(request: RequestModel): RiotResponse {
        val requestBody = request.body?.toRequestBody(APPLICATION_JSON.toMediaType())
        val url = "$HOST_URL/${request.path}"
        val okHttpRequest = Request.Builder()
            .method(request.method, requestBody)
            .url(url)
            .addHeader(X_RIOT_TOKEN_KEY, API_KEY)
            .build()

        val response = okHttpClient.newCall(okHttpRequest).execute()
        return RiotResponse(
            response.code,
            response.message,
            response.isSuccessful,
            response.body?.string()
        )
    }
}