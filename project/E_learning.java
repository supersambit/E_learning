package project;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class E_learning 
{
	Functions f= new Functions();
  @Test(dataProvider="t1")
  public void changePassword(String u, String p, String np, String msg) throws IOException 
  {
	  f.login(u,p);
	  String p_msg= f.change_password(p, np);
	  Assert.assertEquals(p_msg, msg);
  }
  
  @Test(dataProvider="forgotPassword")
  public void forgotPassword(String em, String msg) throws IOException, InterruptedException 
  {
	  String p_reset= f.forgot_password(em);
	  Assert.assertEquals(p_reset, msg);
  }
  
  @Test(dataProvider="t3")
  public void subCourse(String un, String pwd, String msg) throws IOException, InterruptedException 
  {
	  f.login(un, pwd);
	  Thread.sleep(5000);
	  String alert= f.subscribe_course(msg);
	  Assert.assertEquals(alert, msg);
  }
  
  @Test(dataProvider="t4")
  public void verifyCourse(String un, String pwd, String msg) throws IOException 
  {
	  f.login(un, pwd);
	  String v_course= msg;
	  String res_vc= f.verify_course();
	  Assert.assertEquals(res_vc, v_course);
  }
  
  @Test(dataProvider="t5")
  public void logout(String un, String pwd, String msg) throws IOException 
  {
	  f.login(un, pwd);
	  String home= f.logout();
	  String lout= msg;
	  Assert.assertEquals(home, lout);
  }
  
  @BeforeMethod()
  public void launch()
  {
	  f.launch();  
  }
  
  @AfterMethod()
  public void exit()
  {
	  f.exit();  
  }
  
  @DataProvider(name="t1")
  public Object[][] getData1() throws IOException
	{
	  	String s= "pwd_change";
		Object[][] data = {{f.read_excel(1, 0, s), f.read_excel(1, 1, s), f.read_excel(1, 2, s), f.read_excel(1, 3, s)},{f.read_excel(2, 0, s), f.read_excel(2, 1, s), f.read_excel(2, 2, s), f.read_excel(2, 3, s)}};
		return data;
	}
  
  @DataProvider(name="forgotPassword")
  public Object[][] getData2() throws IOException
  {
	  String s= "forgot_pwd";
	  Object[][] data = {{f.read_excel(1, 0, s), f.read_excel(1, 1, s)},{f.read_excel(2, 0, s), f.read_excel(2, 1, s)}};
	  return data;
  }
  
  @DataProvider(name="t3")
  public Object[][] getData3() throws IOException
  {
	  String s= "sub_course";
	  Object[][] data = {{f.read_excel(1, 0, s), f.read_excel(1, 1, s), f.read_excel(1, 2, s)},{f.read_excel(2, 0, s), f.read_excel(2, 1, s), f.read_excel(2, 2, s)}};
	  return data;
  }
  
  @DataProvider(name="t4")
  public Object[][] getData4() throws IOException
  {
	  String s= "sub_course";
	  Object[][] data = {{f.read_excel(1, 0, s), f.read_excel(1, 1, s), f.read_excel(1, 2, s)},{f.read_excel(2, 0, s), f.read_excel(2, 1, s), f.read_excel(2, 2, s)}};
	  return data;
  }
  
  @DataProvider(name="t5")
  public Object[][] getData5() throws IOException
  {
	  String s= "logout";
	  Object[][] data = {{f.read_excel(1, 0, s), f.read_excel(1, 1, s), f.read_excel(1, 2, s)},{f.read_excel(2, 0, s), f.read_excel(2, 1, s), f.read_excel(2, 2, s)}};
	  return data;
  }
}
