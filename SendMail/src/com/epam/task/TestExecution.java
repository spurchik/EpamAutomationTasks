package com.epam.task;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class TestExecution {
	WebDriver driver = new FirefoxDriver();

	private String userName = "UserName";
	private String password = "Password";
	private String mailAddress = "name@domain.com";
	private String letterHeader = "test letter header";
	private String messageText = "test message text";

	@Before
	public void setUp() {
		driver.get("https://someURL.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void sendingLetter() throws MessagingException,
			InterruptedException, AWTException {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		PasswordPage passwordPage = loginPage.emailSubmit(userName);
		LettersPage lettersPage = passwordPage.passwordSubmit(password);
		SentPage sentPage = lettersPage.letterSending(mailAddress,
				letterHeader, messageText);
		sentPage.sentCheck(letterHeader);
	}

	@After
	public void tearDown() {
		driver.close();
	}
}
