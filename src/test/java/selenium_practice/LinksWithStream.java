package selenium_practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksWithStream {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.freshworks.com/");
//		List<WebElement> allLinks=driver.findElements(By.xpath("//ul[@class='footer-nav']/li"));
//		List<String> footerList=new ArrayList<String>();
//		allLinks.stream().forEach(e-> footerList.add(e.getText()));
//		footerList.forEach(System.out::println);
		driver.findElements(By.xpath("//ul[@class='footer-nav']/li")).stream().forEach(e->System.out.println(e.getText()));
		driver.close();
	}

}
