package com.Demo_ActiTime_Project.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	//declaration
	@FindBy(xpath="//div[.='Add New']")
	private WebElement addnewbtn;
	
	@FindBy(xpath="//div[.='+ New Customer']")
	private WebElement newcusbtn;
	
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement custnametbx;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement desctbx;
	
	@FindBy(xpath="//div[.='- Select Customer -']")
	private WebElement custdrpdwn;
	
	@FindBy(xpath="//div[.='Create Customer']")
	private WebElement custcred;
	
	@FindBy(xpath="//div[@class='greyButton cancelBtn']")
	private WebElement cnclbtn;
	
	//initialization
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getAddnewbtn() {
		return addnewbtn;
	}

	public WebElement getNewcusbtn() {
		return newcusbtn;
	}

	public WebElement getCustnametbx() {
		return custnametbx;
	}

	public WebElement getDesctbx() {
		return desctbx;
	}

	public WebElement getCustdrpdwn() {
		return custdrpdwn;
	}

	public WebElement getCustcred() {
		return custcred;
	}

	public WebElement getCnclbtn() {
		return cnclbtn;
	}
}
