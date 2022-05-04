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



## Dicas gerais

Git.

Comandos mais importantes, git init / git add . / git commit -m "Nome do commit" / git pull / git push

Android.

Componentes utilizados TextView(Label campo descritivo), EditText(Campo de entrada de texto), Acitivty(Tela), Button(Botao rs), Intent(Serve pra navegar pra outra tela), Bundle(Serve pra colocar dentro do Intent e passar informacoes pra outra tela)
