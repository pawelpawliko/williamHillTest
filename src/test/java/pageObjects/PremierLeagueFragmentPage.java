package pageObjects;

import org.junit.experimental.theories.Theories;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PremierLeagueFragmentPage {
    private WebDriver driver;

    public PremierLeagueFragmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"coupon-detail\"]/section[1]/div[1]/div/h2")
    private WebElement premierLeagueSection;

    @FindBy(id = "OB_OU2290357528")
    private WebElement premierLeagueBet;

    @FindBy(className = "betbutton__odds")
    private List<WebElement> betbuttonOdds;

    public void chooseSomePremierLeagueBet() {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", premierLeagueSection);
        betbuttonOdds.get(0).click();
    }

    public String getValueOfFirstButtonOdd() {
        return  betbuttonOdds.get(0).getText();

    }
}