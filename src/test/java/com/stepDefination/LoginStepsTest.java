package com.stepDefination;

import com.qa.factory.DriverFactory;
import com.qa.util.ElementsUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

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
        whenElementisClicked(getSignIn());
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

    }


