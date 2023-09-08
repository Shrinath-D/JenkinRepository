package com.SeleniumJenkins.SeleniumJenkinsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Listener1.class)
public class ListenerDemo {
	WebDriver driver ;
  @Test
  public void f1() {
	 
	  
	  driver.findElement(By.name("q")).sendKeys("Hello",Keys.ENTER);
	  
	  Assert.assertEquals(driver.getTitle(), "Hello - Google Search");
//	    Assert.assertNotEquals(driver.getTitle(), "Helo - Google Search");
  }
  @BeforeMethod
  public void f2()  {
	  driver = new ChromeDriver();
	  driver.get("https://www.google.com/");
	  driver.manage().window().maximize();
	  
  }
  
  @AfterMethod 
  public void f3() {
	  driver.quit();
  }
}
