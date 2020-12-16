import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClassTest {
private WebDriver driver;
private MainPage mainPage;

@Before
    public void setUp(){
//    System.setProperty("webdriver.gecko.driver", "D:\\MyProject\\seleniumtest\\driver\\geckodriver.exe");
//    driver=new FirefoxDriver();
    System.setProperty("webdriver.chrome.driver", "D:\\MyProject\\seleniumtest\\driver\\chromedriver.exe");
    driver= new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://github.com/");
    mainPage=new MainPage(driver);
}
@Test
public void signIn(){
    LoginPage loginPage=mainPage.clickSignIn();
    String heading=loginPage.getHiadingText();
    Assert.assertEquals("Sign in to GitHub",heading);
}
@Test
public void signUp(){
    SingUpPage singUpPage=mainPage.clickSignUp();
    String heading=singUpPage.getHeadingText();
    Assert.assertEquals("Join GitHub",heading);

}
@Test
public void emptyFields(){
    SingUpPage singUpPage=mainPage.clickSignUpForGithubButton();
    String errorLogin=singUpPage.errorTextLogin();
    Assert.assertEquals("Username can't be blank",errorLogin);
    String errorEmail=singUpPage.errorTextEmail();
    Assert.assertEquals("Email can't be blank",errorEmail);
    String errorPassword=singUpPage.errorTextPassword();
    Assert.assertEquals("Password can't be blank",errorPassword);
}
@Test
public void registerFailTest(){
    SingUpPage singUpPage=mainPage.register("12324","ffrfe","");
    String errorTextLogin=singUpPage.getErrorTextLogin();
    Assert.assertEquals("Username is not available",errorTextLogin);
    String errorTextEmail=singUpPage.getErrorTextEmail();
    Assert.assertEquals("Email is invalid or already taken",errorTextEmail);
}










@After
    public void tearDown(){
    driver.quit();
}

}
