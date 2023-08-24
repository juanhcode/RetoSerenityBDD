Feature: Obtener respuesta del servicio
  Yo como usuario
  Quiero realizar una peticion al servicio de traer un solo usuario
  Para obtener una respuesta correcta

  Scenario: Obtener respuesta existosa
    Given yo cuando hago una peticion al servicio
    When recibo una respuesta del servicio
    Then puedo validar de que el estado es correcto
