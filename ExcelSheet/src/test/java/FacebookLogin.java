import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookLogin
{

	WebDriver driver;
	@Test(dataProvider="wordpressdata")
	public void Login(String username,String password)throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rnagalli\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		
		
	}
	
	@DataProvider(name="wordpressdata")
	public Object[][] passData()
	{
		ExcelData config=new ExcelData("C:\\Users\\rnagalli\\Documents\\ExcelDataWorkBook.xlsx");
		int rows=config.getRowCount(0);
		Object[][] data=new Object[rows][2];
		for(int i=0;i<rows;i++)
		{
			
			data[i][0]=config.getData(0, i, 0);
			data[i][1]=config.getData(0, i, 1);
			
			
		}
		return data;
		
		
	}
	
	
}
