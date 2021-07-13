package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class GenericUtility {
    private WebDriver driver;
    private static int pageTimeout = Integer.parseInt(readConfigs("pageTimeout"));
    private static int eleTimeout = Integer.parseInt(readConfigs("elementTimeout"));

    public GenericUtility(){
        driver = DriverFactory.getWebDriver();
    }

    public static String readConfigs(String property){
        String propValue=null;
        try {
            Properties props = new Properties();
            File fs = new File(new File("src"), "/test/resources/Config.properties");
            FileInputStream fis = new FileInputStream(fs.getAbsoluteFile());
            props.load(fis);
            propValue = props.getProperty(property);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propValue;
    }

    public Boolean waitForVisibilityOfElement (WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, eleTimeout);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public void waitForPageLoad(){
        try{
            Thread.sleep(5000);
            WebDriverWait wait = new WebDriverWait(driver,pageTimeout);
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

