package com.tests.auto_tests_template.utils;

import com.codeborne.selenide.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class WebActions {
    public static void clickOnElement(SelenideElement element) {
        element.click();
    }

    public static void setStringOnElement(SelenideElement element, String value) {
        element.setValue(value);
    }

    public static void waitElementVisible(SelenideElement element, Long seconds) {
        element.should(Condition.visible, Duration.ofSeconds(seconds));
    }

    public static void waitElementNotVisible(SelenideElement element, Long timeoutSeconds) {
        element.shouldBe(Condition.not(Condition.visible), Duration.ofSeconds(timeoutSeconds));
    }

    public static void setCheckBox(SelenideElement element, boolean flag) {
        if (flag) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }

    public static void switchToTab(Integer tabNumber) {
        List<String> handles = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());
        tabNumber = tabNumber == null ? handles.size() - 1 : tabNumber - 1;
        Selenide.switchTo().window(handles.get(tabNumber));
    }

    public static void closeCurrentTab() {
        Selenide.closeWindow();
    }

    public static void textVisibleOnPage(String text, Long timeoutSeconds) {
        $(Selectors.byText(text))
                .shouldBe(Condition.visible, Duration.ofSeconds(timeoutSeconds));
    }

    public static void textNotVisibleOnPage(String text, Long timeoutSeconds) {
        $(Selectors.byText(text))
                .shouldBe(Condition.not(Condition.visible), Duration.ofSeconds(timeoutSeconds));
    }

    public static void elementTextEqualsExpectedText(SelenideElement element, String expectedText,
                                                     Long timeoutSeconds) {
        element.shouldBe(Condition.exactTextCaseSensitive(expectedText), Duration.ofSeconds(timeoutSeconds));
    }

    public static void elementTextNotEqualsExpectedText(SelenideElement element, String expectedText,
                                                        Long timeoutSeconds) {
        element.shouldNotBe(Condition.exactTextCaseSensitive(expectedText),
                Duration.ofSeconds(timeoutSeconds));
    }

    public static void elementTextContainsExpectedText(SelenideElement element, String expectedText,
                                                       Long timeoutSeconds) {
        element.shouldBe(Condition.partialText(expectedText), Duration.ofSeconds(timeoutSeconds));
    }

    public static void elementTextNotContainsExpectedText(SelenideElement element, String expectedText,
                                                       Long timeoutSeconds) {
        element.shouldBe(Condition.not(Condition.partialText(expectedText)), Duration.ofSeconds(timeoutSeconds));
    }
}
