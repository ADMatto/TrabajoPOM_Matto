package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class HomePage extends BaseClass {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Localizadores y acciones de la pagina
    By locatorBtnRegister = By.xpath("//a[contains(text(),'Register')]");
    By locatorBtnLogIn = By.xpath("//a[contains(text(),'Log in')]");

    By locatorBtnLogOut = By.xpath("//a[contains(text(),'Log out')]");

    //Menu
    By locatorBtnMenuBooks = By.xpath(".//a[@href=\"/books\"][1]");
    By locatorBtnMenuComputers = By.xpath(".//a[@href=\"/computers\"][1]");
    By locatorBtnMenuElectronics = By.xpath(".//a[@href=\"/electronics\"][1]");
    By locatorBtnMenuApparelShoes = By.xpath(".//a[@href=\"/apparel-shoes\"][1]");
    By locatorBtnMenuDigitalDownload = By.xpath(".//a[@href=\"/digital-downloads\"][1]");
    By locatorBtnMenuJewelry = By.xpath(".//a[@href=\"/jewelry\"][1]");
    By locatorBtnMenuGiftCards = By.xpath(".//a[@href=\"/gift-cards\"][1]");

    public void irALogIn(){
        click(esperaExplicita(locatorBtnLogIn));
    }
    public void irARegister(){
        click(esperaExplicita(locatorBtnRegister));
    }

    public boolean btnLogOutVisible(){
        try{
            driver.findElements(locatorBtnLogOut);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public void usarMenu(String boton){
        switch (boton){
            case "books": click(esperaExplicita(locatorBtnMenuBooks));
            case "computers": click(esperaExplicita(locatorBtnMenuComputers));
            case "electronics": click(esperaExplicita(locatorBtnMenuElectronics));
            case "apparel": click(esperaExplicita(locatorBtnMenuApparelShoes));
            case "digital": click(esperaExplicita(locatorBtnMenuDigitalDownload));
            case "jewelry": click(esperaExplicita(locatorBtnMenuJewelry));
            case "giftcard": click(esperaExplicita(locatorBtnMenuGiftCards));
        }
    }
}
