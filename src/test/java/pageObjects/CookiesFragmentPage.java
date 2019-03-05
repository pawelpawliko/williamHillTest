package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookiesFragmentPage {

    public CookiesFragmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"toolbar\"]/div[1]/div/button")
    private WebElement acceptCookiesButtom;

    public void clickToAcceptCookies() {
        StaleElement.clickStaleElement(acceptCookiesButtom);
    }
}