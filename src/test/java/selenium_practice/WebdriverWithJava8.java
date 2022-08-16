package selenium_practice;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverWithJava8 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		//allLinks.stream().map(e->e.getText()).forEach(System.out::println);
		//1.
		//allLinks.forEach(e->System.out.println(e.getText()));
		//2.
		allLinks.stream().filter(e->!e.getText().equals("")).map(ele->ele.getText()).forEach(System.out::println);
		//3.
		//String firstText = allLinks.stream().filter(e->!e.getText().equals("")).findFirst().get().getText();
		//System.out.println(firstText);
		//4. exclude blank text and which starts with amazon
		//allLinks.stream().filter(e->!e.getText().equals("") && e.getText().startsWith("Amazon")).forEach(e->System.out.println(e.getText()));
		/*for(WebElement element:allLinks)
			System.out.println(element.getText());*/
		driver.quit();
	}

}
