package selenium_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickCheckboxUsingStreams {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
		List<WebElement> allCheckbox = driver.findElements(By.xpath("//td[contains(@class,'select-checkbox')]"));
		allCheckbox.forEach(e->e.click());
		driver.quit();
	}

}
