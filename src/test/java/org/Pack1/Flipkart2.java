package org.Pack1;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Flipkart2 {
	public static void main(String[] args)throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.get("https://www.flipkart.com/?affid=ideaclano&affExtParam1=sunny&");
		d.manage().window().maximize();
		
		try {
			WebElement alert = d.findElement(By.xpath("//button[text()='✕']"));
			alert.click();
		}catch(Exception e)
		{
			
		}
		Thread.sleep(2000);

		WebElement search = d.findElement(By.xpath("//input[@type='text']"));
		WebElement button = d.findElement(By.xpath("//button[@type='submit']"));
		search.sendKeys("mobiles");
		button.click();
		
		Thread.sleep(3000);

		/*WebElement mob = d.findElement(By.xpath("//div[text()='REDMI 9i (Sea Blue, 64 GB)']"));
		mob.click();
		
		String win1 = d.getWindowHandle();
		Set<String> win2 = d.getWindowHandles();
		for(String s : win2) {
			if(!win1.equals(s)) {
				d.switchTo().window(s);
				WebElement name = d.findElement(By.xpath("//span[text()='REDMI 9i (Sea Blue, 64 GB)']"));
				String model = name.getText();
				System.out.println(model);
			}
		}*/
		
		File location = new File(".//Test1//Data1.xls");
		
		FileOutputStream write = new FileOutputStream(location);
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Mobile");
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("mobilename");
		
		List<WebElement> mnames = d.findElements(By.xpath("//div[contains(text(),'GB)')]"));
		int i=mnames.size();
		 WebElement a;
		for(int j=0; j<i; j++) {
			a= mnames.get(j);
			HSSFRow column1 = sheet.createRow(j+1);
			HSSFCell celldata = column1.createCell(0);
			celldata.setCellValue(a.getText());
		}
			
		
		
		wb.write(write);
		write.close();
		
	}

}
