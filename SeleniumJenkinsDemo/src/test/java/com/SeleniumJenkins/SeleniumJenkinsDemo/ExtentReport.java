package com.SeleniumJenkins.SeleniumJenkinsDemo;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
		
	           ExtentTest test;
		static ExtentReports extent;
		static ExtentHtmlReporter htmlReporter;

		@BeforeClass
		public void startReport() {
			//creating html, extent objects

			htmlReporter = new ExtentHtmlReporter("");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);

			//configuration items to change the look and feel
			//add content, manage, tests etc

			htmlReporter.config().setChartVisibilityOnOpen(true);
			htmlReporter.config().setDocumentTitle("Simple Automation Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.STANDARD);

		}

	  @Test

	  public void t1() {
		  test = extent.createTest("Test case 1","The test case 1 has passed");
		  Assert.assertTrue(true);
	  }

	  @Test

	  public void t4() {
		  test = extent.createTest("Test case 4","The test case 4 has passed");
		  Assert.assertTrue(true);
	  }

	  @Test
	  public void t2() {
		  test = extent.createTest("Test case 2","The test case 2 has failed");
		  Assert.assertTrue(false);
	  }

	  @Test
	  public void t3() {
		  test = extent.createTest("Test case 1","The test case 1 has passed");
		  throw new SkipException("The test has been skipped");
	  }
	}