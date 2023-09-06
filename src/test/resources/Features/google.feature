Feature: Como usuario quiero realizar una consulta para conocer la sintaxis gherkin
  Rule Buscar en google
  Background: Abrir el navegador
    Given Dado que el usuario abre el navegador
    When Carga el sitio web
    Then El usuario da clic en la barra de busqueda
    Scenario: Buscar la sintaxis gherkin
      Given Dado ingresa la consulta de la sintaxis gherkin
      When El usuario da clic en el boton de Buscar
      Then El navegador despliega los resultados de la busqueda de Gherkin

