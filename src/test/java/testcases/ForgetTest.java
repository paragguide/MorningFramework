package testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;

public class ForgetTest extends Hook
{
  @Test
  public void forget() 
  {
	  if(Login.login == false)
	  {
		  test = report.createTest("Steps");
		  forgetpwdlink.click();
		  forgetuid.clear();
		  forgetuid.sendKeys("paragguide@yahoo.co.in");
		  forgetctnbtn.click();
		  test.log(Status.INFO, MarkupHelper.createLabel("recovered pwd ..", ExtentColor.BLUE));
		  
	  }
	  else
	  {
		  throw new SkipException("login valid..");
	  }
  }
}
