package stepsDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.hamcrest.core.StringContains;
import org.openqa.selenium.By;
import pageObjects.CadastroPage;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static utils.Utils.*;

public class CadastroSteps {


    @Dado("que acesso a pagina de login")
    public void queAcessoAPaginaDeLogin() {
        acessarSistema();
    }

    @E("clico no botao Registrar")
    public void clicoNoBotaoRegistrar() {
        Na(CadastroPage.class).clicarBotaoRegistrar();
    }

    @Quando("submeto o seguinte formulario de cadastro:")
    public void submetoOSeguinteFormularioDeCadastro(List<String> formulario) {

        Na(CadastroPage.class).preencherCampoEmail(formulario.get(4));
        Na(CadastroPage.class).preencherCampoNome(formulario.get(5));
        Na(CadastroPage.class).preencherCampoSenha(formulario.get(6));
        Na(CadastroPage.class).preencherCampoConfirmarSenha(formulario.get(7));
    }

    @E("clico no botao para acionar saldo")
    public void clicoNoBotaoParaAcionarSaldo() throws InterruptedException {
        Thread.sleep(500);
        Na(CadastroPage.class).clicarBotaoContaComSaldo();
    }

    @E("clico no botao Cadastrar")
    public void clicoNoBotaoCadastrar() {
        Na(CadastroPage.class).clicarBotaoCadastrar();
    }

    @Entao("vejo a mensagem que a conta foi {string}")
    public void vejoAMensagemQueAContaFoi(String mensagem1) throws InterruptedException {
        String textoMensagem1;

        Thread.sleep(500);
        textoMensagem1 = driver.findElement(By.xpath("//p[contains(text(),' criada com sucesso')]")).getText();
        assertThat(textoMensagem1, StringContains.containsString(mensagem1));
    }

    @Entao("vejo a mensagem de alerta: {string}")
    public void vejoAMensagemDeAlerta(String mensagem2) throws InterruptedException {
        String textoMensagem2;
        Thread.sleep(500);
        switch (mensagem2) {
            case "Formato Inválido":
            case "É campo obrigatório":
                textoMensagem2 = driver.findElement(By.xpath("//p [contains(text(),'" + mensagem2 + "')]")).getText();
                assertEquals(textoMensagem2, mensagem2);
                break;

            case "As senhas não são iguais.":
            case "Nome não pode ser vazio.":
                textoMensagem2 = driver.findElement(By.xpath("//*[@id='modalText']")).getText();
                assertEquals(textoMensagem2, mensagem2);
                break;
        }
    }


}
