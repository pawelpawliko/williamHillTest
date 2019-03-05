package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopSideBarAZFragmentPage {
    private WebDriver driver;

    public DesktopSideBarAZFragmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Football")
    private WebElement footballButton;

    public void chooseFootballFromDesktopSideBar() {
        StaleElement.clickStaleElement(footballButton);
    }
}