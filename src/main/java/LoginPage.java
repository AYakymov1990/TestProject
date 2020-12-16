import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private    By loginPage =By.xpath("//input[@id=\"login_field\"]");
    private    By passwordPage=By.xpath("//input[@id=\"password\"]");
    private    By signInButton=By.xpath("//input[@class=\"btn btn-primary btn-block\"]");
    private  By heading=By.xpath("//h1[text()=\"Sign in to GitHub\"]");
    private  By error=By.xpath("//div[@class=\"container-lg px-2\"]");
    private By createAccLink=By.xpath("//a[text()=\"Create an account\"]");


    public  LoginPage userLogin(String login){
        driver.findElement(loginPage).sendKeys(login);
        return this;
    }
    public LoginPage userPassword(String password){
        driver.findElement(passwordPage).sendKeys(password);
        return this;
    }
    public LoginPage LoginWithInvalidCreds(String username,String password){
        this.userLogin(username);
        this.userPassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }
    public String getHiadingText(){
        return driver.findElement(heading).getText();
    }
    public String getErrorText(){
        return driver.findElement(error).getText();
    }
public SingUpPage createAccount(){
        driver.findElement(createAccLink).click();
        return new SingUpPage(driver);
}
}
