package Tests;

import org.testng.annotations.BeforeMethod;

import Pages.P01_OpenPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;


import static DirverFactory.driverFactory.*;
import static Utilities.DataUtils.getPropertyValue;

public class TC01_OpenPage {

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

    @Test(priority = 1)
    public void validOpenPage() throws IOException, InterruptedException {
        new P01_OpenPage(getDriver())
              .closePopUp()
                .enterLocation(LOCATION)
                .openCalender()
                .clickArrow()
                .findCeckinDate()
                .findCeckoutDate()
                .clickOnSearchBtn();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        Assert.assertTrue(new P01_OpenPage(getDriver()).assertOpenPageTC(getPropertyValue("environment", "SEARCH_URL")));

    }

   @AfterMethod
    public void quit() {quitDriver();}
}

