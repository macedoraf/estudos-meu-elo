package br.com.estudos.lolzinho.model.data.response_model

import java.io.Serializable

data class SummonerInfoResponse(
    val id: String,
    val accountId: String,
    val puuid: String,
    val name: String,
    val profileIconId: Int,
    val revisionDate: Long,
    val summonerLevel: Int
) : Serializable