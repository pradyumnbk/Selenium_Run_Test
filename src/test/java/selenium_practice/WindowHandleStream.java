package selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleStream {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://deliver.courseavenue.com/PopupTest.aspx");
		driver.findElement(By.id("ctl00_ContentMain_popupTest")).click();
		String title = switchToWindowHandles(driver, "Google");
		System.out.println(title);
		driver.quit();
	}
	public static String switchToWindowHandles (WebDriver driver,String title) throws Throwable {
		return driver.getWindowHandles().stream()
		.map(handler->driver.switchTo().window(handler).getTitle())
		.filter(ele->ele.contains(title))
		.findFirst()
		.orElseThrow(()->{throw new RuntimeException("No such window present");});
	}
}
