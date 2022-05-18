package br.com.estudos.lolzinho.model.data.response_model

data class RiotResponse(
    val statusCode: Int,
    val messageCode: String,
    val isSuccess: Boolean,
    val body: String?
)