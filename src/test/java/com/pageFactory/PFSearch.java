package com.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PFSearch {

    WebDriver driver;

    public PFSearch(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,PFSearch.class);

    }

    @FindBy(css = "input[name='q']")
    WebElement txt_search_pf;

    public void setText(String atext){
       txt_search_pf.sendKeys(atext);
    }

}
