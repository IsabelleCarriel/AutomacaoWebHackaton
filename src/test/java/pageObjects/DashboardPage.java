package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DashboardPage {

    @FindBy(id = "btn-TRANSFERÊNCIA")
    public WebElement botaoTransferencia;

    @FindBy(name = "accountNumber")
    public WebElement campoNumeroConta;

    @FindBy(name = "digit")
    public WebElement campoDigitoConta;

    @FindBy(name = "transferValue")
    public WebElement campoValorTransferencia;

    @FindBy(name = "description")
    public WebElement campoDescricao;

    @FindBy(xpath = "//button[contains(text(),'Transferir agora')]")
    public WebElement botaoTransferir;

    @FindBy(xpath = "//*[@id=\"textAccountNumber\"]/span")
    public WebElement numeroConta;

    public void clicarBotaoTransferencia() {
        botaoTransferencia.click();
    }

    public void preencherNumeroConta() {
        campoNumeroConta.sendKeys("111P");
    }

    public void preencherDigitoConta() {
        campoDigitoConta.sendKeys("1");
    }

    public void preencherValorTranferencia() {
        campoValorTransferencia.sendKeys("100");
    }

    public void preencherDescricao() {
        campoDescricao.sendKeys("Parabens");
    }

    public void clicarBotaoTransferir() {
        botaoTransferir.click();
    }

    public List<String> obterNumeroConta() {

        String numeroDaConta = numeroConta.getText();

        List<String> numeroDaContaSeparado = new ArrayList<String>(Arrays.asList(numeroDaConta.split("-")));

        return numeroDaContaSeparado;
    }

}
