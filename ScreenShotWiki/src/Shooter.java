import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Shooter extends Page {

	public Shooter(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = ".//*[@id='mp-itn']//li[3]")
	WebElement elementToShot;

	public void shootWebElement() throws IOException {

		File screen = ((TakesScreenshot) this.driver)
				.getScreenshotAs(OutputType.FILE);

		Point p = elementToShot.getLocation();

		int width = elementToShot.getSize().getWidth();
		int height = elementToShot.getSize().getHeight();

		BufferedImage img = ImageIO.read(screen);

		BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width, height);

		ImageIO.write(dest, "png", screen);

		File f = new File("C:\\Selenium\\Screenshots\\Screen02.png");

		FileUtils.copyFile(screen, f);

	}
}
