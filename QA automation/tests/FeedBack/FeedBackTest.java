import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import FeedBack.FeedBack;

public class FeedBackTest extends FeedBack{

    FeedBack feedBack;

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    public FeedBackTest(){

    }

    @Before
    public void setUp() throws Exception {
        feedBack = new FeedBack();
        feedBack.open(new FirefoxDriver(), "http://codegroup.com.ua/projects/origi2/index.html");
    }

    @Test
    public void testFeedBack() throws Exception {
        feedBack.inputName("Игорь");
        feedBack.inputPhone("1234567890");
        feedBack.submit();
    }

    @After
    public void tearDown() throws Exception {

        feedBack.close();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
