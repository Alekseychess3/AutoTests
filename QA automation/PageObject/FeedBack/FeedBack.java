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

    WebDriver browser;
    WebElement element;

    private String idFeedBack="request-feedback", idName="feedback-name", idPhone="feedback-phone", idCall="";
    private String name="", phone="", call="";
    private String regName="^[a-z0-9_-]{3,30}$", regPhone="^[0-9]{10}$";

    public void open(WebDriver browser, String url){

        this.browser=browser;
        browser.get(url);

        browser.manage().window().maximize();
        browser.findElement(By.id(idFeedBack));
        browser.findElement(By.id(idFeedBack)).click();
    }

    public void inputName(String value){
        browser.findElement(By.id(idName));
        browser.findElement(By.id(idName)).click();
        browser.findElement(By.id(idName)).sendKeys(value);
        this.name=value;
    }

    public void inputPhone(String value){
        browser.findElement(By.id(idPhone));
        browser.findElement(By.id(idPhone)).click();
        browser.findElement(By.id(idPhone)).sendKeys(value);
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

        try {

            if (checkName(this.name) == true && checkPhone(this.phone) == true) {
                browser.findElement(By.linkText("Перезвоните мне!")).click();
                browser.findElement(By.id(idCall));
                this.call=element.getText();
            }
        }

        catch (Exception e){
            System.out.println("text after submitting not found");
        }




    }

    public void close(){
        browser.quit();
    }

    public String currentResult() {

        return this.call;
    }

    public String expectedResultValid() {
        return "Благодарим за заявку, в ближайшее вреся с Вами свяжется менеджер.";
    }

}
