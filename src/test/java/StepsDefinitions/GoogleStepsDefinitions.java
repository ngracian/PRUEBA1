package StepsDefinitions;

import Pages.GooglePage;
import io.cucumber.java.en.*;

public class GoogleStepsDefinitions {
    GooglePage googlePage = new GooglePage();
    @Given("^Dado que el usuario abre el navegador$")
    public void dado_que_el_usuario_abre_el_navegador() {
        googlePage.ejecutarNavegador();
    }
    @When("^Carga el sitio web$")
    public void carga_el_sitio_web() {
        googlePage.abrirPaginaGoogle();
    }
    @Then("^El usuario da clic en la barra de busqueda$")
    public void el_usuario_da_clic_en_la_barra_de_busqueda() {
        googlePage.clickBarraBusquedaGoogle();
    }
    @Given("^Dado ingresa la consulta de la sintaxis gherkin$")
    public void dado_ingresa_la_consulta_de_la_sintaxis_gherkin() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("^El usuario da clic en el boton de Buscar$")
    public void el_usuario_da_clic_en_el_boton_de_buscar() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("^El navegador despliega los resultados$")
    public void el_navegador_despliega_los_resultados() {
     googlePage.terminarNavegador();
    }

}
