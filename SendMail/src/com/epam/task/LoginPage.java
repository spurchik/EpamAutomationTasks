package com.epam.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = ".//*[@id='Email']")
	WebElement emailField;

	public PasswordPage emailSubmit(String userName) {
		emailField.sendKeys(userName);
		emailField.submit();
		return PageFactory.initElements(driver, PasswordPage.class);
	}
}