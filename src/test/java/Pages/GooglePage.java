package Pages;

import org.openqa.selenium.WebDriver;

public class GooglePage extends BasePage {
    private String url="https://www.google.com.mx/";


    /**
     * Constructor para la pagina web
     *
     * @param driver parametro driver define un objeto de driver maneja el navegador y es configurable
     */
    public GooglePage() {
        super(driver);
    }
    public void ejecutarNavegador(){
        abrirNavegador();
    }
    public void abrirPaginaGoogle(){
        abrirPagina(url);
    }
    public void terminarNavegador(){
        cerrarNavegador();
    }
}
