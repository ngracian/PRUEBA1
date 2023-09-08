package Pages;

import net.bytebuddy.asm.Advice;

public class GooglePage extends BasePage {
    private String url="https://www.google.com.mx/";
    private String BARRA_BUSQUEDA_GOOGLE = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea";
    private String BOTON_BUSQUEDA_GOOGLE = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[1]";

    private String PRIMER_RESULTADO_BUSQUEDA = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/a/h3";


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
    public void clickBarraBusquedaGoogle() {clickElement(BARRA_BUSQUEDA_GOOGLE);}
    public void capturarConsultaGoogle(String textoBusqueda){sendKeys(BARRA_BUSQUEDA_GOOGLE,textoBusqueda);}
    public void clickBotonBusquedaGoogle(){clickElement(BOTON_BUSQUEDA_GOOGLE);}
    public void enterBusquedaGoogle(){sendEnterKey(BARRA_BUSQUEDA_GOOGLE);}
    public String obtenerTextoPrimerElementoBusqueda(){return getText(PRIMER_RESULTADO_BUSQUEDA);
    }
}
