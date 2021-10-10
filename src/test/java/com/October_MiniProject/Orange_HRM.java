package com.October_MiniProject;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Orange_HRM {
	
	static int indexOfusername,indexOfUserRole,indexOfEmployeeName,indexOfStatus;
	static String s="raja.sekar123";
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"E:\\rajasekar mobile\\eclipse workspace\\seleniumproj\\driver\\driver1\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement userpass = driver.findElement(By.xpath("//span[text()='( Username : Admin | Password : admin123 )']"));
		String text = userpass.getText();
		String[] split = text.split(" ");
		for (String string : split) {
//			System.out.println(string);
			if (string.equalsIgnoreCase("Admin")) {
				System.out.println("User Name :" +string);	
			}else if (string.equalsIgnoreCase("admin123")) {
				System.out.println("Password :" +string);
				System.out.println("----------------------------------------------------");
			}
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[2]/input")).sendKeys("Admin");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[3]/input")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
			
		driver.findElement(By.xpath("//b[text()='Admin']")).click();
		List<WebElement> table = driver.findElements(By.xpath("//table[@id='resultTable']/thead/tr/th"));
		for (int i = 0; i < table.size(); i++) {
			String text1 = table.get(i).getText();
//			System.out.println(text2);
			if (text1.equalsIgnoreCase("username")) {
				indexOfusername=i;
				System.out.println("indexOf username :"+indexOfusername);
				}else if (text1.equalsIgnoreCase("Employee Name")) {
				indexOfEmployeeName=i;
				System.out.println("indexOf EmployeeName :"+indexOfEmployeeName);
				}else if (text1.equalsIgnoreCase("Status")) {
				indexOfStatus=i;
				System.out.println("indexOf Status :"+indexOfStatus);
				}else if (text1.equalsIgnoreCase("User Role")) {
				indexOfUserRole=i;
				System.out.println("indexOf UserRole :"+indexOfUserRole);			
				}
			}
		System.out.println("----------------------------------------------------");	
		List<WebElement> allrow = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		for (int i = 0; i < allrow.size(); i++) {
			List<WebElement> alldata = allrow.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < alldata.size(); j++) {
				if (alldata.get(j).getText().equalsIgnoreCase(s)) {
				System.out.println("employee name :"+s);
				System.out.println("Username :"+alldata.get(indexOfusername).getText());
				System.out.println("User Role :"+alldata.get(indexOfUserRole).getText());
				System.out.println("Employee Name :"+alldata.get(indexOfEmployeeName).getText());
				System.out.println("Status :"+alldata.get(indexOfStatus).getText());					
			}		
	}				
			}
	}
}