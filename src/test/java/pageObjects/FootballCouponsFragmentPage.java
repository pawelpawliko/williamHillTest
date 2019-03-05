package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FootballCouponsFragmentPage {
    private WebDriver driver;

    public FootballCouponsFragmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "highlights-coupons")
    private WebElement footballCoupons;

    @FindBy(linkText = "UK Match Betting")
    private WebElement uKMatchBetting;

    public void chooseUKMatchBetting() {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", footballCoupons);
        StaleElement.clickStaleElement(uKMatchBetting);
    }
}