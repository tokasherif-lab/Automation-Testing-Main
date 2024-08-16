package Tests;

import Pages.P01_OpenPage;
import Pages.P02_PickHotelPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import static DirverFactory.driverFactory.*;
import static Utilities.DataUtils.getPropertyValue;

public class TC02_PickHotelPage {

    private String LOCATION = DataUtils.getJsonData("locationData", "location");

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        LogsUtils.info("Browser is opened");
        getDriver().get(getPropertyValue("environment", "BASE_URL"));
        LogsUtils.info("Page is redirected to URL");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        getDriver().getWindowHandles();


    }

    //@Listeners({IInvokedMethodListener.class, ITestResultListener.class})

    @Test(priority = 2)
    public void pickAHotel() throws IOException, InterruptedException {
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

       // getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //Assert.assertTrue(new P02_PickHotelPage(getDriver()).assertPickHotelTC(getPropertyValue("environment", "DETAILSPAGE_URL")));

    }

    @AfterMethod
    public void quit() {quitDriver();}

}
