package com.Demo_ActiTime_Project.TestScript;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Demo_ActiTime_Project.GenericLibrary.BaseClass;
import com.Demo_ActiTime_Project.GenericLibrary.FileLibrary;
import com.Demo_ActiTime_Project.GenericLibrary.ListenerImplimentation;
import com.Demo_ActiTime_Project.Pom.HomePage;
import com.Demo_ActiTime_Project.Pom.TaskPage;

@Listeners(ListenerImplimentation.class)

public class CreateCustomer extends BaseClass{
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getTasktab().click();
		
		TaskPage tp=new TaskPage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcusbtn().click();
		
		FileLibrary f=new FileLibrary();
		String name = f.readdatafromexcel("Sheet1", 4, 1);
		tp.getCustnametbx().sendKeys(name);
		String desc = f.readdatafromexcel("Sheet1", 4, 2);
		tp.getDesctbx().sendKeys(desc);
//		WebElement option = tp.getCustdrpdwn();
//		Select s=new Select(option);
//		s.selectByValue("itemRow cpItemRow ");
		tp.getCustcred().click();
		
		String expectedresult = name;
		String actualresult = driver.findElement(By.xpath("(//div[.='\"+name+\"'])[2]")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(expectedresult, actualresult);
		s.assertAll();
		Reporter.log("Create Customer Successfully", true);
	}

}
