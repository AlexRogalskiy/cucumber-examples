package io.iljapavlovs.cucumber.utils;

import cucumber.api.junit.Cucumber;
import java.io.IOException;
import org.junit.runners.model.InitializationError;

public class ProfiledCucumberRunner extends Cucumber {

  public ProfiledCucumberRunner(Class clazz) throws InitializationError, IOException {
    super(clazz);
  }

// CUcumber no longer supports extending Cucumber, use plugins instead
//  @Override
//  protected Runtime createRuntime(ResourceLoader resourceLoader, ClassLoader classLoader, RuntimeOptions runtimeOptions)
//      throws InitializationError, IOException {
//    TestClass testClass = getTestClass();
//    TestEnvironmentProfile environmentProfile = testClass.getAnnotation(TestEnvironmentProfile.class);
//
//    checkState(environmentProfile != null && isNotBlank(environmentProfile.name()),
//        "Environment profile definition in @%s is missing", TestEnvironmentProfile.class.getSimpleName());
//
//    GlobalTestSettings.setEnvironment(environmentProfile.name());
//    GlobalTestSettings.setConfigFile(environmentProfile.configFile());
//
//    return super.createRuntime(resourceLoader, classLoader, runtimeOptions);
//  }

}
