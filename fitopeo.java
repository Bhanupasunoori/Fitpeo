package Fitpeo.ass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fitopeo {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.fitpeo.com/");// Navigate to fitpeo site
		driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();//navigate to revenue calculator tab
		Thread.sleep(3000);
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		WebElement slider=driver.findElement(By.cssSelector("input[type='range']"));// setting the slider value
		Actions action =new Actions(driver);
		Thread.sleep(3000);
		action.dragAndDropBy(slider, 94, 0).perform();
		Thread.sleep(6000);
		
		action.dragAndDropBy(slider,-200, 0).perform();//setting slider value to 0 to give new value
		Thread.sleep(3000);
		WebElement slidertxt =driver.findElement(By.cssSelector("input[type='number']"));
		Thread.sleep(5000);
		if(slidertxt.isDisplayed()) {
		if(slidertxt.isEnabled()) {
			slidertxt.clear();
			Thread.sleep(3000);
			slidertxt.sendKeys("560");// send 560 value and checked slider
		}
		}
		Thread.sleep(4000);
		action.dragAndDropBy(slider,-200, 0).perform();// setting slider to 0 to give new value
		Thread.sleep(3000);
		slidertxt.clear();
		Thread.sleep(3000);
		slidertxt.sendKeys("820");// entered 820
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='57']")).click();// checked CPT-99091
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='19.19']")).click();// Checked CPT-99453
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='63']")).click();// Checked CPT-99454
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='15']")).click();// checked CPT-99474
		Thread.sleep(5000);
		WebElement Total=driver.findElement(By.xpath("//p[contains(text(),'Total Recurring Reimbursement for all Patients Per Month:')]"));
		System.out.println(Total.getAttribute("value"));
		Thread.sleep(5000);
		driver.close();

	}

}
