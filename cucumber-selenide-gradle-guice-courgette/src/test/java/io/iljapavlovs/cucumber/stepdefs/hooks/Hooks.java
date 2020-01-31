package io.iljapavlovs.cucumber.stepdefs.hooks;


import static java.lang.String.format;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import com.google.inject.Inject;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.iljapavlovs.cucumber.utils.EnvironmentConfig;
import java.io.File;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;

@Slf4j
public class Hooks {

  @Inject
  private EnvironmentConfig config;

  private BrowserWebDriverContainer browser;

  @Before
  public void setUpSelenium() {

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--window-size=1920,1080");
    if (config.getRunInContainer()) {
      browser = new BrowserWebDriverContainer()
          .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.SKIP, new File("build"))
          .withCapabilities(chromeOptions);
      browser.start();
      WebDriverRunner.setWebDriver(browser.getWebDriver());
    }

    if (config.getRemoteDriver()) {
      Configuration.remote = config.getRemoteDriverUrl();
    }

    String uiUrl = config.getAppUrl();

    log.info("UI - Initializing Selenide setup");

    log.info("UI URL: " + uiUrl);
    Configuration.baseUrl = uiUrl;

    Configuration.timeout = 8000;//default is 4000
    Configuration.driverManagerEnabled = true;
    //some Selenide Configuration settings does not work when providing own driver
    Configuration.startMaximized = true;
//    todo - setting does not affects window size when providing own driver in testcontainers
//    Configuration.browserSize = "1920x1080";
    Configuration.screenshots = true;
  }

  @After
  public void tearDownSelenium(Scenario scenario) throws Exception {
    if (scenario.isFailed() && WebDriverRunner.hasWebDriverStarted()) {
      File screenshot = Screenshots.takeScreenShotAsFile();
      byte[] generatedScreenshot = null;
      try {
        generatedScreenshot = FileUtils.readFileToByteArray(screenshot);
        scenario.embed(generatedScreenshot, "image/png");

      } catch (IOException e) {
        log.warn(e.getMessage());
      }

      File file = new File(format("target/screenshots/%s.png", scenario.getName()));
      log.info("Screenshot taken at " + file.getAbsolutePath());
      FileUtils.writeByteArrayToFile(file, generatedScreenshot);
    }
    log.info("UI - Closing browser");

    if (config.getRunInContainer()) {
      browser.stop();
    } else {
      WebDriverRunner.getWebDriver().quit();
    }
  }

}
