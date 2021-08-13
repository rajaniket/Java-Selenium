package package1;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class Program2 {
	
	static WebDriver dr; // global 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// configure the browser (means setting the required browser
				System.setProperty("webdriver.edge.driver", "Driver\\msedgedriver.exe");
				
				// Create a webdriver instance 
				 dr = new EdgeDriver();  // dr will keep grip over edge browser // and will open edge browser
				// like wise you can do it for chrome too
				
				// maximize the screen resolution 
				dr.manage().window().maximize();
				
				// to open an url --> get method
				dr.get("https://www.google.com");
				
				screenshot("Screenshot//pic1.png");  // function is defined below
				
				dr.get("https://demo.opencart.com/");
				
				screenshot("Screenshot//pic2.png");
				
				// counting all elements 
				
				int links = dr.findElements(By.tagName("a")).size();
				int images = dr.findElements(By.tagName("img")).size();
				int cb = dr.findElements(By.xpath("//*[@type='checkbox']")).size(); //* selects all elements in a document, regardless of name
				int rb = dr.findElements(By.xpath("//*[@type='radio']")).size();
				int tb = dr.findElements(By.xpath("//*[@type='text']")).size();
				
				System.out.println("no of links are :" +links);
				System.out.println("no of images are :" +images);
				System.out.println("no of checkboxes are :" +cb);
				System.out.println("no of radio buttons are :" +rb);
				System.out.println("no of text boxes are :" +tb);
				
				// selecting multiple select values
				dr.get("https://compendiumdev.co.uk/basic_html_form.html");
				
				// if html tag name is select then only u can use this 
				Select s = new Select(dr.findElement(By.name("multipleselect[]")));
				s.deselectAll();
				s.selectByValue("ms2");
				s.selectByVisibleText("Selection Item 4");
				s.selectByIndex(0);
				
				// after execution you will see change in webpage that 3 items has been selected
				

				
				
	}
	
	public static void screenshot(String filepath)
	{
		// at what instance we need capture
		TakesScreenshot sc = (TakesScreenshot)dr;
		
		// how to capture and store
		File sf = sc.getScreenshotAs(OutputType.FILE);  // it will stor in the system
		
		// to save it in a other destination 
		File df = new File(filepath);
		
		// in case path is not found then catch 
		try {
			Files.copy(sf, df);
		} catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

}
