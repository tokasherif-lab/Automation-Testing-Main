package Tests;

import Pages.P01_OpenPage;
import Pages.P02_PickHotelPage;
import Pages.P03_DetailsPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static DirverFactory.driverFactory.*;
import static Utilities.DataUtils.getPropertyValue;

public class TC03_DetailsPage {
    private String LOCATION = DataUtils.getJsonData("locationData", "location");

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        LogsUtils.info("Browser is opened");
        getDriver().get(getPropertyValue("environment", "BASE_URL"));
        LogsUtils.info("Page is redirected to URL");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        getDriver().getWindowHandles();

        Set<String> windowIds = getDriver().getWindowHandles();
        for (String windowId : windowIds){
           getDriver().switchTo().window(windowId);
            if (getDriver().getTitle().equals("Tolip Hotel Alexandria, Alexandria (updated prices 2024)")){
                String url = getDriver().getCurrentUrl();
                System.out.println(url);
            }
        }

    }

    //@Listeners({IInvokedMethodListener.class, ITestResultListener.class})

    @Test(priority = 3)
    public void reserveHotel() throws IOException, InterruptedException {
        //TODO: Open Steps
        new P01_OpenPage(getDriver())
                .closePopUp()
                .enterLocation(LOCATION)
                .openCalender()
                .clickArrow()
                .findCeckinDate()
                .findCeckoutDate()
                .clickOnSearchBtn();

        //TODO: Pick Hotel Steps
        new P02_PickHotelPage(getDriver())
                .scrollPage()
                .seeAvailability();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        //TODO: Select bed & Room Steps
        new P03_DetailsPage(getDriver())
                .scrollPage1()
                .selectABed()
                .selectARoom()
                .clickOnReserve()
                .assertHotelName();


        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

       //Assert.assertTrue(new P02_PickHotelPage(getDriver()).assertPickHotelTC(getPropertyValue("environment", "DETAILSPAGE_URL")));
    }

   // @AfterMethod
    //public void quit() {quitDriver();}
}
