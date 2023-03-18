package com.invicto;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
import wrappers.GeneralWrappers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


@Getter
@Setter
public class LiveShell{

    public ChromeDriver driver;
    GeneralWrappers wrappers = new GeneralWrappers();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";


    public LiveShell() {
        String url = "https://google.com";
        System.out.println(ANSI_GREEN + "Setting up the default chrome driver..." + ANSI_RESET);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); //To disable Chrome notifications use this method before initializing ChromeDriver in the invokeApp method.
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        this.driver = new ChromeDriver(options);
        org.openqa.selenium.Dimension d = new Dimension(1680,1080);
        this.driver.manage().window().setSize(d);
        driver.get(url);
        wrappers.waitProperty(500);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println(ANSI_GREEN + "The chrome browser was successfully launched " + url + ANSI_RESET);
        wrappers.setDriver(getDriver());
    }

    public void cmdLoop(){
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        String xpath = null;
        String secondPart = null;
        System.out.println(ANSI_GREEN + "Enter object properties first part: " + ANSI_RESET);
        String opFirstPart = input.next();
        input.nextLine();
        while (true){
            System.out.println(ANSI_GREEN + "Enter command (c/cj/e/se/v/x/q): " + ANSI_RESET);
            String command = input.nextLine();
            if(command.equals("c")){
                System.out.println(ANSI_GREEN + "Pass in the XPath: " + ANSI_RESET);
                xpath = input.next();
                wrappers.click(xpath);
                input.nextLine();
            }
            else if(command.equals("cj")){
                System.out.println(ANSI_GREEN + "Pass in the XPath: " + ANSI_RESET);
                xpath = input.next();
                wrappers.click(xpath, true);
                input.nextLine();
            }
            else if(command.equals("g")){
                System.out.println(ANSI_GREEN + "Pass in the url: " + ANSI_RESET);
                String url = input.next();
                driver.get(url);
                input.nextLine();
            }
            else if(command.equals("e")){
                System.out.println(ANSI_GREEN + "Pass in the XPath: " + ANSI_RESET);
                xpath = input.next();
                System.out.println(ANSI_GREEN + "Information to Enter: " + ANSI_RESET);
                String toEnter = input.next();
                wrappers.enter(xpath, toEnter);
                input.nextLine();
            }
            else if(command.equals("se")){
                System.out.println(ANSI_GREEN + "Pass in the XPath: " + ANSI_RESET);
                xpath = input.next();
                wrappers.sendEnter(xpath);
                input.nextLine();
            }
            else if(command.equals("v")){
                System.out.println(ANSI_GREEN + "Pass in the XPath: " + ANSI_RESET);
                xpath = input.next();
                wrappers.verify(xpath);
                input.nextLine();
            }
            else if(command.equals("x")){
                System.out.println(ANSI_GREEN + "Enter object properties first part: " + ANSI_RESET);
                opFirstPart = input.next();
                input.nextLine();
                continue;
            }
            else if(command.equals("q")){
                return;
            }
            else {
                System.out.println(ANSI_GREEN + "Command not supported, try again" + ANSI_RESET);
                continue;
            }

            String commandTest = command;
            String selection;
            System.out.println(ANSI_GREEN + "Do you want to keep this instruction? (y/n): " + ANSI_RESET);
            selection = input.nextLine();
            if(selection.equals("n")){
                continue;
            }
            else if(selection.equals("y")){
                System.out.println(ANSI_GREEN + "Enter second part of xpath: " + ANSI_RESET);
                secondPart = input.nextLine();
                writeToTest(xpath, opFirstPart, secondPart, commandTest);
                // input.nextLine();
            }
        }
    }

    public void writeToTest(String xpath, String opFirstPart, String secondPart, String command){
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        String replaceWith = null;

        // getting lines of code ready
        String objectXpath = opFirstPart + "." + secondPart + "." + "XPath" + "=" + xpath + "\n";
        String variable = "public static final String " + "CMP_" + opFirstPart.toUpperCase().replace(".","_") + "_" + secondPart.toUpperCase().replace(".","_") + "="
        + "\"" + opFirstPart + "." + secondPart + "." + "XPath\"" + ";\n";
        String testCommand = null;
        if(command.equals("c")){
            System.out.println(ANSI_GREEN + "replaceWith (y/n): " + ANSI_RESET);
            replaceWith = input.nextLine();
            if(replaceWith.equals("y")){
                testCommand = "clickWithReplace(" + "CMP_" + opFirstPart.toUpperCase().replace(".","_") + "_" + secondPart.toUpperCase().replace(".","_") +", input);\n";
            }
            else{
            testCommand = "click(" + "CMP_" + opFirstPart.toUpperCase().replace(".","_") + "_" + secondPart.toUpperCase().replace(".","_") +");\n";
            }
        }
        else if(command.equals("cj")){
            System.out.println(ANSI_GREEN + "replaceWith (y/n): " + ANSI_RESET);
            replaceWith = input.nextLine();
            if(replaceWith.equals("y")){
                testCommand = "click(" + "CMP_" + opFirstPart.toUpperCase().replace(".","_") + "_" + secondPart.toUpperCase().replace(".","_") + ", input, LONG_TIME, true)" + ";\n";
            }
            else{
                testCommand = "click(" + "CMP_" + opFirstPart.toUpperCase().replace(".","_") + "_" + secondPart.toUpperCase().replace(".","_") + ", LONG_TIME, true)" + ";\n";
            }
        }
        else if(command.equals("v")){
            testCommand = "verify(" + "CMP_" + opFirstPart.toUpperCase().replace(".","_") + "_" + secondPart.toUpperCase().replace(".","_") + ",input)" + ";\n";
        }
        else if(command.equals("e")){
            testCommand = "enter(" + "CMP_" + opFirstPart.toUpperCase().replace(".","_") + "_" + secondPart.toUpperCase().replace(".","_") + ",input)" + ";\n";
        }
        // create/append to text file
        try{
            String commands = "output/test_commands.txt";
            FileWriter fw = new FileWriter(commands,true); //the true will append the new data
            fw.write(testCommand);//appends the string to the file
            fw.close();

            String pageObj = "output/page_objects.txt";
            fw = new FileWriter(pageObj,true); //the true will append the new data
            fw.write(variable);//appends the string to the file
            fw.close();

            String objProp = "output/object_properties.txt";
            fw = new FileWriter(objProp,true); //the true will append the new data
            fw.write(objectXpath);//appends the string to the file
            fw.close();
        }
        catch(IOException ioe){
        System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public static void main(String[] args){
        LiveShell liveShell = new LiveShell();
        liveShell.cmdLoop();
        liveShell.driver.close();
    }

}
