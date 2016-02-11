package com.epam.task;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LettersPage extends Page {

	public LettersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = ".//*[@class='z0']/div")
	WebElement createLetterButton;

	@FindBy(xpath = "//form[1]//textarea[1]")
	WebElement recipientAddressField;

	@FindBy(xpath = "//form/div[3]/input")
	WebElement letterHeaderField;

	@FindBy(xpath = "//tbody//td[2]/div[2]/div")
	WebElement messageField;

	@FindBy(xpath = "//div[@class='a1 aaA aMZ']")
	WebElement attachmentButton;

	@FindBy(xpath = "//div[text()=\"Отправить\"]")
	WebElement sendButton;

	public SentPage letterSending(String mailAddress, String letterHeader,
			String messageText) throws
			InterruptedException, MessagingException, AWTException {
		createLetterButton.click();
		recipientAddressField.sendKeys(mailAddress);
		letterHeaderField.click();
		letterHeaderField.sendKeys(letterHeader);
		messageField.sendKeys(messageText);
		fileAttachment();
		sendButton.click();
		return PageFactory.initElements(driver, SentPage.class);
	}

	public void fileAttachment() throws MessagingException, AWTException,
			InterruptedException {
		attachmentButton.click();
		StringSelection ss = new StringSelection(
				"C:\\Selenium\\Screenshots\\Screen01.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(6000);

	}
}
