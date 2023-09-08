Feature: Como usuario quiero realizar una consulta para conocer la sintaxis gherkin
  Rule Buscar en google

  Background: Abrir el navegador
    Given Dado que el usuario abre el navegador
    When Carga el sitio web
    Then El usuario da clic en la barra de busqueda

  Scenario Outline: Buscar la sintaxis gherkin
    Given Dado ingresa la consulta de la <termino de busqueda>
    When El usuario realiza la busqueda
    Then El navegador despliega los resultados de la busqueda de <termino de busqueda esperado>
    Examples:
      | termino de busqueda | termino de busqueda esperado |
      | sintaxis gherkin    | Gherkin                      |
      | docker              | Docker                       |