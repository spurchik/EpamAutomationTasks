package com.epam.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SentPage extends Page {

	public SentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = ".//a[text()=\"Отправленные\"]")
	WebElement sentButton;

	@FindBy(xpath = "//table//td[6]//span[1]")
	WebElement sentLetterHeader;

	void sentCheck(String checkingParam) {
		sentButton.click();
		if (sentLetterHeader.getText().equals(checkingParam)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
	}
}
