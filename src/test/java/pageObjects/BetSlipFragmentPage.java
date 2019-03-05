package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BetSlipFragmentPage {

    public BetSlipFragmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "betslip-selection__stake-input")
    private WebElement betSlip;

    @FindBy(className = "betslip-bet-actions__list-item--full-width")
    private WebElement placeBetButtom;

    public void writeBetAmount(String betAmount) {
        betSlip.sendKeys(betAmount);
    }

    public void placeBet() {
        placeBetButtom.click();
    }

}