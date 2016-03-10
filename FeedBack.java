package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FeedBack extends Page {

    WebDriver driver;
    WebElement element;

    String id="", name="", xpath="", link="";

    private String url="";
    public FeedBack(String url){
        this.url=url;
    }



    @Override
    public void fillingFields() {
        driver.get(this.url);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Override
    public void steps() {
        driver.findElement(By.id("request-feedback")).click();
        driver.findElement(By.id("feedback-name")).clear();
        driver.findElement(By.id("feedback-name")).sendKeys("alex");
        driver.findElement(By.id("feedback-phone")).click();
        driver.findElement(By.id("feedback-phone")).clear();
        driver.findElement(By.id("feedback-phone")).sendKeys("234234234");
        driver.findElement(By.linkText("Перезвоните мне!")).click();
    }

    @Override
    public string currentResult() {

        return "result";
    }

    @Override
    public string expectedResult() {
        return "result";
    }

    public boolean insertDB(){

    }



}
