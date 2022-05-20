package stepsDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.hamcrest.core.StringContains;
import org.openqa.selenium.By;
import pageObjects.LoginPage;

import static org.junit.Assert.assertThat;
import static utils.Utils.*;

public class LoginSteps {

    @Quando("digito no campo email {string}")
    public void digitoNoCampoEmail(String email)  {
        Na(LoginPage.class).preencherCampoEmailLogin(email);
    }

    @E("digito no campo senha {string}")
    public void digitoNoCampoSenha(String senha) {
        Na(LoginPage.class).preencherCampoSenhaLogin(senha);
    }

    @E("clico no botao Acessar")
    public void clicoNoBotaoAcessar() {
        Na(LoginPage.class).clicarBotaoAcessar();
    }

    @Entao("vejo a menssagem de alerta {string}")
    public void vejoAMenssagemDeAlerta(String mensagemAlerta) throws InterruptedException {
        String textoMensagemA;

        Thread.sleep(500);
        textoMensagemA = driver.findElement(By.xpath("//p[contains(text(),'Usuário ou senha inválido.')]")).getText();
        assertThat(textoMensagemA, StringContains.containsString(mensagemAlerta));
    }


    @Dado("que abro uma nova aba")
    public void queAbroUmaNovaAba() throws InterruptedException {
        openNewTab(driver);
    }


}
