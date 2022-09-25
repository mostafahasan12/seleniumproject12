package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
// method to take screenshot when the case fail
	public static void captureScreenshot(WebDriver driver , String screenshotnames) {
		Path destination = Paths.get("./Screenshots",screenshotnames+".png");
		try {
			Files.createDirectories(destination.getParent());
			FileOutputStream out = new FileOutputStream(destination.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {			
		System.out.println("Expection while taking screenshot"+ e.getMessage());
		}
	}
}
