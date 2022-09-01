package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LogInPage;
import pages.RegisterPage;
import utils.DataDriven;
import utils.PropertiesDriven;

import java.util.ArrayList;

public class Tests {

    //declarar atributos
    private WebDriver driver;
    private HomePage homePage;
    private LogInPage logInPage;
    private ArrayList<String> dataCPs;
    private RegisterPage registerPage;

    @BeforeTest
    public void preparacionesEjecucion(){
        //Instanciar los objetos

        dataCPs = new ArrayList<String>();

    }

    @BeforeMethod
    public void preparacionesPruebas(){
        homePage = new HomePage(driver);
        homePage.conexionDriver
                (PropertiesDriven.getProperty("browser"),
                        System.getProperty("user.dir")+PropertiesDriven.getProperty("rutaDriver"),
                        PropertiesDriven.getProperty("propertyDriver"));

        logInPage = new LogInPage(homePage.getDriver());
        registerPage = new RegisterPage(homePage.getDriver());
        homePage.cargarSitio(PropertiesDriven.getProperty("url"));
        homePage.maximizarBrowser();
    }

    @AfterMethod
    public void posPrueba(){
        homePage.cerrarBrowser();
    }

    @Test
    public void CP001_login_fallido_email_incorrecto(){
        //Preparar datos
        dataCPs = DataDriven.getData("CP001_login_fallido_email_incorrecto");
        homePage.irALogIn();
        logInPage.logIn(dataCPs.get(1), dataCPs.get(2));
        homePage.esperarXSegundos(1000);
        Assert.assertEquals(logInPage.obtenerErrorLogInEmail(),dataCPs.get(3));
    }

    @Test
    public void CP002_login_fallido_pass_incorrecta(){
        dataCPs = DataDriven.getData("CP002_login_fallido_pass_incorrecta");
        homePage.irALogIn();
        logInPage.logIn(dataCPs.get(1), dataCPs.get(2));
        homePage.esperarXSegundos(1000);
        Assert.assertEquals(logInPage.obtenerErrorLogInPassword(),dataCPs.get(3));
    }



    @Test
    public void CP004_registro_fallido_email_existente(){
        dataCPs = DataDriven.getData("CP004_registro_fallido_email_existente");
        homePage.irARegister();
        registerPage.registerCompleto(dataCPs.get(1), dataCPs.get(2),dataCPs.get(3),dataCPs.get(4),dataCPs.get(5), dataCPs.get(6));
        homePage.esperarXSegundos(1000);
        Assert.assertEquals(registerPage.obtenerErrorRegister(),dataCPs.get(7));
    }

    @Test
    public void CP005_registro_fallido_pass_confirm_diferente(){
        dataCPs = DataDriven.getData("CP005_registro_fallido_pass_confirm_diferente");
        homePage.irARegister();
        registerPage.registerCompleto(dataCPs.get(1), dataCPs.get(2),dataCPs.get(3),dataCPs.get(4),dataCPs.get(5), dataCPs.get(6));
        homePage.esperarXSegundos(1000);
        Assert.assertEquals(registerPage.obtenerErrorRegisterPasswordConfirm(),dataCPs.get(7));
    }

    @Test
    public void CP006_registro_fallido_pass_muy_corta(){
        dataCPs = DataDriven.getData("CP006_registro_fallido_pass_muy_corta");
        homePage.irARegister();
        registerPage.registerCompleto(dataCPs.get(1), dataCPs.get(2),dataCPs.get(3),dataCPs.get(4),dataCPs.get(5), dataCPs.get(6));
        homePage.esperarXSegundos(1000);
        Assert.assertEquals(registerPage.obtenerErrorRegisterPasswordTooShort(),dataCPs.get(7));
    }

    @Test
    public void CP007_registro_fallido_sin_datos(){
        dataCPs = DataDriven.getData("CP007_registro_fallido_sin_datos");
        homePage.irARegister();
        registerPage.registerCompleto("", "", "", "", "", "");
        homePage.esperarXSegundos(1000);
        Assert.assertEquals(registerPage.verificarMensajeError(dataCPs.get(1), dataCPs.get(2),dataCPs.get(3),dataCPs.get(4),dataCPs.get(5)), true);
    }

    @Test
    public void CP003_login_exitoso(){
        dataCPs = DataDriven.getData("CP003_login_exitoso");
        homePage.irALogIn();
        logInPage.logIn(dataCPs.get(1), dataCPs.get(2));
        homePage.esperarXSegundos(3000);
        Assert.assertEquals(homePage.btnLogOutVisible(), true);
    }

    @Test
    public void CP008_registro_exitoso(){
        dataCPs = DataDriven.getData("CP008_registro_exitoso");
        homePage.irARegister();
        registerPage.registerCompleto(dataCPs.get(1), dataCPs.get(2),dataCPs.get(3),dataCPs.get(4),dataCPs.get(5), dataCPs.get(6));
        homePage.esperarXSegundos(3000);
        Assert.assertEquals(homePage.btnLogOutVisible(), true);
    }
}
