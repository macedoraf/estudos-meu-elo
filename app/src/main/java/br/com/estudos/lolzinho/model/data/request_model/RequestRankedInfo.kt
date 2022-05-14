package br.com.estudos.lolzinho.model.data.request_model

class RequestRankedInfo(summonerId: String) :
    RequestModel("lol/league/v4/entries/by-summoner/$summonerId", "GET", null) {
}