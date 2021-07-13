package stepDefinations;

import basePage.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class OddskingFEStepdefs {

    private BasePage basePage = new BasePage();

    @Given("^User is on Oddsking homepage$")
    public void verifyUserIsOnOddskingHomepage() { basePage.registrationPgObj.verifyOddskingHomepageisOpened();}

    @When("I click on Join button")
    public void iClickOnJoinButton() { basePage.registrationPgObj.clickJoinButton();}

    @And("I enter email address {string} on registration page")
    public void iEnterEmailAddressOnRegistrationPage(String emailAddress)
    {
        basePage.registrationPgObj.enterEmailAddress(emailAddress);
    }

    @And("I enter username {string} on registration page")
    public void iEnterUsernameOnRegistrationPage(String username)
    {
        basePage.registrationPgObj.enterUserName(username);
    }

    @And("I enter password {string} on registration page")
    public void iEnterPasswordOnRegistrationPage(String password)
    {
        basePage.registrationPgObj.enterPassword(password);
    }

    @And("I click on Terms and Conditions checkbox")
    public void iClickOnTermsAndConditionsCheckbox()
    {
        basePage.registrationPgObj.clickTermsAndConditionsCheckBox();
    }

    @And("I click Continue")
    public void iClickContinue()
    {
        basePage.registrationPgObj.clickContinue();
    }

    @And("I enter first name {string} on registration page")
    public void iEnterFirstNameOnRegistrationPage(String firstName)
    {
        basePage.registrationPgObj.enterFirstName(firstName);
    }

    @And("I enter last name {string} on registration page")
    public void iEnterLastNameOnRegistrationPage(String lastName)
    {
        basePage.registrationPgObj.enterLastName(lastName);
    }

    @And("I enter day {string} month {string} year {string} as date of birth on registration page")
    public void iEnterDayMonthYearAsDateOfBirthOnRegistrationPage(String day, String month, String year)
    {
        basePage.registrationPgObj.enterDay(day);
        basePage.registrationPgObj.enterMonth(month);
        basePage.registrationPgObj.enterYear(year);
    }

    @And("I enter phone number {string} on registration page")
    public void iEnterPhoneNumberOnRegistrationPage(String telephoneNumber)
    {
        basePage.registrationPgObj.enterTelephone(telephoneNumber);
    }

    @And("I select a security question {string} on registration page")
    public void iSelectASecurityQuestionOnRegistrationPage(String securityQuestion)
    {
        basePage.registrationPgObj.selectQuestion(securityQuestion);
    }

    @And("I enter an answer {string} on registration page")
    public void iEnterAnAnswerOnRegistrationPage(String securityAnswer)
    {
        basePage.registrationPgObj.enterSecurityAnswer(securityAnswer);
    }

    @And("I click on Continue")
    public void iClickOnContinue()
    {
        basePage.registrationPgObj.clickContinue();
    }

    @And("I enter address or postcode {string}")
    public void iEnterAddressOrPostcode(String postcode)
    {
        basePage.registrationPgObj.enterAddressSearch(postcode);
    }

    @And("I click on email checkbox")
    public void iClickOnEmailCheckbox()
    {
        basePage.registrationPgObj.clickTermsAndConditionsCheckBox();
    }

    @Then("I should see a message for successful registration")
    public void iShouldSeeAMessageForSuccessfulRegistration()
    {
        Assert.assertTrue("Registration is not successful", basePage.registrationPgObj.registrationSuccessfull());
    }
}
