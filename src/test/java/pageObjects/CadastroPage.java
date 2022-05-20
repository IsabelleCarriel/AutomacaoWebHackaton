package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastroPage {

    @FindBy(xpath = "//button[contains(text(),'Registrar')]")
    public WebElement botaoRegistrar;

    @FindBy(xpath = "//*[@id='__next']//form/div[2]/input")
    public WebElement campoEmail;

    @FindBy(name = "name")
    public WebElement campoNome;

    @FindBy(xpath = "//*[@id='__next']//form/div[4]//input")
    public WebElement campoSenha;

    @FindBy(name = "passwordConfirmation")
    public WebElement campoConfirmarSenha;

    @FindBy(id = "toggleAddBalance")
    public WebElement botaoContaSaldo;

    @FindBy(xpath = "//button[contains(text(),'Cadastrar')]")
    public WebElement botaoCadastrar;


    public void clicarBotaoRegistrar() {
        botaoRegistrar.click();
    }

    public void preencherCampoEmail(String email) {
        campoEmail.sendKeys(email);
    }

    public void preencherCampoNome(String nome) {

        campoNome.sendKeys(nome);
    }

    public void preencherCampoSenha(String senha) {

        campoSenha.sendKeys(senha);
    }

    public void preencherCampoConfirmarSenha(String confirmacaoSenha) {
        campoConfirmarSenha.sendKeys(confirmacaoSenha);
    }

    public void clicarBotaoContaComSaldo() {
        botaoContaSaldo.click();
    }

    public void clicarBotaoCadastrar() {
        botaoCadastrar.click();
    }

}
