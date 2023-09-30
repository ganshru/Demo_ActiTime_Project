package com.Demo_ActiTime_Project.GenericLibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

import io.netty.handler.codec.http.HttpContentEncoder.Result;

public class ListenerImplimentation extends BaseClass implements ITestListener {
	
	//Listener Implimentation:- Listener Implimentation is a class which are having orverrid method,
	//and this class is implements by ITestListener interface.
	
	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		TakesScreenshot t=(TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File desti = new File("./ScreenShot/"+name+".png");
		try {
			Files.copy(src, desti);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
