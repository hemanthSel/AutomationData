package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

//1st testNG project
// priority can be -1 0 or 1
// priority=1
@Test(priority=1 )
public class MultipleClasses {

	public void flipcartMethod() {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");
		// Thread.sleep(4000);
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();

		// perform mouse hover
		WebElement weFashion = driver.findElement(By.xpath("//div[@aria-label='Fashion']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(weFashion).perform();

		// print left hand menu -11 menu items
		List<WebElement> listobj1 = driver.findElements(By.xpath("//a[@class='_1BJVlg']"));
		for (int i = 0; i < listobj1.size(); i++) {
			System.out.println(listobj1.get(i).getText());

		}

		// print right hand menu for each left hand item value
		for (int i = 1; i <= listobj1.size(); i++) {
			String str = "(//a[@class='_1BJVlg'])" + "[" + i + "]";
			WebElement listobj2 = driver.findElement(By.xpath(str));
			actions.moveToElement(listobj2).perform();

			List<WebElement> Menu2 = driver.findElements(By.xpath("//a[@class='_3490ry']"));
			System.out.println("*****Right menu list Started*****");
			for (int j = 1; j < Menu2.size(); j++) {
				System.out.println(Menu2.get(j).getText());

			}
			System.out.println("******Right menu list ended****");
		}

		System.out.println("*****************"); // for right hand menu-

	}

	@Test(priority=2)
	public void amazon() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();

		Thread.sleep(5000);
		System.out.println(driver.getTitle());

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

		driver.quit();

	}
}
