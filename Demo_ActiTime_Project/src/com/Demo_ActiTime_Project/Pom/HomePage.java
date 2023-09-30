package com.Demo_ActiTime_Project.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//Declaration
	@FindBy(id="logoutLink")
	private WebElement lgoutblnk;
	
	@FindBy(xpath="//div[.='Time-Track']")
	private WebElement timetab;
	
	@FindBy(xpath="//div[.='Tasks']")
	private WebElement tasktab;
	
	@FindBy(xpath="//div[.='Reports']")
	private WebElement reporttab;
	
	@FindBy(xpath="//div[.='Users']")
	private WebElement usertab;
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getLgoutblnk() {
		return lgoutblnk;
	}

	public WebElement getTimetab() {
		return timetab;
	}

	public WebElement getTasktab() {
		return tasktab;
	}

	public WebElement getReporttab() {
		return reporttab;
	}

	public WebElement getUsertab() {
		return usertab;
	}
}
