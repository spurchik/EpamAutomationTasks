package com.pf.oscillograph;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class TestExecution {
	WebDriver driver = new FirefoxDriver();

	@Before
	public void sutUp() {
		driver.get("http://www.google.com.ua");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void search() throws InterruptedException {
		SearchPage googleSearchPage = PageFactory.initElements(driver,
				SearchPage.class);
		ResultPage results = googleSearchPage.search("осциллограф");
		results.searchElementPresence("vit.ua");
	}

	@After
	public void tearDown() {
		driver.close();
	}
}
