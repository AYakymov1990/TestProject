import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

   private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){
//        System.setProperty("webdriver.gecko.driver", "D:\\MyProject\\seleniumtest\\driver\\geckodriver.exe");
//        driver=new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "D:\\MyProject\\seleniumtest\\driver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        loginPage=new LoginPage(driver);

        }

     @Test
     public void emptyField(){
        LoginPage newLoginPage=loginPage.LoginWithInvalidCreds("","");
        String error=newLoginPage.getErrorText();
         Assert.assertEquals("Incorrect username or password.",error);
     }
     @Test
     public void invalidCreds(){
        LoginPage newLoginPage=loginPage.LoginWithInvalidCreds("13131","fsfsfds");
        String error=newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.",error);

     }
     @Test
     public void createAccountButton(){
        SingUpPage singUpPage=loginPage.createAccount();
        String heading=singUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub",heading);
     }

    @After
    public void tearDown(){
        driver.quit();
    }







    }

