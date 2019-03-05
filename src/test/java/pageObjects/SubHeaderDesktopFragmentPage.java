package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubHeaderDesktopFragmentPage {

    public SubHeaderDesktopFragmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"subheader-desktop\"]/nav/ul[2]/li[3]/a")
    private WebElement oddsFormat;

    @FindBy(xpath = "//*[@id=\"subheader-desktop\"]/nav/ul[2]/li[3]/ul/li[2]/a")
    private WebElement decimalFormat;

    public void changeFormatToDecimal() {
        oddsFormat.click();
        decimalFormat.click();
    }

}
