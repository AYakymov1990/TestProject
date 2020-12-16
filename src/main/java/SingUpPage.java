import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingUpPage {
    WebDriver driver;

    public SingUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading=By.xpath("//div[text()=\"Join GitHub\"]");
    private By signUpButton=By.xpath("//button[@id=\"signup_button\"]");
    private By usernameType=By.xpath("//input[@id=\"user_login\"]");
    private By emailType=By.xpath("//input[@id=\"user_email\"]");
    private By passwordType=By.xpath("//input[@id=\"user_password\"]");
    private  By errorLogin=By.xpath("//dd[text()=\"Username can't be blank\"]");
    private By errorEmail=By.xpath("//dd[text()=\"Email can't be blank\"]");
    private By errorPassword=By.xpath("//dd[text()=\"Password can't be blank\"]");
    private By errorTextLogin=By.xpath("//dd[text()=\"Username is not available\"]");
    private By errorTextEmail=By.xpath("//dd[text()=\"Email is invalid or already taken\"]");
    private By errorTextLoginRegister=By.xpath("//dd[@class=\"error\"]//div[@class=\"mb-1 \"]");



    public SingUpPage UserNameType (String username){
        driver.findElement(usernameType).sendKeys(username);
        return this;
    }

    public SingUpPage EmailType(String email){
        driver.findElement(emailType).sendKeys(email);
        return this;
    }

    public SingUpPage PasswordType(String password){
        driver.findElement(passwordType).sendKeys(password);
        return this;
    }
    public SingUpPage register(String username,String email,String password){
        this.UserNameType(username);
        this.EmailType(email);
        this.PasswordType(password);
        driver.findElement(signUpButton).click();
        return new SingUpPage(driver);
    }
    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }
    public String errorTextLogin(){
        return driver.findElement(errorLogin).getText();
    }
    public String errorTextEmail(){
        return driver.findElement(errorEmail).getText();
    }
    public String errorTextPassword(){
        return  driver.findElement(errorPassword).getText();
    }
    public String getErrorTextLogin(){
        return  driver.findElement(errorTextLogin).getText();
    }
    public String getErrorTextEmail(){
        return  driver.findElement(errorTextEmail).getText();
    }
    public String getErrorTextLoginRegistr(){
        return driver.findElement(errorTextLoginRegister).getText();
    }

}
