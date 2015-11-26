import junit.framework.TestCase;
//package org.openqa.selenium.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class test extends TestCase{

	public void testLogin(){
		 try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("Bad Log in Testing: Bob, bathtub");
        WebDriver driver= new HtmlUnitDriver();
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement element=driver.findElement(By.name("userId"));
        element.clear();
        WebElement elementpw=driver.findElement(By.name("userPassword"));
        elementpw.clear();
        element.sendKeys("Bob");
        elementpw.sendKeys("bathtub");
        element.submit();
        
        assertEquals("Bad Login",driver.getTitle());
        System.out.println("Bad Login");
        driver.quit();
	}

	public  void testGeneral(){
		  try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        WebDriver driver= new HtmlUnitDriver();
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement element=driver.findElement(By.name("userId"));
        element.clear();
        WebElement elementpw=driver.findElement(By.name("userPassword"));
        elementpw.clear();
        System.out.println("Log in with (Andy,apple).");
        element.sendKeys("Andy");
        elementpw.sendKeys("apple");
        element.submit();
        
        assertEquals("Online temperature conversion calculator",driver.getTitle());
        //System.out.println("Page title is: " + driver.getPageSource());
        
        element=driver.findElement(By.name("farenheitTemperature"));
        element.clear();
        System.out.println("Input value 21.2e1.");
        element.sendKeys("21.2e1");
        element.submit();
        assertTrue(driver.getPageSource().contains("21.2e1 Farenheit = 100 Celsius"));
        System.out.println("21.2e1 Farenheit = 100 Celsius");
        
        System.out.println("Select city: Berkeley");
        element=driver.findElement(By.cssSelector("input[value='Berkeley']"));
        element.click();
        element.submit();
        
        assertTrue(driver.getPageSource().contains("Temperature in Berkeley = 72 degrees Farenheit"));
        System.out.println("Temperature in Berkeley = 72 degrees Farenheit");
        driver.quit();
	}
   public static void main(String []args) {
        String[] testCaseName = 
            { test.class.getName() };
        // junit.swingui.TestRunner.main(testCaseName);
        junit.textui.TestRunner.main(testCaseName);
    }

}



