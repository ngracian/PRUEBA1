package StepsDefinitions;

import Pages.GooglePage;
import io.cucumber.java.en.*;
import org.junit.Assert;

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
    @Given("^Dado ingresa la consulta de la (.+)$")
    public void dado_ingresa_la_consulta_de_la_sintaxis_gherkin(String textoBusqueda) {googlePage.capturarConsultaGoogle(textoBusqueda); }
    @When("^El usuario realiza la busqueda$")
    public void el_usuario_realiza_la_busqueda() {googlePage.enterBusquedaGoogle();}
    @Then("^El navegador despliega los resultados de la busqueda de (.+)$")
    public void el_navegador_despliega_los_resultados(String textoBuscado) {
        String resultadoEsperado = textoBuscado;
        String resultadoReal = googlePage.obtenerTextoPrimerElementoBusqueda();
        System.out.println("R.E.: " + resultadoEsperado);
        System.out.println("R.R.: " + resultadoReal);
        Assert.assertTrue("Comparación de resultado esperado vs resultado real en la búsqueda: ", resultadoReal.contains(resultadoEsperado));
        //googlePage.terminarNavegador();
    }

}
