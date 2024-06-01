package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiPgm {
	
	WebDriver driver;
	
	@BeforeClass
	public void Initalization()
	{
		 driver = new ChromeDriver(); // RTP

		driver.get("https://www.Amazon.in");

		driver.manage().window().maximize();

		System.out.println(driver.getCurrentUrl());
	}
	
	

	@Test(priority=1)
	public void SelectDropDown() {
		

		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

		Select sel = new Select(dropdown);
		sel.selectByIndex(3);

		sel.selectByValue("search-alias=mobilesss-apps");

		sel.selectByVisibleText("Deals"); //

		
	}

	//@Test(dependsOnGroups = "SelectDropDown")
	@Test(priority=2 )
	public void AdvanceDropDown() throws InterruptedException {
		

		WebElement select = driver.findElement(By.id("searchDropdownBox"));
		Select s = new Select(select);
		List<WebElement> StoreOptions = s.getOptions();
		int countOptions = StoreOptions.size();
		System.out.println(countOptions);
		
		// print ALL select search dropdown values
		for (int i = 0; i < countOptions; i++) {
			StoreOptions.get(i).click();
			System.out.println(StoreOptions.get(i).getText());
		}
		System.out.println("### End of print select options");

		// To print the list of values after mouse Hover

		WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
		Actions actions = new Actions(driver);
		actions.moveToElement(accountList).perform();

		// WebElement wishList=driver.findElement(By.id("nav-al-wishlist"));

		// List<WebElement> e=
		// driver.findElements(By.id("//div[@id='nav-al-wishlist']"));
		List<WebElement> e = driver.findElements(By.xpath("//div[@class='nav-title']|//a[@class='nav-link nav-item']"));

		System.out.println(e.size());

		for (int i = 0; i < e.size(); i++) {
			System.out.println(e.get(i).getText());
		}

		
	}
	
	@AfterClass
	public void CleanUp()
	{
		driver.quit();
	}
	
}
