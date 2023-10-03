package Pages;

import net.bytebuddy.asm.Advice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GooglePage extends BasePage {
    private String url="https://www.google.com.mx/";
    private String BARRA_BUSQUEDA_GOOGLE = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea";
    private String BOTON_BUSQUEDA_GOOGLE = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[1]";

    private String PRIMER_RESULTADO_BUSQUEDA = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/a/h3";
    private By RESULTADOS_SELECTOR = By.cssSelector("h3");

    private static final Logger logger = LogManager.getLogger(BasePage.class);

    /**
     * Constructor para la pagina web
     *
     * @param driver parametro driver define un objeto de driver maneja el navegador y es configurable
     */
    public GooglePage() {
        super(driver);
    }
    public void ejecutarNavegador(){
        try {
            abrirNavegador();
        }catch (Exception e){
            logger.error("Error al abrir el navegador: " + driver.toString(), e);
        }
    }
    public void abrirPaginaGoogle(){
        try {
            abrirPagina(url);
        }catch (Exception e){
            logger.error("Error al abrir la url: " + url, e);
        }
    }
    public void terminarNavegador(){
        try {
            cerrarNavegador();
        }catch (Exception e){
            logger.error("Error al cerrar el navegador: " + driver.toString(), e);
        }
    }
    public void clickBarraBusquedaGoogle() {
        try{
            clickElement(BARRA_BUSQUEDA_GOOGLE);
        }catch (Exception e){
            logger.error("Error en la barra de busqueda: " + BARRA_BUSQUEDA_GOOGLE, e);
        }
    }
    public void capturarConsultaGoogle(String textoBusqueda){
        try{
            sendKeys(BARRA_BUSQUEDA_GOOGLE,textoBusqueda);
        }catch (Exception e){
            logger.error("Error en el web element: " + BARRA_BUSQUEDA_GOOGLE, e);
        }
    }
    public void clickBotonBusquedaGoogle(){
        try{
            clickElement(BOTON_BUSQUEDA_GOOGLE);
        }catch (Exception e){
            logger.error("Error en el botón de busqueda de google: " + BOTON_BUSQUEDA_GOOGLE, e);
        }
    }
    public void enterBusquedaGoogle(){
        try{
            sendEnterKey(BARRA_BUSQUEDA_GOOGLE);
        }catch (Exception e){
            logger.error("Error al dar enter en la barra de busqueda: " + BARRA_BUSQUEDA_GOOGLE, e);
        }
    }
    public String obtenerTextoPrimerElementoBusqueda(){
        try {
            return getText(PRIMER_RESULTADO_BUSQUEDA);
        }catch (Exception e){
            logger.error("Error al obtener primer resultado de busqueda: " + PRIMER_RESULTADO_BUSQUEDA, e);
        }
        //preguntar si esto es correcto, ya que pedía que indicara un return en esta parte.
        return null;
    }
    public List<String> iterarResultadosGoogle(){
        try {
            List<String> resultados = new ArrayList<>();
            List<WebElement> resultadosBusqueda = driver.findElements(RESULTADOS_SELECTOR);
            for (WebElement resultadosPaginaUno : resultadosBusqueda) {
                resultados.add(resultadosPaginaUno.getText());
            }
            return resultados;
        }catch (Exception e){
            logger.error("Error al iterar sobre los resultados web: " + driver.toString(), e);
        }
        //preguntar si esto es correcto, ya que pedía que indicara un return en esta parte.
        return null;
    }
}
