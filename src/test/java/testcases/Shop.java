package testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;
import utility.MakeConnectionPOI;
import utility.ScreenShot2;

public class Shop extends Hook
{
  @Test(dataProvider="getdata",priority = 1,dependsOnGroups = {"login"})
  public void searchProducts(String product) throws Exception 
  {
	  test = report.createTest("SearchTest");
	  searchtxtbox.clear();
	  searchtxtbox.sendKeys(product);
	  
	  Actions a = new Actions(driver);
	  a.sendKeys(Keys.ENTER).perform();
	  
	 int p1 = productsnames.size();
	 int p2 = productslinks.size();
	  
	  if(p1 > 0 && p2 > 0)
	  {
  test.log(Status.PASS, MarkupHelper.createLabel("Product result found..", ExtentColor.GREEN));
	ScreenShot2.takeScreenshot("ProductResult");	 
	
	addtokart();
	  }
	  else
	  {
	Assert.fail("No products found");	
	test.log(Status.FAIL, MarkupHelper.createLabel("NO products found..", ExtentColor.RED));
	  
	  }
  }
  
  @DataProvider
  public String[][] getdata() throws Exception
  {
	  return MakeConnectionPOI.getData("AmazonLogin", "Sheet2");
  }
  
  //@Test(priority = 2,dependsOnMethods = {"searchProducts"})
  public void addtokart() throws Exception
  {
	  test = report.createTest("addtokart");
	Iterator  <WebElement> it =  productslinks.iterator();
	
	for(int i=1;i < 5;i++)
		{
		    WebElement e = it.next();
			System.out.println(e.getText());
			//Thread.sleep(4000);
			
			e.click();  // open product on new tab
			
			
		   	Thread.sleep(5000);
		   	 
		Set <String> tabs =	driver.getWindowHandles();
		
		System.out.println("tabs ..... "+tabs.size());
		
		Iterator <String> it2 =  tabs.iterator();
		
		String resultpage = it2.next(); // tab 1
		String productpage = it2.next(); // tab 2
		
		driver.switchTo().window(productpage);
	
	System.out.println("switchto productpage...");
	
		test.log(Status.PASS, MarkupHelper.createLabel("Product link found.."+i, ExtentColor.GREEN));
		ScreenShot2.takeScreenshot("ProductDescp-"+i);	  	  
		
		
//		addtokart.click();
//		test.log(Status.PASS, MarkupHelper.createLabel("Product added to kart.."+i, ExtentColor.GREEN));
		
		 driver.close(); // close current tab
		 
		 System.out.println("close productpage...");	
		 
		driver.switchTo().window(resultpage);
		
		System.out.println("switchto resultpage...");
		
	}
  }
}
