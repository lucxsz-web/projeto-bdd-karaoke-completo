Feature: Adição de música na fila do karaokê
  Como um participante
  Quero adicionar músicas à fila usando o nome delas pelo Youtube
  Para que eu entre na ordem de execução da sessão

  Background:
    Given que existe uma sessão ativa com ID "123"
    And que o participante "Lucas" está conectado à sessão

  Scenario: Adicionar música válida à fila
    Given que estou na tela da sessão
    When insiro o nome "Midnight Sun - Zara Larsson" 
    And clico em "Adicionar à Fila"
    Then a música deve aparecer na fila
    And deve estar associada ao usuário "Lucas"

  Scenario: Tentar adicionar música com link inválido
    Given que estou na tela da sessão
    When insiro o link "abcd"
    And clico em "Adicionar à Fila"
    Then o sistema deve exibir a mensagem de erro "Link inválido"
