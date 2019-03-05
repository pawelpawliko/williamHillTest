package pageObjects;

import java.text.DecimalFormat;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenBetsFragmentPage {
    private WebDriver driver;

    public OpenBetsFragmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"openbets-tab\"]/a/span[2]")
    private WebElement openBets;

    @FindBy(className = "stake-returns__value")
    private List<WebElement> stakeReturnsValue;

    @FindBy(className = "placed-bet-selection__price")
    private List<WebElement> oddValue;


    public void checkOpenBet(String betAmount) {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(document.body.scrollHeight,0)");
        StaleElement.clickStaleElement(openBets);

        PremierLeagueFragmentPage premierLeagueBetting = new PremierLeagueFragmentPage(driver);
        double toReturnDoubleValue = Double.parseDouble(premierLeagueBetting.getValueOfFirstButtonOdd()) * Double.parseDouble(betAmount);
        DecimalFormat df = new DecimalFormat("0.00");

        String toReturnStringValue = df.format(toReturnDoubleValue).replace(",", ".");
        StaleElement.clickStaleElement(stakeReturnsValue.get(0));

        Assert.assertTrue(stakeReturnsValue.get(0).getText().contains(toReturnStringValue));
        Assert.assertEquals(premierLeagueBetting.getValueOfFirstButtonOdd(), oddValue.get(0).getText());
    }


}