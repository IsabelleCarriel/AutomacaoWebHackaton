#language: pt
#enconding: UTF-8

Funcionalidade: Realizar Login

  Cenario: Realizar login
    Dado que faco um cadastro com os dados:
      | email            | nome   | senha | confirmacao_senha |
      | fulano@teste.com | Fulano | 12345 | 12345             |
    E que abro uma nova aba
    Quando digito no campo email "fulano@teste.com"
    E digito no campo senha "12345"
    E clico no botao Acessar
    Entao sou redirecionado para o Dashboard

  Cenario: Realizar login com credenciais erradas
    Dado que acesso a pagina de login
    Quando digito no campo email "isateste@teste.com"
    E digito no campo senha "12345"
    E clico no botao Acessar
    Entao vejo a menssagem de alerta "Usuário ou senha inválido."