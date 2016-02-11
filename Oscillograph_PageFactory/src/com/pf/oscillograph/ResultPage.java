package com.pf.oscillograph;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage extends Page {

	public ResultPage(WebDriver driver) {
		super(driver);
	}

	private int resultPageCounter = 1;

	@FindBy(linkText = "Следующая")
	private WebElement nextPageButton;

	@FindBy(xpath = "//div[@class='g']")
	private List<WebElement> recentPageElements;

	public void searchElementPresence(String desiredText)
			throws InterruptedException {

		for (WebElement eachPageElement : recentPageElements) {

			if (eachPageElement.getText().contains(desiredText)) {

				System.out.println("result was found on page #"
						+ resultPageCounter + "\n" + "check screenshot in:"
						+ "\n" + "C:\\Selenium\\Screenshots\\Screen01.png");
				screenShot();
				return;
			}
		}
		
		System.out.println("seeking on page #" + resultPageCounter);
		resultPageCounter++;

		try {
			nextPageButton.click();
		} catch (NoSuchElementException e) {
			System.out.println(desiredText + " wasn't found");
			return;
		}
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		searchElementPresence(desiredText);
	}

	private void screenShot() {
		File screenshot = (File) ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(
					"C:\\Selenium\\Screenshots\\Screen01.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
