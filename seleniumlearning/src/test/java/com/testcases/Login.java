package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Rupa");
		WebElement Role=driver.findElement(By.id("searchSystemUser_userType"));
		Role.click();
		Select obj=new Select(Role);
		obj.selectByValue("1");
		driver.findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys("Rupa Jha");
		WebElement status=driver.findElement(By.id("searchSystemUser_status"));
		status.click();
		Select Stat=new Select(status);
		Stat.selectByValue("1");
		driver.findElement(By.id("searchBtn")).click();
		String message=driver.findElement(By.xpath("//*[@id=\'resultTable\']/tbody/tr/td")).getText();
		System.out.println(message);
			Thread.sleep(2000);
			
	

	}

}
	