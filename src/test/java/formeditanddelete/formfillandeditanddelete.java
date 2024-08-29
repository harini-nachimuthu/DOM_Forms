package formeditanddelete;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class formfillandeditanddelete {
	protected String url="https://nifty-leakey-10bea0.netlify.app/";
	WebDriver driver=null;
  @Test
  public void f() throws InterruptedException {
	  WebElement fullname=driver.findElement(By.id("fullname"));
	  WebElement empcode=driver.findElement(By.id("empCode"));
	  WebElement salary=driver.findElement(By.id("salary"));
	  WebElement city=driver.findElement(By.id("city"));
	  WebElement submit=driver.findElement(By.xpath(" //input[@type='submit']")); 
	  
	  String[][] list1 = {
	            {"Aravink", "101", "400000", "Chennai"},
	            {"Babu", "102", "500000", "Bangalore"}
	        };

	       for (int i = 0; i < list1.length; i++) {
	            fullname.sendKeys(list1[i][0]);
	            empcode.sendKeys(list1[i][1]);
	            salary.sendKeys(list1[i][2]);
	            city.sendKeys(list1[i][3]);
	            submit.click();
	            Thread.sleep(2000);
	        }
	  WebElement edit=driver.findElement(By.xpath("//body//table//tbody//tr//td[2]//table//tbody//tr[1]//td[5]//button[1]")); 
	  edit.click();
	 
	  fullname.clear();
	  fullname.sendKeys("Aravind");
	  submit.click();
	  
	  Thread.sleep(2000);
	  
	  WebElement delete=driver.findElement(By.xpath("//body//table//tbody//tr//td[2]//table//tbody//tr[2]//td[5]//button[2]")); 
	  delete.click();
	  
	  Alert al=driver.switchTo().alert();
	  System.out.println(al.getText());
	  al.accept();
	  
	  Thread.sleep(1000);
	  
	  System.out.println("Successfully addded details and edited those things and finally deletion all done");
	  
  }
  @BeforeSuite
  public void beforesuit() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
  @BeforeClass
  public void classes() {
	  driver.get(url);
  }
  @AfterSuite
  public void aftre() {
	  driver.close();
  }
}
