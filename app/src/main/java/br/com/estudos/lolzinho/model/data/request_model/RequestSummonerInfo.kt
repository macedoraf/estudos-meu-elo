package br.com.estudos.lolzinho.model.data.request_model

class RequestSummonerInfo(summonerName: String) :
    RequestModel("lol/summoner/v4/summoners/by-name/$summonerName", "GET", null) {
}