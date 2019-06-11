package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Functions 
{
	WebDriver d;
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		d = new ChromeDriver();
		d.get("http://elearningm1.upskills.in/");
		d.manage().window().maximize();
	}
	
	public void login(String un, String pwd)
	{
		d.findElement(By.xpath("//*[@id='login']")).sendKeys(un);
		d.findElement(By.xpath("//*[@id='password']")).sendKeys(pwd);
		d.findElement(By.xpath("//*[@id='form-login_submitAuth']")).click();
	}
	
	public String read_excel(int r,int c, String sheet) throws IOException
	{
		String str = null;
		File f= new File("data.xlsx");
		FileInputStream fis= new FileInputStream(f);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis); 
		XSSFSheet sh= wb.getSheet(sheet);
		XSSFRow row= sh.getRow(r);
		XSSFCell cell= row.getCell(c);
		str= cell.getStringCellValue();
		return str;
	}
	
	
	public String change_password(String op, String np)
	{
		d.findElement(By.xpath("//*[@id='profileCollapse']/div/ul/li[4]/a")).click();
		d.findElement(By.xpath("//*[@id='profile_password0']")).sendKeys(op);
		d.findElement(By.xpath("//*[@id='password1']")).sendKeys(np);
		d.findElement(By.xpath("//*[@id='profile_password2']")).sendKeys(np);
		d.findElement(By.xpath("//*[@id='profile_apply_change']")).click();
		String msg= d.findElement(By.xpath("//*[@id='cm-content']/div/div/div/div[1]")).getText();
		return msg;
	}
	
	public String forgot_password(String email) throws InterruptedException
	{
		String str;
		d.findElement(By.xpath("//*[@id='login-block']/div/ul/li[2]/a")).click();
		WebDriverWait w= new WebDriverWait(d,10);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lost_password_user']")));
		d.findElement(By.xpath("//*[@id='lost_password_user']")).sendKeys(email);
		d.findElement(By.xpath("//*[@id='lost_password_submit']")).click();
		if(d.findElement(By.xpath("//*[@id='cm-content']/div/div/div[1]/div/div")).getText() != null)
		{
			 str= d.findElement(By.xpath("//*[@id='cm-content']/div/div/div[1]/div/div")).getText();
		}
		else
		{
			 str= d.findElement(By.xpath("//*[@id='cm-content']/div/div/div/div")).getText();
		}
		return str;
	}
	
	public String subscribe_course(String x)
	{
		d.findElement(By.xpath("//*[@id='coursesCollapse']/div/ul/li[3]/a")).click();
		d.findElement(By.xpath("//*[@id='cm-content']/div/div[1]/div/div/div/div[1]/form/div/input")).sendKeys(x);
		d.findElement(By.xpath("//*[@id='cm-content']/div/div[1]/div/div/div/div[1]/form/div/div/button")).click();
		d.findElement(By.xpath("//*[@id='cm-content']/div/div[2]/div[1]/div/div[2]/div[4]/div/a")).click();
		d.findElement(By.xpath("//*[@id='navbar']/ul[1]/li[2]/a")).click();
		String str_msg= d.findElement(By.xpath("//*[@id='page']/div/div[1]/div/div/div[2]/h4/a")).getText();
		return str_msg;	
	}
	
	public String verify_course()
	{
		d.findElement(By.xpath("//*[@id='navbar']/ul[1]/li[2]/a")).click();
		String str= d.findElement(By.xpath("//*[@id='page']/div/div/div/div/div[2]/h4/a[1]")).getText();
		return str;
	}
	
	public String take_test(String sub) throws InterruptedException
	{
		d.findElement(By.xpath("//*[@id='coursesCollapse']/div/ul/li[3]/a")).click();
		d.findElement(By.xpath("//*[@id='cm-content']/div/div[1]/div/div/div/div[1]/form/div/input")).sendKeys(sub);
		d.findElement(By.xpath("//*[@id='cm-content']/div/div[1]/div/div/div/div[1]/form/div/div/button")).click();
		d.findElement(By.xpath("//*[@id='cm-content']/div/div[2]/div/div/div[2]/div[4]/div/a")).click();
		d.findElement(By.xpath("//*[@id='navbar']/ul[1]/li[2]/a")).click();
		d.findElement(By.xpath("//*[@id='page']/div/div/div/div/div[2]/h4/a[1]")).click();
		d.findElement(By.xpath("//*[@id='toolimage_3615']")).click();
		d.findElement(By.xpath("//*[@id='exercise_list_12']/td[1]/a")).click();
		if(d.findElement(By.xpath("//*[@id='cm-content']/div/div/div[1]/div/a")).getText().equals("Start test"))
		{
			d.findElement(By.xpath("//*[@id='cm-content']/div/div/div[1]/div/a")).click();
		}
		else   
		{
			d.findElement(By.xpath("//*[@id='cm-content']/div/div/div[2]/div/a")).click();
		}
		List<WebElement> l = d.findElements(By.className("checkradios"));
		((WebElement) l.get(2)).click();
		d.findElement(By.xpath("//button[@name='save_now']")).click();
		d.findElement(By.xpath("//button[@name='save_now']")).click();
		d.findElement(By.xpath("//button[@name='save_now']")).click();
		d.findElement(By.xpath("//button[@name='save_now']")).click();						
		d.findElement(By.xpath("//button[@name='save_now']")).click();	
		String str= d.findElement(By.xpath("//*[@id='cm-content']/div/div[2]/h2")).getText();
		return str;
	}
	
	public String take_assessment(String sub)
	{
		d.findElement(By.xpath("//*[@id='navbar']/ul[1]/li[2]/a")).click();
		d.findElement(By.xpath("//*[@id='page']/div/div/div/div/div[2]/h4/a[1]")).click();
		d.findElement(By.xpath("//*[@id='toolimage_3625']")).click();
		d.findElement(By.xpath("//*[@id='gradebook_list']/tbody/tr[2]/td[2]/a")).click();
		d.findElement(By.xpath("//*[@id='cm-content']/div/div/div[1]/div/a")).click();
		List<WebElement> l = d.findElements(By.className("checkradios"));
		((WebElement) l.get(2)).click();
		d.findElement(By.xpath("//button[@name='save_now']")).click();
		d.findElement(By.xpath("//button[@name='save_now']")).click();
		d.findElement(By.xpath("//button[@name='save_now']")).click();
		d.findElement(By.xpath("//button[@name='save_now']")).click();						
		d.findElement(By.xpath("//button[@name='save_now']")).click();	
		String str= d.findElement(By.xpath("//*[@id='cm-content']/div/div[2]/h2")).getText();
		return str;
	}
	
	public String take_assignment(String sub) throws InterruptedException
	{
		d.findElement(By.xpath("//*[@id='navbar']/ul[1]/li[2]/a")).click();
		d.findElement(By.xpath("//*[@id='page']/div/div/div/div/div[2]/h4/a[1]")).click();
		d.findElement(By.xpath("//*[@id='toolimage_3622']")).click();
		Thread.sleep(5000);
		d.findElement(By.xpath("//*[@id='9']/td[2]/a")).click();
		d.findElement(By.xpath("//*[@id='toolbar-work']/div/div[2]/a")).click();
		d.findElement(By.xpath("//*[@id='tabs2']")).click();
		d.findElement(By.xpath("//*[@id='file_upload']")).sendKeys("Assignment");
		d.findElement(By.xpath("//*[@id='form-work_file']")).sendKeys("E:\\assignment.docx");
		d.findElement(By.xpath("//*[@id='form-work_submitWork']")).click();
		Thread.sleep(5000);
		String str= d.findElement(By.xpath("//*[@id='cm-content']/div/div/div/div")).getText();
		return str;                         
	}
	
	public String discuss(String title, String msg, String msg1) throws InterruptedException
	{
		d.findElement(By.xpath("//*[@id='navbar']/ul[1]/li[2]/a")).click();
		d.findElement(By.xpath("//*[@id='page']/div/div/div/div/div[2]/h4/a[1]")).click();
		d.findElement(By.xpath("//*[@id='toolimage_3617']")).click();
		d.findElement(By.xpath("//*[@id='cm-content']/div/div/div/div[3]/div/div/div/div[2]/h3/a[2]")).click();
		d.findElement(By.xpath("//*[@id='cm-content']/div/div[2]/ul/li[1]/a/img")).click();
		d.findElement(By.xpath("//*[@id='cm-content']/div/div[1]/a[2]/img")).click();
		d.findElement(By.xpath("//*[@id='thread_post_title']")).sendKeys(title);
		Thread.sleep(15000);    
		d.switchTo().frame((WebElement)d.findElement(By.xpath("//*[@id='cke_1_contents']/iframe"))); 
		d.findElement(By.className("cke_editable")).sendKeys(msg);
		d.switchTo().defaultContent();
		d.findElement(By.xpath("//*[@id='thread_SubmitPost']")).click();
		d.findElement(By.linkText("Reply to this message")).click(); 
		Thread.sleep(15000);
		d.switchTo().frame((WebElement)d.findElement(By.xpath("//*[@id='cke_1_contents']/iframe"))); 
		d.findElement(By.xpath("/html/body")).sendKeys(msg1);
		d.switchTo().defaultContent();
		d.findElement(By.xpath("//*[@id='thread_SubmitPost']")).click();
		String str= d.findElement(By.xpath("//*[@id='cm-content']/div/div[1]")).getText();
		return str;
	}
	
	public String group_chat(String text) throws InterruptedException
	{
		d.findElement(By.xpath("//*[@id='navbar']/ul[1]/li[2]/a")).click();
		d.findElement(By.xpath("//*[@id='page']/div/div/div/div/div[2]/h4/a[1]")).click();
		d.findElement(By.xpath("//*[@id='toolimage_3621']")).click();
		String msg = null;
		@SuppressWarnings("unused")
		String win= d.getWindowHandle();
		for(String str: d.getWindowHandles())
		  {
		     d.switchTo().window(str);
		  }
		d.findElement(By.xpath("//div[2]/div[2]/div/div/div/div/div/div/div/div")).click();
	    d.findElement(By.xpath("//div[2]/div[2]/div/div/div/div/div/div/div/div")).sendKeys(text);
	    d.findElement(By.xpath("//button[@id='chat-send-message']")).click();
		msg= text;
		return msg;						
	}							
														
	public String logout()
	{
		d.findElement(By.xpath("//*[@id='navbar']/ul[2]/li[2]/a/span[2]")).click();
		d.findElement(By.xpath("//*[@id='logout_button']")).click();
		String login_msg= d.findElement(By.xpath("//*[@id='form-login_submitAuth']")).getText();
		return login_msg;
	}

	public void exit() 
	{
		d.quit();
	}
	
}