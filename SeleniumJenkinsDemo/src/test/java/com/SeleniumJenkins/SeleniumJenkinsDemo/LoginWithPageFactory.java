package com.SeleniumJenkins.SeleniumJenkinsDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginWithPageFactory {
  @Test
  public void login1() throws Exception{
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
	  
	  
	  PageFactory.initElements(driver, LoginWithPageFactory.class);
	  Thread.sleep(2000);
	  
	  Loginpageobjects1.username.sendKeys("Admin");
	  Loginpageobjects1.password.sendKeys("admin123");
	  Loginpageobjects1.btnLogin.click();
	  
	  driver.quit();
  }
}
