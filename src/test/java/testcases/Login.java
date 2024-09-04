package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;
import utility.ScreenShot2;

public class Login extends Hook
{
	public static boolean login = false;
  @Test(priority = 1,groups="login")
  public void chkuserid() 
  {
	  test = report.createTest("UseridTest");
	  signin.click();
	  uid.sendKeys("paragguide@yahoo.co.in");
	  
	  test.log(Status.INFO, MarkupHelper.createLabel("Enter valid userid ..", ExtentColor.BLUE));
	  
	  ctnbtn.click();
	      
	  if(err1.isDisplayed())
	  {
		  System.out.println("yes...");
		  test.log(Status.FAIL, MarkupHelper.createLabel("error coming when userid is valid..", ExtentColor.RED));
			
		  Assert.fail("error coming when userid is valid..");
		    
	  }
	  else
	  {
		  System.out.println("no...");
		  test.log(Status.PASS, MarkupHelper.createLabel("userid is valid..", ExtentColor.GREEN));
		  
	  }
	  
	    
  }
  
  @Test(priority = 2, dependsOnMethods={"chkuserid"},groups="login")
  public void chkpassword() throws Exception
  {
	  test = report.createTest("PasswordTest");
	  pwd.sendKeys("RMinfotech12#&&");
	  
	  test.log(Status.INFO, MarkupHelper.createLabel("Enter valid passwordd ..", ExtentColor.BLUE));
	  
	  submit.click();
	    try {
	  err2.getText();
	  test.log(Status.FAIL, MarkupHelper.createLabel("error coming when password is valid..", ExtentColor.RED));
		
	  Assert.fail("error coming when password is valid..");
	    
	    }
	    catch(Exception e)
	    {
	  test.log(Status.PASS, MarkupHelper.createLabel("password is valid..Loged in", ExtentColor.GREEN));
	  ScreenShot2.takeScreenshot("LoginSucsess");	
	  
	  login = true;
	    }
  }
}
