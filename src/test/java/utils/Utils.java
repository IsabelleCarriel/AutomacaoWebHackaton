package utils;

import io.cucumber.core.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static WebDriver driver;

    public static void acessarSistema(){
        //verifica a versão mais recente do binário WebDriver especificado.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://bugbank.netlify.app/");
    }

    public static  <T> T Na(Class<T> classe){
        return PageFactory.initElements(driver, classe);
    }


    public static void openNewTab(WebDriver driver) throws InterruptedException {

        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_T);
        } catch (AWTException ex) {
            throw new WebDriverException("Erro ao digitar CTRL + T", ex);
        }

        Thread.sleep(2000);

        String winHandleBefore = driver.getWindowHandle();

        for(String winHandle : driver.getWindowHandles())  // Switch to new opened window
            driver.switchTo().window(winHandle);

        driver.navigate().to("https://bugbank.netlify.app/");
    }

    public static void capturarTela(Scenario scenario){
        final byte[] screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }
}
