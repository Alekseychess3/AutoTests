package FeedBack;
import org.openqa.selenium.By;
import pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import pages.Page;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FeedBack{

    WebDriver driver;
    WebElement element;

    private String idFeedBack="request-feedback", idName="feedback-name", idPhone="feedback-phone", idCall="";
    private String name="", phone="";
    private String regName="^[a-z0-9_-]{3,30}$", regPhone="^[0-9]{10}$";

    public void open(WebDriver browser, String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void inputName(String value){
        driver.findElement(By.id(idName));
        element.click();
        element.sendKeys(value);
        this.name=value;
    }

    public void inputPhone(String value){
        driver.findElement(By.id(idPhone));
        element.click();
        element.click();
        element.sendKeys(value);
        this.phone=value;
    }

    public boolean checkName(String name){
        Pattern regName = Pattern.compile(this.regName);
        Matcher matcher = regName.matcher(name);
        return matcher.matches();
    }

    public boolean checkPhone(String phone){
        Pattern regPhone = Pattern.compile(this.regPhone);
        Matcher matcher = regPhone.matcher(phone);
        return matcher.matches();
    }


    public void submit(){
        checkName(this.name);
        this.checkPhone(this.phone);


        try {

            if (checkName(this.name) == true && checkPhone(this.phone) == true) {
                driver.findElement(By.linkText("Перезвоните мне!")).click();
                driver.findElement(By.id(idCall));
            }
        }

        catch (Exception e){
            System.out.println("text after submitting not found");
        }


    }

    public void close(){
        driver.quit();
    }

    public String currentResult() {

        return "result";
    }

    public String expectedResultValid() {
        return "Благодарим за заявку, в ближайшее вреся с Вами свяжется менеджер.";
    }

}
