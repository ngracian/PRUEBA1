package Pages;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.lang.reflect.Constructor;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase contiene los métodos para poder realizar acciones en un navegador
 * {@code @author:} Ngracian
 * {@code @version:} 1.0-10/08/2023
 */
public class BasePage {
    //Campos de la clase
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Duration durationtimeout;
    protected static Duration durationsleep;
    private static final Logger logger = LogManager.getLogger(BasePage.class);

    static {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setAcceptInsecureCerts(true);
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        durationtimeout = Duration.ofSeconds(10);
        durationsleep = Duration.ofSeconds(100);
        wait = new WebDriverWait(driver, durationtimeout, durationsleep);

    }

    /**
     * Constructor para la pagina web
     *
     * @param driver parametro driver define un objeto de driver maneja el navegador y es configurable
     */
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, durationtimeout, durationsleep);
    }//Cierre del constructor

    /**
     * Método que abre el navagador y lo maximiza en toda la pantalla
     */
    public static void abrirNavegador() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.setAcceptInsecureCerts(true);
            // options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
    }

    /**
     * Método que accede a una pagina especifica
     *
     * @param url el parametro url define la liga en la que se abrira el navegador
     */
    public static void abrirPagina(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            System.out.println("No se pudo acceder a la url: " + url + " validar url solicitada");
            throw new RuntimeException(e);
        }
    }

    /**
     * Método que cierra el navegador
     */
    public static void cerrarNavegador() {
        try {
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }catch (Exception e){
            logger.error("Error al cerrar el navegador o borrar cookies",e);
            throw new RuntimeException("No se pudo cerrar el navegador correctamente",e);
        }
    }

    public void clickElement(String locator) {
        try{
            find(locator).click();
        }catch (Exception e){
            logger.error("Error en el localizador o al hacer clic en el elemento: " + locator,e);
            throw new RuntimeException("No se pudo dar clic en el elemento con el localizador: " + locator,e);
        }
    }

    /**
     * Método que espera hasta que aparezca el elemento locator
     *
     * @param locator el parámetro de la ruta del elemento a esperar
     */
    private WebElement find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    /**
     * Método que espera hasta que aparezca la lista de resultados
     *
     * @param selector el parametro el parámetro de la ruta del elemento a esperar en css
     */
    private WebElement findByCSSelector(By selector) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    /**
     * Método que captura la consulta en google
     *
     * @param inputText el parametro tiene la consulta a realizar
     */
    public void sendKeys(String locator, String inputText) {
        find(locator).sendKeys(inputText);
    }

    public String getText(String locator) {
        return find(locator).getText();
    }

    public void sendEnterKey(String locator) {
        find(locator).sendKeys(Keys.ENTER);
    }

    public void getTextByCSSelector(By selector) {
        try {
            findByCSSelector(selector).getText();
        }
        catch (Exception e){
            logger.error("Error en el selector CSS o al hacer clic en el elemento: " + selector,e);
            throw new RuntimeException("No se pudo dar clic en el elemento con el selector CSS: " + selector,e);
        }
    }
    protected List<String> getListByCSSelector(By selector){
        List<String> listaTextos = new ArrayList<>();
        try{
            List<WebElement> elementosWeb = driver.findElements(selector);
            for (WebElement elemento:elementosWeb){
                listaTextos.add(elemento.getText());
            }
        }catch (Exception e){
            logger.error("Error al iterar sobre los elementos web con selecctor: " + selector.toString(), e);
        }
        return listaTextos;
    }

    protected String getTextFirstElementWeb(By selector){
        try{
            WebElement primerElementoBusqueda = esperaObtenerPrimerElemento(selector);
            return waitAndGetText(primerElementoBusqueda);
        }catch(TimeoutException e){
            logger.error("Tiempo de espera excedido para encontrar el selector: " + selector.toString(), e);
        }
        catch(Exception e){
            logger.error("Error al obtener el primer elemento con el selector: " + selector.toString(), e);
        }
    }

    private WebElement esperaObtenerPrimerElemento(By selector){
        
    }


}//Cierre de la clase
