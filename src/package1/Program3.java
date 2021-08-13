package package1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import jxl.read.biff.BiffException;

//will see how to integrate excel file for data parameterization  or provider

public class Program3 {
	
	static WebDriver dr ;
	
	// this function will focus on to setup browser and open website
	
	public static void setUp()
	{
		// configure the browser (means setting the required browser)
		System.setProperty("webdriver.edge.driver", "Driver\\msedgedriver.exe");
		dr = new EdgeDriver();  
		System.setProperty("webdriver.edge.driver", "Driver\\msedgedriver.exe");
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.manage().window().maximize();
		dr.get("https://demo.opencart.com/");
		
		
	}

	// this function will focus on to login and logout only, 
	public static void application12(String[] str) throws BiffException, IOException {	
		
		dr.findElement(By.xpath("//span[text()='My Account']")).click(); 
		dr.findElement(By.linkText("Login")).click();
		dr.findElement(By.name("email")).sendKeys(str[0]);
		dr.findElement(By.id("input-password")).sendKeys(str[1]);
		dr.findElement(By.xpath("//input[@value='Login']")).click();
		dr.findElement(By.linkText("Logout")).click();  // 
 
	//	ExcelIntegration.data();// calling function wich i have defined in ExcelIntegration Page
		
		
		
	}

}
