package lv.iljapavlovs.cucumber.hooks;


import lv.iljapavlovs.cucumber.core.DriverBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Hooks {

    @Before
    public void setup(Scenario scenario) throws Exception {
        DriverBase.instantiateDriverObject();
        String sessionId = ((RemoteWebDriver) DriverBase.getDriver()).getSessionId().toString();
        System.out.println("Starting Scenario: \""+ scenario.getName() +"\" with Session ID: " + sessionId);
        DriverBase.getDriver().manage().deleteAllCookies();
        DriverBase.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) DriverBase.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
        String sessionId = ((RemoteWebDriver)DriverBase.getDriver()).getSessionId().toString();
        System.out.println("Ending Scenario: \""+scenario.getName() +"\" with Session ID: " + sessionId);
        DriverBase.closeDriverObjects();
    }
}
