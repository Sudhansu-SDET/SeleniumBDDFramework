package com.Hooks;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before("@mbb")
    public void launchBrowser() throws IOException {
        System.out.println("mbb");
        ConfigReader configReader = new ConfigReader();
        prop = configReader.init_prop();
        String browserName = prop.getProperty("browser");
        String url = prop.getProperty("url");
        //DriverFactory driverFactory = new DriverFactory();
        //driver = driverFactory.init_driver(browserName);
        driver = new ChromeDriver();
        driver.get(url);
    }

    @After(order =1)
    public void tearDown(Scenario scenario){
        driver.quit();
        if (scenario.isFailed()){

        String screenshotName = scenario.getName().replaceAll(" " , "_");

            byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",screenshotName);

        }

    }
}
