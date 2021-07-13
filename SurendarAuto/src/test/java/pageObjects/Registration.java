package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.DriverFactory;
import utilities.GenericUtility;
import java.util.*;

public class Registration {

    GenericUtility genericUtility;
    HashMap<String, String> currDetails;

    public Registration() {
        PageFactory.initElements(DriverFactory.getWebDriver(), this);
        genericUtility = new GenericUtility();
    }

//********************************OBJECTS*********************************************
    @FindBy(xpath = "//a[@data-actionable='Header.LoggedOut.buttonJoin']")
    private WebElement joinButton;

    @FindBy(id = "RegistrationPage.AccountSection.email")
    private WebElement emailIdTextbox;

    @FindBy(id = "RegistrationPage.AccountSection.username")
    private WebElement userNameTextbox;

    @FindBy(id = "RegistrationPage.AccountSection.password")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//div[@data-actionable='RegistrationPage.TermsAndConditions.agree_terms']")
    private WebElement over18CheckBox;

    @FindBy(xpath = "//button[@data-actionable='RegistrationPage.NavigationButtonsPage2.Continue']")
    private WebElement continueButton;

    @FindBy(id = "RegistrationPage.PersonalSection.first_name")
    private WebElement firstNameTextbox;

    @FindBy(id = "RegistrationPage.PersonalSection.last_name")
    private WebElement lastNameTextbox;

    @FindBy(id = "RegistrationPage.DateOfBirthInput.day")
    private WebElement dayTextbox;

    @FindBy(id = "RegistrationPage.DateOfBirthInput.month")
    private WebElement monthTextbox;

    @FindBy(id = "RegistrationPage.DateOfBirthInput.year")
    private WebElement yearTextbox;

    @FindBy(id = "TelephoneNumberInput.telephone.desktop-telephone")
    private WebElement telephoneTextbox;

    @FindBy(id = "RegistrationPage.Dropdown.desktop-securityQuestion")
    private WebElement securityQuestionDropDown;

    @FindBy(id = "RegistrationPage.ContactSection.desktop_security_answer")
    private WebElement securityAnswerTextbox;

    @FindBy(id = "search")
    private WebElement addressSearchSearchBox;

    @FindBy(xpath = "//button[@data-actionable='RegistrationPage.NavigationButtonsPage5.Register']")
    private WebElement registrationButton;

    @FindBy(xpath = "//h5[@data-actionable='RegistrationPage.RegistrationSuccess.desktop.thanks_header']")
    private WebElement successRegistrationLabel;

    @FindBy(xpath = "//span[@class='pcadescription']")
    private WebElement addressLinesText;

//**********************************METHODS*****************************************

    public void verifyOddskingHomepageisOpened ()
    {
        try
        {
            genericUtility.waitForPageLoad();
            Assert.assertTrue("Oddsking page is not opened/loaded", DriverFactory.getWebDriver().getCurrentUrl().equalsIgnoreCase(GenericUtility.readConfigs("oddsKingURL")));
            Assert.assertTrue(joinButton.isDisplayed());
        } catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }
    public void clickJoinButton() {joinButton.click(); }

    public void enterEmailAddress(String email) { emailIdTextbox.sendKeys(email);}

    public void enterUserName(String username) { userNameTextbox.sendKeys(username);}

    public void enterPassword(String password) { passwordTextbox.sendKeys(password);}

    public void clickTermsAndConditionsCheckBox() {
        WebElement termsCheckBox = over18CheckBox;
        if (!termsCheckBox.isSelected()) { termsCheckBox.click(); } }

    public void clickContinue()
    {
        genericUtility.waitForVisibilityOfElement(continueButton);
        continueButton.click();
    }

    public void enterFirstName(String firstname) { firstNameTextbox.sendKeys(firstname);}

    public void enterLastName(String lastName) { lastNameTextbox.sendKeys(lastName);}

    public void enterDay(String day) { dayTextbox.sendKeys(day);}

    public void enterMonth(String month) { monthTextbox.sendKeys(month);}

    public void enterYear(String year) { yearTextbox.sendKeys(year);}

    public void enterTelephone(String telephoneNumber) { telephoneTextbox.sendKeys(telephoneNumber);}

    public void selectQuestion(String securityQuestion)
    {
        //Select select = new Select();
        telephoneTextbox.sendKeys(securityQuestion);
    }

    public void enterSecurityAnswer(String answer) { securityAnswerTextbox.sendKeys(answer);}

    public void enterAddressSearch(String postCode)
    {
        addressSearchSearchBox.sendKeys(postCode);
        addressLinesText.click();
    }

    public void clickRegistration()
    {
        genericUtility.waitForVisibilityOfElement(registrationButton);
        registrationButton.click();
    }

    public boolean registrationSuccessfull()
    {
        genericUtility.waitForVisibilityOfElement(successRegistrationLabel);
        return successRegistrationLabel.isDisplayed();
    }
}