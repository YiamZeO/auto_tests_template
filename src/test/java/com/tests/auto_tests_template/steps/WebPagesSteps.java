package com.tests.auto_tests_template.steps;

import com.tests.auto_tests_template.utils.PagesManager;
import com.tests.auto_tests_template.utils.ThreadContextHolder;
import io.cucumber.java.ru.Если;

import static com.codeborne.selenide.Selenide.open;

public class WebPagesSteps {
    private PagesManager pagesManager = ThreadContextHolder.getValue("PagesManager");

    @Если("Открыть url {string}")
    public void openUrl(String url) {
        open(url);
    }

    @Если("Инициализация страницы {string}")
    public void pageInit(String pageName) {
        pagesManager.setCurrentPage(pagesManager.getPage(pageName));
    }
}
