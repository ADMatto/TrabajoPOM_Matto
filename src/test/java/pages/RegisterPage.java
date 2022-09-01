package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class RegisterPage extends BaseClass {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //Localizadores
    By locatorChkMale = By.id("gender-male");
    By locatorChkFemale = By.id("gender-female");
    By locatorTxtFirstName = By.name("FirstName");
    By locatorTxtLastName = By.name("LastName");
    By locatorTxtEmail = By.name("Email");
    By locatorTxtPassword = By.name("Password");
    By locatorTxtConfirmPassword = By.name("ConfirmPassword");
    By locatorBtnRegister = By.id("register-button");
    By locatorLblRegisterErrorExist = By.xpath("//li[contains(text(),'The specified email already exists')]");
    By locatorLblRegisterErrorPasswordConfirm = By.xpath("//span[contains(text(),'The password and confirmation password do not matc')]");
    By locatorLblRegisterErrorPasswordTooShort = By.xpath("//span[contains(text(),'The password should have at least 6 characters.')]");

    By locatorLblRegisterErrorNoFirstName = By.xpath("//span[contains(text(),'First name is required.')]");
    By locatorLblRegisterErrorNoLastName = By.xpath("//span[contains(text(),'Last name is required.')]");
    By locatorLblRegisterErrorNoEmail = By.xpath("//span[contains(text(),'Email is required.')]");
    By locatorLblRegisterErrorNoPassword = By.xpath("//span[@for=\"Password\"]");
    By locatorLblRegisterErrorNoConfirmPassword = By.xpath("//span[@for=\"ConfirmPassword\"]");


    //Acciones
    public void registerCompleto(String gender, String firstName, String lastName, String email, String password, String confirmPassword){
        if (gender == "male"){
            click(locatorChkMale);
        } else if (gender == "female") {
            click(locatorChkFemale);
        }
        agregarTexto(esperaExplicita(locatorTxtFirstName), firstName);
        agregarTexto(esperaExplicita(locatorTxtLastName), lastName);
        agregarTexto(esperaExplicita(locatorTxtEmail), email);
        agregarTexto(esperaExplicita(locatorTxtPassword), password);
        agregarTexto(esperaExplicita(locatorTxtConfirmPassword), confirmPassword);
        click(esperaExplicita(locatorBtnRegister));
    }

    public String obtenerErrorRegister(){
        return obtenerTexto(esperaExplicita(locatorLblRegisterErrorExist));
    }

    public String obtenerErrorRegisterPasswordConfirm(){
        return obtenerTexto(esperaExplicita(locatorLblRegisterErrorPasswordConfirm));
    }

    public String obtenerErrorRegisterPasswordTooShort(){
        return obtenerTexto(esperaExplicita(locatorLblRegisterErrorPasswordTooShort));
    }

    public boolean verificarMensajeError(String firstNameError, String lastNameError, String emailError, String passwordError, String confirmPasswordError){
        if (firstNameError.equals(obtenerTexto(esperaExplicita(locatorLblRegisterErrorNoFirstName))) &&
        lastNameError.equals(obtenerTexto(esperaExplicita(locatorLblRegisterErrorNoLastName))) &&
        emailError.equals(obtenerTexto(esperaExplicita(locatorLblRegisterErrorNoEmail))) &&
        passwordError.equals(obtenerTexto(esperaExplicita(locatorLblRegisterErrorNoPassword))) &&
        confirmPasswordError.equals(obtenerTexto(esperaExplicita(locatorLblRegisterErrorNoConfirmPassword)))){
            return true;
        }else return false;
    }
}
