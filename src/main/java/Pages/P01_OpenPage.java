package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P01_OpenPage {

    private final WebDriver driver;
    private final By popUp =By.cssSelector("#b2indexPage > div.a1b9d2f057.c20dffcd7d > div > div > div > div.f39d206191 > div.d5b096843d.a3b6061a26.f3ec6922b3 > div > button");
    private final By location = By.id(":rh:");

    private final By openCalender = By.cssSelector("#indexsearch > div.hero-banner-searchbox > div > form > div.ccfb696c7a.d75b9c2e7e.ad17a4e50b.e3ab61125f > div:nth-child(2) > div > div.c92e2bd0cb > button:nth-child(2) > span");
    private final  By calenderArrow = By.cssSelector("#calendar-searchboxdatepicker > div > div.eba8b9f2df.c7d271ae1f > button > span > span > svg");

    private final By checkListDate = By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/div/div[2]/table/tbody/tr/td");

    private final By searchBtn =By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div[1]/div[4]/button");

    public P01_OpenPage(WebDriver driver) {
        this.driver = driver;
    }


    public P01_OpenPage closePopUp(){
        Utility.clickingOnElement(driver,popUp);
        return this;
    }

    public P01_OpenPage enterLocation(String locationText) {
        Utility.sendData(driver, location, locationText);
        return this;
    }
    public P01_OpenPage openCalender() {
        Utility.clickingOnElement(driver,openCalender);
        return this;
    }

    public P01_OpenPage clickArrow() {
        Utility.clickingOnElement(driver,calenderArrow);
        return this;
    }

    public P01_OpenPage findCeckinDate() {
        Utility.findElements(driver,checkListDate).get(1).click();
        return this;
    }
    public String getCheckinDate(){
        String checkin = Utility.getText(driver,checkListDate);
        return checkin;
    }
    public P01_OpenPage findCeckoutDate() {
        Utility.findElements(driver,checkListDate).get(14).click();
        return this;
    }
    public String getCheckoutDate(){
        String checkout = Utility.getText(driver,checkListDate);
        return checkout;
    }
    public P02_PickHotelPage clickOnSearchBtn() throws InterruptedException {
        Utility.clickingOnElement(driver, searchBtn);
        return new P02_PickHotelPage(driver);
    }

    public boolean assertOpenPageTC(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }

}
