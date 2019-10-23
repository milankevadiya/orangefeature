package orange;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MyStepDefs extends Utils {

    @Given("^User is on login page$")
    public void user_is_on_login_page()  {

    }

    @When("^User enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void user_enter_Username_as_and_Password_as(String username, String password)  {
        enterText(By.id("txtUsername"),username);
        enterText(By.id("txtPassword"),password);
        clickElement(By.name("Submit"));
    }

    @Then("^user should be logged in successfully$")
    public void user_should_be_logged_in_successfully()  {
        String Actual = getTextFromEement(By.xpath("//div [@class='head']"));
        String Expected = "Dashboard";
        Assert.assertEquals(Actual,Expected);
    }

}



