package com.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.DriverManager;
import utils.ExtentManager;
import utils.FileReader;
import utils.LoggerUtil;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    FileReader configReader = new FileReader("src/main/resources/config.properties");
    
    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();
        LoggerUtil.info("Browser session started");
        driver.get(configReader.getBaseUrl());
        LoggerUtil.info("Navigated to URL: " + configReader.getBaseUrl());

        extent = ExtentManager.getInstance();
        test = extent.createTest(getClass().getSimpleName(), "Test Description");
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
        LoggerUtil.info("Browser session ended");

        extent.flush();
        LoggerUtil.info("Extent report generated");
    }

    protected void logInfo(String message) {
        LoggerUtil.info(message);
        test.log(Status.INFO, message);
    }

    protected void logError(String message) {
        LoggerUtil.error(message);
        test.log(Status.ERROR, message);
    }
}