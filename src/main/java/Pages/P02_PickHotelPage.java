package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class P02_PickHotelPage {
    private final WebDriver driver;
    String firstTab;
    String secondTab;

    private final By hotelPage =By.xpath("//*[@id=\"b2searchresultsPage\"]");

    private final By pickHotel=By.xpath("//*[contains(text(), \"Tolip Hotel Alexandria\")][@class=\"e037993315 f5f8fe25fa\"]");


    public P02_PickHotelPage(WebDriver driver) throws InterruptedException {

        this.driver = driver;
    }

    public P02_PickHotelPage scrollPage() {
        Utility.scrolling(driver,hotelPage);
        return this;
    }

    public String getHotelName(){
         return Utility.getText(driver,pickHotel);
    }

    public P03_DetailsPage seeAvailability() {
        // Click on the availability link
        Utility.clickingOnElement(driver, pickHotel);

        // Wait for the new tab to open
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> d.getWindowHandles().size() > 1);

        // Switch to the new tab
        Set<String> windowHandles = driver.getWindowHandles();
        String originalHandle = driver.getWindowHandle();

        for (String handle : windowHandles) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        return null;
    }


}
