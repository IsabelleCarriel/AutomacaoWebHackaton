package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name = "email")
    public WebElement campoEmailLogin;

    @FindBy(name = "password")
    public WebElement campoSenhaLogin;

    @FindBy(xpath = "//button[contains(text(),'Acessar')]")
    public WebElement botaoAcessar;


    public void preencherCampoEmailLogin(String email) {
        campoEmailLogin.sendKeys(email);
    }

    public void preencherCampoSenhaLogin(String senha) {
        campoSenhaLogin.sendKeys(senha);
    }

    public void clicarBotaoAcessar() {
        botaoAcessar.click();
    }


}
