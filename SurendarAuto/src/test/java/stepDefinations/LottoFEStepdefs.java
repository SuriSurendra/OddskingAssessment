package stepDefinations;

import basePage.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LottoFEStepdefs {

    private BasePage basePage = new BasePage();

    @Given("^User is on Oddsking homepage$")
    public void verifyUserIsOnOddskingHomepage() { basePage.registrationPgObj.verifyOddskingHomepageisOpened();}

    @Given("User is on Irish Lotto page")
    public void userIsOnIrishLottoPage()
    {
        basePage.lotto.verifyOddskingLottoIrisResultsIsOpened();
    }

    @When("User clicks on Result")
    public void userClicksOnResult()
    {
        basePage.lotto.ClickResultLink();
    }

    @Then("User should be able to filter results by date")
    public void userShouldBeAbleToFilterResultsByDate()
    {
        basePage.lotto.setDateFrom();
        Assert.assertTrue("Iris Lotto result page is not displayed", basePage.lotto.ResultTextDisplayed());
    }
}
