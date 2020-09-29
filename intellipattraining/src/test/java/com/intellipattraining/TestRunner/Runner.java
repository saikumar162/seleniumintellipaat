package com.intellipattraining.TestRunner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Runner {
	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass

	public void beforeClass() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void getTitle() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.bing.com/");
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='search'])[1]")));
		driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys("intellipaat");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println("Title is: " + title);
		Thread.sleep(30000);
	}
}
