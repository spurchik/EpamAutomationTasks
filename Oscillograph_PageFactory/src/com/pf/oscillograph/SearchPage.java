package com.pf.oscillograph;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends Page {

	public SearchPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(name = "q")
	private WebElement googleSearchField;

	@FindBy(name = "BtnK")
	private WebElement searchPageSearchButton;

	public ResultPage search(String textToFind) {
		googleSearchField.clear();
		googleSearchField.sendKeys(textToFind);
		googleSearchField.submit();
		return PageFactory.initElements(driver, ResultPage.class);
	}
}
