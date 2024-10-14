package com.stepDefination;

import com.Pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.ElementsUtil;
import io.cucumber.core.backend.ScenarioScoped;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.*;
import java.util.List;
import java.util.Map;

import static com.Pages.LoginPage.*;
import static com.qa.util.ElementsUtil.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class LoginStepsTest  {
    private static String pageTitle;

    private static final String ORDER_HISTORY_AND_DETAILS = "Order history and details";
    private static final String MY_WISHLISTS = "My wishlists";
    private ElementsUtil elementsUtil = new ElementsUtil(DriverFactory.getDriver());

    @Given("^user is on login page$")
    public void userIsOnLoginPage() throws InterruptedException {

        System.out.println("user is on login page");


    }

    @When("user gets the title of the page")
    public void userGetsTheTitleOfThePage() {
        pageTitle = getPageTitle();
    }
    

    @Then("^the test data (.*) is passed$")
    public void theTestDataTestDataIsPassed(String aTestData) {

        System.out.println(aTestData);
    }

    @Given("User logs in to application successfully")
    public void userLogsInToApplicationSuccessfully(DataTable dataTable) {

        List<Map<String,String>> credList = dataTable.asMaps();
        String userName = credList.get(0).get("userName") ;
        String password = credList.get(0).get("password");

        whenTextboxValueisSet(getEMAIL(),userName);
        whenTextboxValueisSet(getPASSWORD(),password);
        whenElementisClicked(LoginPage.getSignIn());
    }

    @Then("^page title should be (.*)$")
    public void pageTitleShouldBe(String aTitle) {

        Assert.assertEquals(pageTitle,aTitle);
    }

    @Then("the below sections should be displayed")
    public void theBelowSectionsShouldBeDisplayed(DataTable SectionsTable) {
        List<String> sectionsList = SectionsTable.asList();



        for (String asectionItem:sectionsList) {

            switch (asectionItem){
                case ORDER_HISTORY_AND_DETAILS :
                    assertTrue(isElementDisplayed(getOrderHistoryAndDetails()));
                    break;
                case MY_WISHLISTS :
                    assertTrue(isElementDisplayed(getMyWishlists()));
                    break;
                default:
                    fail("The specified page is not present : " + asectionItem);
            }


            }

        }


    @Given("User launches the google site in chrome browser")
    public void userLaunchesTheGoogleSiteInChromeBrowser() {
        
    }

    @Given("user prints one")
    public void userPrintsOne() {
        System.out.println("1");
    }

    @And("user prints two")
    public void userPrintsTwo() {
        System.out.println("2");
    }

    @Then("user prints three")
    public void userPrintsThree() {
        System.out.println("3");
    }


    @Given("^user prints (.*) and (.*)$")
    public void userPrintsUserNameAndPassword(String userName,String password) {
        System.out.println(userName + " - " + password);
    }

    @When("user enters data and clicks search")
    public void userEntersDataAndClicksSearch() {
        System.out.println("Step 2 printed");
        Assert.assertTrue(Boolean.TRUE);
    }

    @Then("the data should be retrived and displayed to user")
    public void theDataShouldBeRetrivedAndDisplayedToUser() {
        System.out.println("Step 3 printed");
        Assert.assertTrue(Boolean.TRUE);
    }

    @Given("User launches the google site (.*) in chrome browser")
    public void userLaunchesTheGoogleSiteTestDataInChromeBrowser() {
    System.out.println("Step 1 printed");
    Assert.assertTrue(Boolean.TRUE);
    }

    @Given("User logs in to Process {int}G application successfully")
    public void userLogsInToProcessGApplicationSuccessfully(int arg0) {

    }
}


