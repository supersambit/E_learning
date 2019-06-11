package project;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class E_learning2 
{
	Functions f= new Functions();
  @Test(dataProvider= "takeTest", priority=1)
  public void testakeTest(String un, String pwd, String sub, String exp) throws InterruptedException 
  {
	  f.login(un, pwd);
	  String ac= f.take_test(sub);
	  Assert.assertTrue(ac.contains(exp));
  }
  
  @Test(dataProvider= "takeAssessment", priority=2)
  public void testakeAssessment(String un, String pwd, String sub, String exp) 
  {
	  f.login(un, pwd);
	  String ac= f.take_assessment(sub);
	  Assert.assertTrue(ac.contains(exp));
  }
  
  @Test(dataProvider= "takeAssignment", priority=3)
  public void testakeAssignment(String un, String pwd, String sub, String exp) throws InterruptedException 
  {
	  f.login(un, pwd);
	  String ac= f.take_assignment(sub);
	  Assert.assertEquals(ac, exp);
  }
  
  @Test(dataProvider= "disscuss", priority=4)
  public void discuss(String un, String pwd, String title, String msg, String msg1, String exp) throws InterruptedException 
  {
	  f.login(un, pwd);
	  String ac= f.discuss(title, msg, msg1);
	  Assert.assertEquals(ac, exp);
  }
  
  @Test(dataProvider= "chat", priority=5)
  public void teschat(String un, String pwd, String text, String exp) throws InterruptedException 
  {
	  f.login(un, pwd);
	  String ac= f.group_chat(text);
	  Assert.assertEquals(ac, exp); 
  }
  
  @BeforeMethod
  public void bm()
  {
	  f.launch();
  }
  
  @AfterMethod
  public void am()
  {
	  f.exit();
  }
  
  @DataProvider(name="takeTest")
  public Object[][] getData6() throws IOException
	{
	  	String s= "t6";
		Object[][] data = {{f.read_excel(1, 0, s), f.read_excel(1, 1, s), f.read_excel(1, 2, s), f.read_excel(1, 3, s)},{f.read_excel(2, 0, s), f.read_excel(2, 1, s), f.read_excel(2, 2, s), f.read_excel(2, 3, s)}};
		return data;
	}
  
  @DataProvider(name="takeAssessment")
  public Object[][] getData7() throws IOException
  {
	  String s= "t7";
	  Object[][] data = {{f.read_excel(1, 0, s), f.read_excel(1, 1, s), f.read_excel(1, 2, s), f.read_excel(1, 3, s)},{f.read_excel(2, 0, s), f.read_excel(2, 1, s), f.read_excel(2, 2, s), f.read_excel(2, 3, s)}};
	  return data;
  }
  
  @DataProvider(name="takeAssignment")
  public Object[][] getData8() throws IOException
  {
	  String s= "t8";
	  Object[][] data = {{f.read_excel(1, 0, s), f.read_excel(1, 1, s), f.read_excel(1, 2, s), f.read_excel(1, 3, s)},{f.read_excel(2, 0, s), f.read_excel(2, 1, s), f.read_excel(2, 2, s), f.read_excel(2, 3, s)}};
	  return data;
  }
  
  @DataProvider(name="disscuss")
  public Object[][] getData9() throws IOException
  {
	  String s= "t9";
	  Object[][] data = {{f.read_excel(1, 0, s), f.read_excel(1, 1, s), f.read_excel(1, 2, s), f.read_excel(1, 3, s), f.read_excel(1, 4, s),  f.read_excel(1, 5, s)},{f.read_excel(2, 0, s), f.read_excel(2, 1, s), f.read_excel(2, 2, s), f.read_excel(2, 3, s), f.read_excel(2, 4, s),  f.read_excel(2, 5, s)}};
	  return data;
  }
  
  @DataProvider(name="chat")
  public Object[][] getData10() throws IOException
  {
	  String s= "t10";
	  Object[][] data = {{f.read_excel(1, 0, s), f.read_excel(1, 1, s), f.read_excel(1, 2, s), f.read_excel(1, 3, s)},{f.read_excel(2, 0, s), f.read_excel(2, 1, s), f.read_excel(2, 2, s), f.read_excel(2, 3, s)}};
	  return data;
  }
}
