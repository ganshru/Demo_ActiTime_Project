package com.Demo_ActiTime_Project.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Demo_ActiTime_Project.Pom.HomePage;
import com.Demo_ActiTime_Project.Pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	FileLibrary f=new FileLibrary();
	
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("Database connected", true);
	}
	
	@BeforeTest
	public void browserlaunch() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = f.readdatafromproperty("url");
		driver.get(url);
		Reporter.log("Browser Launched", true);
	}
	
	@BeforeMethod
	public void login() throws IOException {
//		driver.findElement(By.id("username")).sendKeys("admin");
//		driver.findElement(By.name("pwd")).sendKeys("manager");
//		driver.findElement(By.xpath("//div[.='Login ']")).click();
		LoginPage lp=new LoginPage(driver);
		String un = f.readdatafromproperty("username");
		lp.getUntbx().sendKeys(un);
		String pwd = f.readdatafromproperty("password");
		lp.getPwtbx().sendKeys(pwd);
		lp.getLgbtn().click();
		Reporter.log("Logged in Successfully", true);
	}

	@AfterMethod
	public void logout() {
		HomePage hp=new HomePage(driver);
		hp.getLgoutblnk().click();
		Reporter.log("Logged out Successfully", true);
	}
	
	@AfterTest
	public void browserclose() {
		driver.close();
		Reporter.log("Browser Closed", true);
	}
	
	@AfterSuite
	public void databasedisconnection() {
		Reporter.log("Database Disconnected", true);
	}

}
