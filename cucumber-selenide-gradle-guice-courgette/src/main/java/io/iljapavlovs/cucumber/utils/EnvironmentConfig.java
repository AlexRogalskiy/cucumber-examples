package io.iljapavlovs.cucumber.utils;

import lv.neotech.tests.configuration.TestConfiguration;

public class EnvironmentConfig extends TestConfiguration {


  private static final String SELENIDE_RUN_IN_CONTAINER = "selenide.runInContainer";

  private static final String RECORDING_MODE = "recordingMode";





  private static final String SELENIDE_IS_REMOTE_DRIVER = "selenide.isRemoteDriver";
  private static final String SELENIDE_REMOTE_DRIVER_URL = "selenide.remoteDriver.url";
  private static final String APP_URL = "selenide.remoteDriver.url";


  public boolean getRemoteDriver() {
    return getBoolean(SELENIDE_IS_REMOTE_DRIVER, true);
  }

  public void setRemoteDriver(boolean remoteDriver) {
    setProperty(SELENIDE_IS_REMOTE_DRIVER, remoteDriver);
  }

  public String getAppUrl() {
    return getString(APP_URL, "http://google.com");
  }

  public void setAppUrl(String appUrl) {
    setProperty(APP_URL, appUrl);
  }

  public String getRemoteDriverUrl() {
    return getString(SELENIDE_IS_REMOTE_DRIVER, "http://localhost:4444");
  }

  public void setRemoteDriverUrl(String remoteDriverUrl) {
    setProperty(SELENIDE_IS_REMOTE_DRIVER, remoteDriverUrl);
  }

  public boolean getRunInContainer() {
    return getBoolean(SELENIDE_RUN_IN_CONTAINER, false);
  }

  public void setRunInContainer(boolean isRunInContainer) {
    setProperty(SELENIDE_RUN_IN_CONTAINER, isRunInContainer);
  }
}

