package io.iljapavlovs.cucumber.plugins;

import cucumber.api.event.ConcurrentEventListener;
import cucumber.api.event.EventHandler;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestRunStarted;
import cucumber.runtime.CucumberException;
import java.io.File;

public class ReportThingy implements ConcurrentEventListener {
  private File reportDir;

  public ReportThingy(String outputDir) {
    createOutputDir(outputDir);
  }

  private void createOutputDir(String outputDir) {
    reportDir = new File(outputDir);
    if (!reportDir.exists() && !reportDir.mkdirs()) {
      throw new CucumberException("Failed to create dir: " + outputDir);
    }
  }

  private EventHandler<TestRunStarted> runStartedHandler = new EventHandler<TestRunStarted>() {
    @Override
    public void receive(TestRunStarted event) {
      startReport(event);
    }
  };

  @Override
  public void setEventPublisher(EventPublisher publisher) {
    publisher.registerHandlerFor(TestRunStarted.class, runStartedHandler);
  }

  private void startReport(TestRunStarted event) {
    System.out.println("STARTING REPORT INSIDE PLUGIN!!!!!!!!!!!!! " + event.getTimeStampMillis());
  }
}
