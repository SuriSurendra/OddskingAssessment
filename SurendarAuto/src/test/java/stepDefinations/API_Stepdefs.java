package stepDefinations;

import basePage.BasePage;
import io.cucumber.java.en.*;

public class API_Stepdefs {

    private BasePage basePage = new BasePage();

    @When("I sent request affiliate feed countries and save response as {string}")
    public void iSentRequestAffiliateFeedCountriesAndSaveResponseAs(String countriesResponse)
    {
        basePage.apiObj.retrieveAFCountriesResponse();
    }

    @When("I sent request affiliate feed {string} and verify the response")
    public void iSentRequestAffiliateFeedAndVerifyTheResponse(String parameter)
    {
        basePage.apiObj.retrieveAndVerifyAffilateApiHealth(parameter);

    }
}
