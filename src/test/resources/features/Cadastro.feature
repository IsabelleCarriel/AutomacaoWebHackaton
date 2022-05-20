#language: pt
#enconding: UTF-8

Funcionalidade: Realizar Cadastro

  Contexto:
    Dado que acesso a pagina de login

  Cenario: Cadastro com sucesso, conta sem saldo
    E clico no botao Registrar
    Quando submeto o seguinte formulario de cadastro:
      | email         | nome     | senha | confirmacao_senha |
      | isa@teste.com | Isabelle | 12345 | 12345             |
    E clico no botao Cadastrar
    Entao vejo a mensagem que a conta foi "criada com sucesso"

@teste
  Cenario: Cadastro com sucesso, conta com saldo
    E clico no botao Registrar
    Quando submeto o seguinte formulario de cadastro:
      | email            | nome   | senha | confirmacao_senha |
      | fulano@teste.com | Fulano | 12345 | 12345             |
    E clico no botao para acionar saldo
    E clico no botao Cadastrar
    Entao vejo a mensagem que a conta foi "criada com sucesso"

  Esquema do Cenario: Tentativa de Cadastro
    E clico no botao Registrar
    Quando submeto o seguinte formulario de cadastro:
      | email         | nome         | senha         | confirmacao_senha         |
      | <email_input> | <nome_input> | <senha_input> | <confirmacao_senha_input> |
    E clico no botao Cadastrar
    Entao vejo a mensagem de alerta: "<mensagem_output>"
    Exemplos:
      | email_input   | nome_input | senha_input | confirmacao_senha_input | mensagem_output           |
      | isateste.com  | Isabelle   | 12345       | 12345                   | Formato inválido          |
      | isa@teste.com | Isabelle   | 12345       |                         | É campo obrigatório       |
      | isa@teste.com | Isabelle   | 12345       | 122                     | As senhas não são iguais. |
      | isa@teste.com |            | 12345       | 12345                   | Nome não pode ser vazio.  |