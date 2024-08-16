package Pages;

import Utilities.Utility;
import org.openqa.selenium.*;


public class P03_DetailsPage extends P02_PickHotelPage {
    private final WebDriver driver;

   private final By reservePage=By.xpath("//*[@id=\"b2hotelPage\"]");
    private final By selectBed = By.cssSelector("#hprt-table > tbody > tr.js-rt-block-row.e2e-hprt-table-row.hprt-table-cheapest-block.hprt-table-cheapest-block-fix.js-hprt-table-cheapest-block > td.hprt-table-cell.-first.hprt-table-cell-roomtype.droom_seperator > div > div.hprt-roomtype-bed > div.bed-types-wrapper.bed-types-v2 > label:nth-child(3) > div > input[type=radio]");
    private final By selectRoom =By.id("hprt_nos_select_78883120_373531459_0_33_0_131741");
    private final By reserveBtn =By.cssSelector("#hprt-form > div.hprt-container > div.hprt-table-cell.-last.hprt-reservation-summary-col.js-hprt-reservation-summary.hprt-block--room-selected > div.hprt-block.reserve-block-js > div.hprt-reservation-cta > button");
    private final By hotelNameReserve=By.xpath("//*[@id=\"bodyconstraint-inner\"]/div[3]/div[3]/aside/div/div[1]/div/div/div/div/div/div/div[1]/div[1]/h1");
    private final By checkinReservation= By.xpath("//*[@id=\"bodyconstraint-inner\"]/div[3]/div[3]/aside/div/section[1]/div/div/div[1]/div[1]/div/div[1]/time/span[1]");
    private final By checkoutReservation= By.xpath("//*[@id=\"bodyconstraint-inner\"]/div[3]/div[3]/aside/div/section[1]/div/div/div[1]/div[1]/div/div[2]/time/span[1]");

   public P03_DetailsPage(WebDriver driver) throws InterruptedException {
        super(driver);
       this.driver = driver;
    }
    public P03_DetailsPage scrollPage1() {
        Utility.scrolling(driver,reservePage);
        return this;
    }
    public P03_DetailsPage selectABed() {
        Utility.clickingOnElement(driver, selectBed);
        return this;
    }
    public P03_DetailsPage selectARoom() {
       Utility.selectingFromDropdown(driver,selectRoom,1);
        return this;
    }
    public P03_DetailsPage clickOnReserve() throws InterruptedException {

        Utility.clickingOnElement(driver,reserveBtn);
        return new P03_DetailsPage(driver);
    }

    //Start Assertion for hotel name
   /* public String getHotelNameReservePge()
    {
      return Utility.getText(driver,hotelNameReserve);
    }

   public boolean comparingHotel() {

        return getHotelNameReservePge().equals(getHotelName());
    }*/

    //Start Assertion for checkin/checkoutdate
   /* public String getCheckinDateonReservePage() {
        try {
            return Utility.getText(driver, checkinReservation);

        } catch (Exception e) {
            LogsUtils.error(e.getMessage());
        }
        return "0";
    }*/

    /*public String getCheckoutDateonReservePage() {
        try {
            return Utility.getText(driver, checkoutReservation);

        } catch (Exception e) {
            LogsUtils.error(e.getMessage());
        }
        return "0";
    }*/

    /*public boolean comparingCheckinDatewithReservationDate() {
    return getCheckinDateonReservePage().equals(getCheckinDate());
    }
    public boolean comparingCheckoutDatewithReservationDate(){
        return getCheckoutDateonReservePage().equals(getCheckoutDate());
    }*/


}
