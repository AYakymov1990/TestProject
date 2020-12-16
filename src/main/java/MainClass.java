import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args){
       // System.setProperty("webdriver.gecko.driver", "D:\\MyProject\\testselenium\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:\\MyProject\\seleniumtest\\chromedriver.exe");
          driver= new ChromeDriver();
     //   driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get("https://github.com/");
        MainPage mainPage=new MainPage(driver);

        mainPage.register("jakim1990","jakim1990@sdasad","jakim19900");

    }
}
