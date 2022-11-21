package aoetest.step_definition;

import aoetest.pages.AOETestPage;
import aoetest.utilities.BrowserUtils;
import aoetest.utilities.ConfigurationReader;
import aoetest.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class aoeTestSteps {
    AOETestPage aoeTestPage=new AOETestPage();
    @Given("Visit website at www.aoe.com")
    public void visit_website_at_www_aoe_com() {
    Driver.get().get(ConfigurationReader.get("url"));
    aoeTestPage.cookieBtn.click();

    }
    @When("Hover on the Career section")
    public void hover_on_the_career_section()  {
     BrowserUtils.waitFor(2);
     BrowserUtils.hover(aoeTestPage.careerBtn);

    }

    @Then("Click the Vacancies")
    public void click_the_vacancies() {
      BrowserUtils.waitFor(2);
      aoeTestPage.vacanciesBtn.click();
    }
    @And("Filter the offerings by entering ‘frontend’ as keyword")
    public void filter_the_offerings_by_entering_frontend_as_keyword() {
      aoeTestPage.keywordBtn.sendKeys(ConfigurationReader.get("keyword"));
    }
    @Then("Check the returned list for the keyword")
    public void check_the_returned_list_for_the_keyword() {
        Assert.assertTrue(aoeTestPage.listOfVacanciesFiltered().get(0).getText().contains(ConfigurationReader.get("keyword")));

    }
    @And("Open the first entry which is displayed")
    public void open_the_first_entry_which_is_displayed() {
        JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
        //executor.executeScript("arguments[0].click();",aoeTestPage.listOfVacanciesFiltered().get(0).getText());
        executor.executeScript("arguments[0].click();",aoeTestPage.offering(aoeTestPage.listOfVacanciesFiltered().get(0).getText()));
    }
    @Then("Check that the content of this job offering is being displayed")
    public void check_that_the_content_of_this_job_offering_is_being_displayed() {
        String expectedText="Frontend / React Developer (m/f/d), remote possible (headquarters in Wiesbaden)";

        String actualText=aoeTestPage.verifyOption1(ConfigurationReader.get("keyword")).getText().trim();
        Assert.assertTrue(actualText.contains(expectedText));
    }



}
