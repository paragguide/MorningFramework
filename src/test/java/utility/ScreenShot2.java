package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import core.Page;

public class ScreenShot2 extends Page
{

	
	
	public static void takeScreenshot(String srnname) throws Exception
	{
		String path = System.getProperty("user.dir")+"//src//test//java//screenshot//"+srnname+".jpg";
	
		TakesScreenshot ts = (TakesScreenshot)driver;
		File tmp = ts.getScreenshotAs(OutputType.FILE); // store screenshot in tmp location
	
	FileUtils.copyFile(tmp, new File(path));
	}
	
	public static void main(String[] args)
	{
		ScreenShot2 s = new ScreenShot2();
		

	}

}
