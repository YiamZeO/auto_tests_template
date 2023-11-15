package com.tests.auto_tests_template.utils;

import com.codeborne.selenide.SelenideElement;
import com.tests.auto_tests_template.utils.annotations.Element;
import com.tests.auto_tests_template.utils.annotations.Page;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;

public class PagesManager {
    private String pagesPackageName;
    private Map<String, WebPage> pagesMap = new HashMap<>();

    private WebPage currentPage;

    public WebPage getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(WebPage currentPage) {
        this.currentPage = currentPage;
    }

    public WebPage getPage(String name){
        return pagesMap.get(name);
    }

    public PagesManager(String pagesPackageName){
        this.pagesPackageName = pagesPackageName;
        List<String> classNames = getAllClassNames(pagesPackageName);
        for (String className : classNames) {
            Class<?> clazz = null;
            try {
                clazz = Class.forName(className);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            Page pageAnnotation = clazz.getAnnotation(Page.class);
            WebPage webPage = new WebPage();
            if (pageAnnotation != null) {
                try {
                    Object instance = clazz.getDeclaredConstructor().newInstance();
                    Field[] fields = clazz.getDeclaredFields();
                    for (Field field : fields) {
                        Element elementAnnotation = field.getAnnotation(Element.class);
                        if (elementAnnotation != null) {
                            field.setAccessible(true);
                            webPage.addElement(elementAnnotation.value(), (SelenideElement) field.get(instance));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                pagesMap.put(pageAnnotation.value(), webPage);
            }
        }
    }

    private List<String> getAllClassNames(String packageName) {
        List<String> classNames = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = null;
        try {
            resources = classLoader.getResources(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            File file = new File(resource.getFile());
            String[] names = file.list();
            assert names != null;
            for (String name : names) {
                if (name.endsWith(".class")) {
                    String className = packageName + '.' + name.substring(0, name.length() - 6);
                    classNames.add(className);
                }
            }
        }
        return classNames;
    }
}
