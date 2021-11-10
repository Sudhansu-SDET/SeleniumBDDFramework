package com.qa.util;

import com.qa.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsUtil {

    private static WebDriver driver;

    public ElementsUtil(WebDriver driver) {
        this.driver = driver;

    }

    public static void whenTextboxValueisSet(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public static void whenElementisClicked(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    public static String getPageTitle() { return driver.getTitle();
    }

    public static boolean isElementDisplayed(String locator) { return  driver.findElement(By.cssSelector(locator)).isDisplayed(); }

}
