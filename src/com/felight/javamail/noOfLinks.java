package com.felight.javamail;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class noOfLinks {
	
	private static WebDriver driver;
	private static int LinksCount;

	@BeforeClass
	public static void setUp() {

		driver = new FirefoxDriver();
		driver.get("http://www.felight.com");
	}
	public static void validateLinks() {

		try {
			LinksCount = 0;
			List<WebElement> anchorTagsList = driver.findElements(By
					.tagName("a"));
			System.out.println("Total no. of links are "
					+ anchorTagsList.size());
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
	}
	public static void main(String[] Sachin){
		setUp();
		validateLinks();
	}
}
