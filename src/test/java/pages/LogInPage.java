package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class LogInPage extends BaseClass {
    public LogInPage(WebDriver driver) {
        super(driver);
    }

    // Localizadores
    By locatorTxtEmail = By.xpath("//input[@id='Email']");
    By locatorTxtPassword = By.xpath("//input[@id='Password']");
    By locatorBtnLogIn = By.xpath("//input[@class='button-1 login-button']");
    By locatorLblErrorLogin = By.xpath("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]");
    By locatorLblErrorLoginEmail = By.xpath("//li[contains(text(),'No customer account found')]");
    By locatorLblErrorLoginPassword = By.xpath("//li[contains(text(),'The credentials provided are incorrect')]");

    // Acciones
    public void logIn(String email, String password){
        agregarTexto(esperaExplicita(locatorTxtEmail),email);
        agregarTexto(esperaExplicita(locatorTxtPassword),password);
        click(esperaExplicita(locatorBtnLogIn));
    }

    public String obtenerErrorLogInEmail(){
        return obtenerTexto(esperaExplicita(locatorLblErrorLoginEmail));
    }

    public String obtenerErrorLogInPassword(){
        return obtenerTexto(esperaExplicita(locatorLblErrorLoginPassword));
    }
}
