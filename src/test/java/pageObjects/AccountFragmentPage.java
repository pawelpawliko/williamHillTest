package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountFragmentPage {

    public AccountFragmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "accountTabButton")
    private WebElement accountTabButton;

    @FindBy(id = "loginUsernameInput")
    private WebElement loginUsernameInput;

    @FindBy(id = "loginPasswordInput")
    private WebElement loginPasswordInput;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    public void login(String username, String password) {
        accountTabButton.click();
        loginUsernameInput.sendKeys(username);
        loginPasswordInput.sendKeys(password);
        loginButton.click();
    }
}