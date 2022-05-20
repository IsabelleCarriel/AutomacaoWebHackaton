package stepsDefinitions;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static utils.Utils.*;


public class Hooks {

    @Before("@cenario1 and @cenario2")
    public void setUP() throws InterruptedException {
        openNewTab(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        capturarTela(scenario);
        driver.quit();

    }

}
