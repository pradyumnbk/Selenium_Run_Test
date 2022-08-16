package seleniumTest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import com.java8.webDriverUtility.Base;

public class TestClass extends Base {

	@Test
	public void test() throws IOException {
	 driver.get("https://rahulshettyacademy.com/angularpractice/");
	 driver.switchTo().newWindow(WindowType.TAB);
	 Set<String> allWindow=driver.getWindowHandles();
		Iterator<String> it=allWindow.iterator();
		String parentWindow=it.next();
		String childWindow=it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://www.rahulshettyacademy.com/");
		String courseName=driver.findElements(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]/parent::h2"))
		.get(2).getText();
		driver.switchTo().window(parentWindow);
		WebElement name=driver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys(courseName);
		//screenshot
		File src=name.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/demo.png");
		FileUtils.copyFile(src, dest);
		//get height and width
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
	}
}
