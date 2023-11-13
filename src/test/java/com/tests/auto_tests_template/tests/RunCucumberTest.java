package com.tests.auto_tests_template.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = {"com.tests.auto_tests_template.steps", "com.tests.auto_tests_template.hooks"},
        plugin = {
                "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
                "summary",
                "pretty"
        },
        tags = "@Eirc"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
