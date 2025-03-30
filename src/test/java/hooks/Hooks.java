package hooks;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.framar.Constants.ACTOR_NAME;
import static org.framar.driverfactory.DriverFactory.selectDriver;

public class Hooks {
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    WebDriver driver;

    static Scenario scenario;

    @Before(order = 0)
    public void setUp(Scenario scenario) {
        Hooks.scenario = scenario;

        var browser = System.getProperty("browser", "chrome");
        driver = selectDriver(browser);

        if (!OnStage.theStageIsSet()) {
            OnStage.setTheStage(new OnlineCast());
        }

        var actor = OnStage.theActorCalled(ACTOR_NAME);
        actor.can(BrowseTheWeb.with(driver));
        driver.manage().window().maximize();
    }

    @After(order = 1)
    public void deleteDriver() {
        try {
            if (driver != null) driver.quit();
        } catch (Exception e) {
            logger.error("Error al cerrar el driver: ", e);
        }
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed())
            takeScreenshot();
    }

    @AfterStep
    public void takeScreenshot() {
        try {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "evidence");

        } catch (Exception e) {
            logger.error("Error al capturar evidencia", e);
        }
    }
}
