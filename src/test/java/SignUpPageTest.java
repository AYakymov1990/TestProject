import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    private WebDriver driver;
    private SingUpPage singUpPage;

    @Before
    public void setUp(){
//        System.setProperty("webdriver.gecko.driver", "D:\\MyProject\\testselenium\\drivers\\geckodriver.exe");
//        driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "D:\\MyProject\\seleniumtest\\driver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join");
        singUpPage=new SingUpPage(driver);
    }
    @Test
    public void registrInvalidCreds(){
        SingUpPage newSignUpPage=singUpPage.UserNameType("321312");
        SingUpPage newSp=singUpPage.EmailType("dadsasda");
        String errorLogin=singUpPage.getErrorTextLoginRegistr();
        String errorEmail=singUpPage.getErrorTextEmail();
        Assert.assertEquals("Username 321312 is not available.",errorLogin);
        Assert.assertEquals("Email is invalid or already taken",errorEmail);

    }




@After
    public void tearDown(){
        driver.quit();
}

}
