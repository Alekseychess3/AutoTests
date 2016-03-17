package screenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;

import java.io.File;

public class ScreenShot {

    public ScreenShot(){

    }

    public WebDriver driver;
    public void openBrowser() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("");
        try {
            driver.findElement(By.id("testing")).sendKeys("test");
        }
        catch (Exception e){
            System.out.println("Fail ScreenShot");
            getscreenshot();
        }
    }

    public void getscreenshot() throws Exception
    {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
    }



}
