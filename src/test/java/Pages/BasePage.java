package Pages;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.lang.reflect.Constructor;
import java.time.Duration;

/**
 *Esta clase contiene los metodos para poder realizar acciones en un navegador
 * @author: Ngracian
 * @version:  1.0-10/08/2023
 */
public class BasePage {
    //Campos de la clase
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Duration durationtimeout;
    protected static Duration durationsleep;

    static {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setAcceptInsecureCerts(true);
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        durationtimeout = Duration.ofSeconds(10);
        durationsleep = Duration.ofSeconds(100);
        wait = new WebDriverWait(driver,durationtimeout, durationsleep);

    }

    /**
     * Constructor para la pagina web
     * @param driver parametro driver define un objeto de driver maneja el navegador y es configurable
     */
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, durationtimeout, durationsleep);
    }//Cierre del constructor

    /**
     * Método que abre el navagador y lo maximiza en toda la pantalla
     */
    public static void abrirNavegador(){
        if(driver == null){
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
     * @param url el parametro url define la liga en la que se abrira el navegador
     */
    public static void abrirPagina(String url){
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
    public static void cerrarNavegador(){
        driver.manage().deleteAllCookies();
        driver.quit();
        driver = null;
    }

    public void clickElement(String locator){
        find(locator).click();
    }

    /**
     * Método que espera hasta que aparezca el elemento locator
     * @param locator el parámetro de la ruta del elemento a esperar
     */
    private WebElement find (String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    /**
     * Método que captura la consulta en google
     *  @param inputText el parametro tiene la consulta a realizar
     */
    public void sendKeys(String locator, String inputText){
        find(locator).sendKeys(inputText);
    }

    public String getText(String locator){
        return find(locator).getText();
    }
    public void sendEnterKey(String locator){
        find(locator).sendKeys(Keys.ENTER);
    }

}//Cierre de la clase
