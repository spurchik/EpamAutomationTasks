import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestExecution {

	WebDriver driver = new FirefoxDriver();

	@Before
	public void sutUp() {
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void search() throws IOException{

		Shooter shoot = PageFactory.initElements(driver, Shooter.class);
		shoot.shootWebElement();

	}

	@After
	public void tearDown() {
		driver.close();
	}
}
