package package1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// configure the browser (means setting the required browser
		System.setProperty("webdriver.edge.driver", "Driver\\msedgedriver.exe");
		
		// Create a webdriver instance 
		
		WebDriver dr = new EdgeDriver();  // dr will keep grip over edge browser // and will open edge browser
		// like wise you can do it for chrome too
		
		// maximize the screen resolution 
		dr.manage().window().maximize();
		
		// to open an url --> get method
		dr.get("https://demo.opencart.com/");
		// if a page is taking time to load use some wait conditions
		//use implicitlyWait -> this wait for certain duration till the page is loaded
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// for fetching current url
		System.out.println("URL : "+dr.getCurrentUrl());
		
		// for fetching current title
		System.out.println("Title : "+dr.getTitle());
		
		
		//work with web element
		// click on my account
		dr.findElement(By.xpath("//span[text()='My Account']")).click();  // checking for text my account , it is not an attribute that's why @ is not used
		// or 
	//	dr.findElement(By.xpath("//span[contains(text(),'My Account']")).click();
		
		// clicking on login ,, login is linked to myaccount  // how to know that when to use linkText just inspect element in browser if its tag starts from <a means it is linkText
		dr.findElement(By.linkText("Login")).click(); // linkText means text containing a link
		
		// write email in box
		dr.findElement(By.name("email")).sendKeys("hemanth1@gmail.com");
		
		// write password
		dr.findElement(By.id("input-password")).sendKeys("wipro@123");
		
		// click on login 
		// as there is no By.type and By.class so here we have to use xpath
		dr.findElement(By.xpath("//input[@value='Login']")).click();
		
         // this password option is a part of list-group	
		String actualResult = dr.findElement(By.linkText("Password")).getText();  // 
		
		System.out.println("expected url is : "+actualResult);
		
		String exceptedResult = "Account Password";
		
		if(actualResult.equals(exceptedResult))
		{
			System.out.println("element is validated properly");
			
		}
		else System.out.println("elemnt is incorrect");
		
		// for closing the browser
		//dr.close();
		

	}

}
