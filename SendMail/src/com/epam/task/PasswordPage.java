package com.epam.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage extends Page {

	public PasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = ".//*[@id='Passwd']")
	WebElement passwordField;

	public LettersPage passwordSubmit(String password) {
		passwordField.sendKeys(password);
		passwordField.submit();
		return PageFactory.initElements(driver, LettersPage.class);
	}
}
