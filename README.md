# Projeto de estudos

### Instruções iniciais

Devera ser criada uma branch com o seguinte formato para:

nome-da-funcionalidade/nome-da-alteracao

Ex. tela-de-login/v1

Ao finalizar as mudancas devera ser feita uma solicitação de **PULL REQUEST** com a branch *tela-de-login/v1* com destino para *master*

Apos isso colocar o macedoraf responsável(Assignees) para que ele faça a mesclagem das branchs.

obs. na aba pull requests tem um exemplo de como deve ser o resultado final "pull request de exemplo #1"

## #1 Praticando orientação de layout e passagem de dados para outra tela 

### Tela de Login v1 :white_check_mark:

*Requisitos funcionais:*
- Os campos deverao estar ordenados de **cima para baixo** na ordem em que forem listados abaixo
- Campo de entrada de texto com a descrição "Nome do invocador"
- Campo de entrada de texto com a descrição "Elo"
- Campo de entrada de texto com a descrição "Divisão"
- Campo de entrada de texto com a descrição "PDLs"
- Campo de entrada de texto com a descrição "Campeão mais jogado"
- Campo de entrada de texto com a descrição "% de vitórias"
- Botão com o descritivo "Entrar"
- Ação no botão que redireciona para tela "Perfil"

### Tela de Perfil v1 :white_check_mark:

*Requisitos funcionais:*

  **Deverá exibir as informações informadas na tela anterior**
  
- Label(campo de texto) com o nome do invocador.
- Label(campo de texto)  "Elo"
- Label(campo de texto)  "Divisão"
- Label(campo de texto)  "PDLs"
- Label(campo de texto)  "Campeão mais jogado"
- Label(campo de texto)  "% de vitórias"


---

### Tela de Login v2 :white_check_mark:

*Requisitos funcionais:*
- Os elementos de entrada de dados deverão estar alinhados a esquerda a uma margem de 30 dps.
- O botão devera estar centralizado ao final do furmulario.

### Tela de Perfil v2 :white_check_mark:

*Requisitos funcionais:*
- As informaçoes deverão estar dipostas no seguinte formato [Descricao]: [Valor] Ex. Nome do Invocador: macedoraf
- Ao representar o elo devera ser exibida a imagem do elo correspondente seguindo da divisao abaixo.
- Quando a porcentagem de vitórias for < 50% deverá exibir o em verde, quando < 50 vermelho e quando = 50 branco


### Tela de Login v3 :white_check_mark:
*Requisitos funcionais:*
- Ao clicar no botao de entrar devera ferificar se algum campo ficou vazio para redirecionar, caso esteja vazio devera exibir uma mensagem de que há campos faltantes a serem preenchidos.
- Nos campos que só fazem sentido numeros deverá ocorrer uma validacao para que nao seja possivel avancar para a próxima tela caso o campo PDL por exemplo seja inserido uma letra

### Tela de Login v3.1 :white_check_mark:
*Requisitos funcionais:*
- Ao clicar no botao de entrar a validacao dos campos devera informar uma lista com os campos faltantes/preenchidos incorretamente.

### Introducao a orientacao objeto :white_check_mark:
- Conceitos, pilares, usos.
- Exemplo prático

Ela é um jeito de programar/construir softwares.

Beneficios:
- Reusabilidade.
- Controle de acessos.
- Padranozação.


Entidades:
- Elo
- Invocador


Invocador
 - Nome
 - % de vitórias
 - Campeao mais jogado
 - Elo

Elo
 - Divisão
 - PDL


### Criando a classe Invocador e Elo :white_check_mark:

- Devera ser usado a classe invocador para passar os dados de uma tela para outra

### Tela de Login v4 :white_check_mark:
*Requisitos funcionais:*
- Ao invés de escrever o nome do elo deverá aparecer um dropdown com as opcões disponíveis
- Ao invés de escrever o numero da visião deverá aparecer um dropdown com as opcões disponíveis
- Quando for selecionado a divisão Mestre/Grau Mestre/Desafiante o campo de divisão deverá ser desabilidato



### Buscando os dados a partir do site/api da riot

Qual informaçoes gostariamos de buscar?

### Buscando Dados v1

Input Nome do invocador

output Ranked Solo/Duo da Season atual:
    - Elo
    - Divisao
    - Campeao mais jogado
    - % de vitórias

APIs para chamar:

Host: br1.api.riotgames.com

Champions: http://ddragon.leagueoflegends.com/cdn/12.9.1/data/en_US/champion.json

Champion icon: http://ddragon.leagueoflegends.com/cdn/12.9.1/img/champion/{ChampionName}.png

Summoner ID : {host}/lol/summoner/v4/summoners/by-name/{summonerName}
    Example:

    {
        "id": "Q1OkZqB0qgirDh_t-aRv6hrlBAK7oc5od95YiLArWeLZ", <- encrypted summonet ID
        "accountId": "Ko1tCXg28E82C26Q4q3Xj4uOVB1qyGTzqMVU6vc7odg", // Numero da conta criptografado
        "puuid": "xjSHUXHG9Kh6TR-IVzwcGYzy80v6-IQESUk0L6psfAU-wDbmb9xyCpODHCqLnxZYD5gu-YqHVtylOw",
        "name": "macedoraf",
        "profileIconId": 518,
        "revisionDate": 1652211503000,
        "summonerLevel": 305
    }

Summoner Ranked info: {host} /lol/league/v4/entries/by-summoner/{summonerId}

    Example:

    [
        {
            "leagueId": "1a8c1177-bdc0-439f-b618-ad6b23ecc133",
            "queueType": "RANKED_SOLO_5x5",
            "tier": "PLATINUM",
            "rank": "IV",
            "summonerId": "Q1OkZqB0qgirDh_t-aRv6hrlBAK7oc5od95YiLArWeLZ",
            "summonerName": "macedoraf",
            "leaguePoints": 75,
            "wins": 108,
            "losses": 96,
            "veteran": false,
            "inactive": false,
            "freshBlood": false,
            "hotStreak": false
        },
        {
            "leagueId": "9fb74c30-1e7c-4180-90a5-46208293e100",
            "queueType": "RANKED_FLEX_SR",
            "tier": "GOLD",
            "rank": "IV",
            "summonerId": "Q1OkZqB0qgirDh_t-aRv6hrlBAK7oc5od95YiLArWeLZ",
            "summonerName": "macedoraf",
            "leaguePoints": 45,
            "wins": 16,
            "losses": 14,
            "veteran": false,
            "inactive": false,
            "freshBlood": false,
            "hotStreak": false
        }
    ]


### Tela de RankedInfo v1

Construir conforme prototipo

![prototipo_01_rankedinfo](https://user-images.githubusercontent.com/21695431/169083454-942baedf-cfc3-4844-854c-27c7b5024e77.png)




## Dicas gerais

Git.

Comandos mais importantes, git init / git add . / git commit -m "Nome do commit" / git pull / git push

Android.

Componentes utilizados TextView(Label campo descritivo), EditText(Campo de entrada de texto), Acitivty(Tela), Button(Botao rs), Intent(Serve pra navegar pra outra tela), Bundle(Serve pra colocar dentro do Intent e passar informacoes pra outra tela)
