package br.com.estudos.lolzinho.model.data

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor

class Connector(
    private val okHttpClient: OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()
) {

    companion object {
        private const val API_KEY: String = "RGAPI-1f355d99-0edb-4184-88c3-87eea5dee576"
        private const val X_RIOT_TOKEN_KEY = "X-Riot-Token"
        private const val HOST_URL = "br1.api.riotgames.com"
        private const val APPLICATION_JSON = "application/json"
    }

    fun request(request: RequestModel) {
        val requestBody = request.body?.toRequestBody(APPLICATION_JSON.toMediaType())
        val url = "$HOST_URL/${request.path}"

        okHttpClient.newCall(
            Request.Builder()
                .method(request.method, requestBody)
                .url(url)
                .addHeader(X_RIOT_TOKEN_KEY, API_KEY)
                .build()
        )
    }
}