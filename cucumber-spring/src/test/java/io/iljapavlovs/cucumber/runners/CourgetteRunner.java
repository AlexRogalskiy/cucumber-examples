//package io.iljapavlovs.cucumber.runners;
//
//
//import cucumber.api.CucumberOptions;
//import org.junit.runner.RunWith;
//
//@RunWith(Courgette.class)
//@CourgetteOptions(
//    threads = 3,
//    runLevel = CourgetteRunLevel.SCENARIO,
//    rerunFailedScenarios = true,
//    showTestOutput = true,
//    reportTargetDir = "build",
//    cucumberOptions = @CucumberOptions(
//        features = "src/test/resources/features",
//        glue = "io.iljapavlovs.cucumber.stepdefs",
//        tags = {"@all"},
//        plugin = {
//            "pretty",
//            "json:build/cucumber-report/cucumber.json",
//            "html:build/cucumber-report/cucumber.html",
//            "junit:build/cucumber-report/cucumber.xml"}
//    ))
//public class CourgetteRunner {
//  @CourgetteBeforeAll
//  public static void setUp() {
//    System.out.println("I will run before any tests execute");
//  }
//
//  @CourgetteAfterAll
//  public static void tearDown() {
//    System.out.println("I will run after all of the tests execute");
//  }
//}
