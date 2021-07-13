package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverFactory;
import utilities.GenericUtility;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class Lotto {

    GenericUtility genericUtility;
    HashMap<String, String> currDetails;

    public Lotto() {
        PageFactory.initElements(DriverFactory.getWebDriver(), this);
        genericUtility = new GenericUtility();
    }

//********************************OBJECTS*********************************************
    @FindBy(xpath = "//a[@data-actionable='Lotto.SelectLottoBanner.Results']")
    private WebElement resultsLink;

    @FindBy(xpath = "//span[contains(text(),'Irish Lotto')]")
    private WebElement irishLottoText;

    @FindBy(xpath = "div._1kdww6z div._ulj5y7:nth-child(3) div._19nbk62 div._1mj35d0o.dynamic-scrollbars.site-scrollbars div._ojs7nk.inner-container div._w93se div._17k2eih:nth-child(2) div._1pazxvm div._sbhwlz9 > div._az6wh2")
    private WebElement dateFrom;

    @FindBy(xpath = "//div[contains(text(),'Main Draw')]")
    private WebElement resultText;


//**********************************METHODS*****************************************

    public void verifyOddskingLottoIrisResultsIsOpened ()
    {
        try
        {
            genericUtility.waitForPageLoad();
            Assert.assertTrue("Oddsking Iris lotto page is not opened/loaded", DriverFactory.getWebDriver().getCurrentUrl().equalsIgnoreCase(GenericUtility.readConfigs("oddskingLottoIrisURL")));
            Assert.assertTrue(irishLottoText.isDisplayed());
        } catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    public void setDateFrom()
    {
       dateFrom.click();
        List<WebElement> columns =dateFrom.getTagName("td"));
        LocalDate now = LocalDate.now().minusDays(7);
        columns.stream()
                .filter(element -> element.getText().equals(now.getDayOfMonth()))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public void ClickResultLink()
    {
        resultsLink.click();
        genericUtility.waitForPageLoad();
    }

    public boolean ResultTextDisplayed()
    {
        genericUtility.waitForPageLoad();
        return resultText.isDisplayed();
    }
}