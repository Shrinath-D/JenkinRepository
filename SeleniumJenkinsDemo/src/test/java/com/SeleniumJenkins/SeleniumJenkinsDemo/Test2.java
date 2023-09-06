package com.SeleniumJenkins.SeleniumJenkinsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.bing.com/");
  }
  @Test 
  public void f2() throws Exception{
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id("sb_form_q")).sendKeys("Selenium",Keys.ENTER);
	  Assert.assertEquals(driver.getTitle(), "Selenium - Search");
  }
@Test
  public void f3() throws Exception{
	  Thread.sleep(3000);
	  driver.quit();
  }
}