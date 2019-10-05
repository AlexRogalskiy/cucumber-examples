##
In this example see how ChromeContainer is injected

## RESOURCES
* [Official Readme - how to use Spring for DI in Cucumber](https://github.com/cucumber/cucumber-jvm/tree/master/spring)
* [End-to-End Microservice Tests with Cucumber](https://thepracticaldeveloper.com/2017/08/03/microservices-end-to-end-tests-with-cucumber-and-spring-boot/)
* [Cucumber Tests in Spring Boot with Dependency Injection](https://thepracticaldeveloper.com/2018/03/31/cucumber-tests-spring-boot-dependency-injection/)
* [Spring boot example project with kotlin](https://github.com/dsobko/com.dsobko.springboot.bigquery)



* [Spring Boot and Cucumber Tests](https://medium.com/@bcarunmail/set-up-and-run-cucumber-tests-in-spring-boot-application-d0c149d26220)
    * https://github.com/bcarun/cucumber-samples/tree/master/hello-springboot-cucumber
    * JPA with One to Many relation, Hibernate and @Transactional
    * Mapstruct
    * Lombok
    * H2 db
    * **Cucumber**:
        * TypeRegistryConfigurer (CucumberTypeRegistryConfigurer) - from DataTable to Model via Jackson
        * cucumber-reporting from `net.masterthought` configuration
        > 1.If you decide to use Cucumber Report plugin configured above, replace ‘@RunWith(Cucumber.class)’ with ‘@RunWith(CucumberReportRunner.class)’ in CucumberTest.java file.
          2. CucumberReportRunner.java extends Cucumber.java
          3. CucumberReportRunner generates reports from the file at target/cucumber-report.json
          4. CucumberReportRunner copies the generated html reports to target/classes/static directory so that the reports are packaged along with the application.
```
public class CucumberReportRunner extends Cucumber {

  // Can be dynamically pulled from CI Server
  private static final String PROJECT_NAME = "Hello Cucumber & Spring Boot";
  private static final String BUILD_NUMBER = "1.0.0";
  private static final String BRANCH_NAME = "master";

  public CucumberReportRunner(Class clazz) throws InitializationError {
    super(clazz);
  }

  @Override
  public void run(RunNotifier notifier) {
    super.run(notifier);
    generateReport();
  }

  public static void generateReport() {

    File reportOutputDirectory = new File("target/classes/static");
    List<String> jsonFiles = new ArrayList<>();
    jsonFiles.add("target/cucumber-report.json");

    // set values from respective build tool
    Configuration configuration = new Configuration(reportOutputDirectory, PROJECT_NAME);
    configuration.setBuildNumber(BUILD_NUMBER);
    configuration.addClassifications("Build Number", configuration.getBuildNumber());
    configuration.addClassifications("Branch Name", BRANCH_NAME);

    ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
    reportBuilder.generateReports();
  }
}
```
