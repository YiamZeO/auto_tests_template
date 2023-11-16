package com.tests.auto_tests_template.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.tests.auto_tests_template.utils.PagesManager;
import com.tests.auto_tests_template.utils.ThreadContextHolder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.edge.EdgeOptions;

public class WebHooks {
    @Before
    public void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "edge";
        Configuration.headless = false;
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        Configuration.browserCapabilities = new EdgeOptions().addArguments("--remote-allow-origins=*");
        SelenideLogger.addListener("allure", new AllureSelenide());

        ThreadContextHolder.putValue("PagesManager",
                new PagesManager("com.tests.auto_tests_template.pages"));
        System.out.println("Установленные переменные контекста: ");
        System.out.println(ThreadContextHolder.asMap());
    }

    @After
    public void tearDown() {
        if (WebDriverRunner.hasWebDriverStarted())
            WebDriverRunner.closeWebDriver();
    }
}
