package stepsDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import pageObjects.CadastroPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static utils.Utils.*;

public class DashboardStep {

    @Dado("que faco um cadastro com os dados:")
    public void queFacoUmCadastro(List<String> formulario) throws InterruptedException {
        acessarSistema();
        Na(CadastroPage.class).clicarBotaoRegistrar();

        Na(CadastroPage.class).preencherCampoEmail(formulario.get(4));
        Na(CadastroPage.class).preencherCampoNome(formulario.get(5));
        Na(CadastroPage.class).preencherCampoSenha(formulario.get(6));
        Na(CadastroPage.class).preencherCampoConfirmarSenha(formulario.get(7));

        Thread.sleep(500);
        Na(CadastroPage.class).clicarBotaoContaComSaldo();

        Na(CadastroPage.class).clicarBotaoCadastrar();
    }

    @E("faco login com as credencias {string} e {string}")
    public void facoLoginComAsCredenciasE(String email, String senha) {
        Na(LoginPage.class).preencherCampoEmailLogin(email);
        Na(LoginPage.class).preencherCampoSenhaLogin(senha);
        Na(LoginPage.class).clicarBotaoAcessar();
    }

    @E("sou redirecionado para o Dashboard")
    public void souRedirecionadoParaODashboard() {
        assertEquals("TRANSFERÊNCIA", driver.findElement(By.xpath("//div[3]/div[2]/div[1]/p")).getText());
    }

    @Quando("faco uma transferencia com dados invalidos")
    public void transferenciaComDadosIncorretos() {
        Na(DashboardPage.class).clicarBotaoTransferencia();
        Na(DashboardPage.class).preencherNumeroConta();
        Na(DashboardPage.class).preencherDigitoConta();
        Na(DashboardPage.class).preencherValorTranferencia();
        Na(DashboardPage.class).preencherDescricao();
        Na(DashboardPage.class).clicarBotaoTransferir();

    }

    @Entao("vejo a mensagem de alerta {string}")
    public void vejoAMensagemDeAlerta(String mensagemAlerta) throws InterruptedException {
        Thread.sleep(500);
        switch (mensagemAlerta) {
            case "Conta inválida ou inexistente":
                assertEquals(mensagemAlerta, driver.findElement(By.id("modalText")).getText());
                break;

            case "Nao pode transferir pra mesmo conta": {
                assertEquals(mensagemAlerta, driver.findElement(By.id("modalText")).getText());
            }
        }
    }

    @Quando("faco uma transferencia com meus dados")
    public void facoUmaTransferenciaComMeusDados() {
        List<String> numeroConta = new ArrayList();
        numeroConta = Na(DashboardPage.class).obterNumeroConta();

        Na(DashboardPage.class).clicarBotaoTransferencia();
        Na(DashboardPage.class).campoNumeroConta.sendKeys(numeroConta.get(0));
        Na(DashboardPage.class).campoDigitoConta.sendKeys(numeroConta.get(1));
        Na(DashboardPage.class).preencherValorTranferencia();
        Na(DashboardPage.class).preencherDescricao();
        Na(DashboardPage.class).clicarBotaoTransferir();

    }
}
