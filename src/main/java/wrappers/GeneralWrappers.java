package wrappers;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import sun.tools.jstack.JStack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


@Getter
@Setter
public class GeneralWrappers {

    public RemoteWebDriver driver;

    public void waitProperty(long time) {
        try {
            String multiplierTime = System.getProperty("webdriver.timemultiplier");
            if (multiplierTime != null && !multiplierTime.isEmpty() && !multiplierTime.trim().isEmpty()) {
                int multiplier = Integer.parseInt(multiplierTime);
                Thread.sleep(time * multiplier);
            }
            else {
                Thread.sleep(time);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //doesn't rlly verify, just prints text, but as a human you can verify the std out
    public void verify(String xpath) {
        String textValue = null;
        try {
            textValue = this.driver.findElement(By.xpath(xpath)).getText();
            System.out.println("The text value returned "+textValue);
        } catch (NoSuchElementException e) {
            System.out.println("The element with id value "+xpath+" is not found in DOM");
        } catch (ElementNotVisibleException e) {
            System.out.println("The element with id value "+xpath+" is not visible in DOM");
        } catch (ElementNotInteractableException e) {
            System.out.println("The element with id value "+xpath+" is not interactable");
        } catch (StaleElementReferenceException e) {
            System.out.println("The element with id value "+xpath+" is not stable");
        } catch (WebDriverException e) {
            System.out.println("The element with id value "+xpath+" could not found due to unknown error");
        }
    }

    public void click(String xpath) {
        try {
            this.driver.findElement(By.xpath(xpath)).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (ElementNotVisibleException e) {
            e.printStackTrace();
            System.out.println(e.getMessage()+"The element with xpath "+xpath+" is not visible");
        } catch (ElementNotInteractableException e) {
            e.printStackTrace();
            System.out.println(e.getMessage()+"The element with xpath "+xpath+" is not interactable");
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            System.out.println("The element with xpath "+xpath+" is not stable");
        } catch (WebDriverException e) {
            e.printStackTrace();
            System.out.println("The element with xpath "+xpath+" could not click due to unknown error");
        }
    }

    public void enter(String xpath, String data) {
        try {
            driver.findElement(By.xpath(xpath)).sendKeys(data);
            System.out.println("The element with xpath "+xpath+" is entered with the data "+data);
        } catch (NoSuchElementException e) {
            System.out.println("The element with xpath "+xpath+" is not found in DOM");
        } catch (ElementNotVisibleException e) {
            System.out.println("The element with xpath "+xpath+" is not visible in DOM");
        } catch (ElementNotInteractableException e) {
            System.out.println("The element with xpath "+xpath+" is not interactable");
        } catch (StaleElementReferenceException e) {
            System.out.println("The element with "+xpath+" is not stable");
        }catch (WebDriverException e) {
            System.out.println("The element with xpath"+xpath+" is not enter with data "+data+" due to unknown reason");
        }
    }

    public void click(String xpath, Boolean js) {
        // TODO Auto-generated method stub
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            WebDriverWait wait = new WebDriverWait(driver, 15);
            //wait.until(ExpectedConditions.elementToBeClickable(element));
            JavascriptExecutor exe = (JavascriptExecutor) driver;
            exe.executeScript("arguments[0].click();", element);
            System.out.println("The element with xpath "+xpath+" is clicked");
        } catch (NoSuchElementException e) {
            // TODO Auto-generated catch block
            System.out.println("The element with xpath "+xpath+" is not clickable");
            e.printStackTrace();
        } catch (ElementNotVisibleException e) {
            // TODO: handle exception
            System.out.println("The element with xpath "+xpath+" is not visible");
            e.printStackTrace();
        } catch (ElementNotInteractableException e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("The element with xpath "+xpath+" is not interactable");
        } catch (StaleElementReferenceException e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("The element with xpath "+xpath+" is not stable");
        } catch (WebDriverException e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("The element with xpath "+xpath+" could not click due to unknown error");
        }

    }
    
    public void sendEnter(String xpath){
        try {
            driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
            System.out.println("The element with xpath "+xpath+" is clicked");
        } catch (NoSuchElementException e) {
            // TODO Auto-generated catch block
            System.out.println("The element with xpath "+xpath+" is not clickable");
            e.printStackTrace();
        } catch (ElementNotVisibleException e) {
            // TODO: handle exception
            System.out.println("The element with xpath "+xpath+" is not visible");
            e.printStackTrace();
        } catch (ElementNotInteractableException e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("The element with xpath "+xpath+" is not interactable");
        } catch (StaleElementReferenceException e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("The element with xpath "+xpath+" is not stable");
        } catch (WebDriverException e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("The element with xpath "+xpath+" could not click due to unknown error");
        }
    }


}
