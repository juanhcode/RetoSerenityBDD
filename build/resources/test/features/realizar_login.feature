Feature: Realizar login
  Yo como usuario
  Quiero enviar una peticion
  Para realizar el login de manera exitosa

  Scenario: Realizar login exitoso
    Given Envio la peticion POST
    |eve.holt@reqres.in|cityslickac|
    When recibo la respuesta del servicio
    Then podre validar el token

  Scenario: Realizar login fallido
    Given Envio la peticion POST
    |peter@klaven||
    When recibo la respuesta del servicio
    Then podre ver el mensaje de error


