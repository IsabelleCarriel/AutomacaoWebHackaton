#language: pt
#enconding: UTF-8

Funcionalidade: Tentativa de Transferencia

  Contexto:
    Dado que faco um cadastro com os dados:
      | email             | nome    | senha | confirmacao_senha |
      | ciclano@teste.com | Ciclano | 12345 | 12345             |
    E que abro uma nova aba
    E faco login com as credencias "ciclano@teste.com" e "12345"
    E sou redirecionado para o Dashboard

  Cenario: Transferencia com dados invalidos
    Quando faco uma transferencia com dados invalidos
    Entao vejo a mensagem de alerta "Conta inválida ou inexistente"


  Cenario: Transferencia com dados da propria conta
    Quando faco uma transferencia com meus dados
    Entao vejo a mensagem de alerta "Nao pode transferir pra mesmo conta"