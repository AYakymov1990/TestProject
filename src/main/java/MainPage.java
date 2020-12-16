import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private By signInButton=By.xpath("//a[@class=\"HeaderMenu-link no-underline mr-3\"]");
    private By singUpButton=By.xpath("//a[@class=\"HeaderMenu-link d-inline-block no-underline border border-gray-dark rounded-1 px-2 py-1\"]");
    private By loginField=By.xpath("//input[@id=\"user[login]\"]");
    private By passwordField=By.xpath("//input[@id=\"user[password]\"]");
    private By emailField=By.xpath("//input[@id=\"user[email]\"]");
    private By signInUpForGithubButton=By.xpath("//button[@class=\"btn-mktg btn-primary-mktg btn-large-mktg f4 btn-block my-3\"]");


    public LoginPage clickSignIn(){
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }
    public SingUpPage clickSignUp() {
        driver.findElement(singUpButton).click();
        return new SingUpPage(driver);
    }
    public SingUpPage clickSignUpForGithubButton() {
        driver.findElement(signInUpForGithubButton).click();
        return new SingUpPage(driver);
    }
    public MainPage typeLogin(String login){
        driver.findElement(loginField).sendKeys(login);
        return this;
    }
    public MainPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public MainPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
    public SingUpPage register(String login,String email,String password){
        this.typeLogin(login);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpForGithubButton();
        return new SingUpPage(driver);
    }

}
