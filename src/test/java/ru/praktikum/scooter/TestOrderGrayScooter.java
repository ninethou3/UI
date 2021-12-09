package ru.praktikum.scooter;

import com.codeborne.selenide.Configuration;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class TestOrderGrayScooter {

    @Test
    public void greyScooter() {

        Configuration.browser = "chrome";


        final boolean isGreyScooterOrderApproved = open(MainPage.MAIN_PAGE_URL, MainPage.class)

                .cookieDrop()
                .newOrderButton2()
                .sendName("Виктор")
                .sendLastName("Иванович")
                .sendAddressPlace("Проспект Мира, 90")
                .sendMetroStation("Проспект Мира")
                .arrowMetroStation()
                .downMetroStation()
                .sendPhoneNumber("89859985456")
                .clickNextButton()
        //вторая страница
                .sendDate("09.11.2021")
                .dropDownRent()
                .dropDownMenu("трое суток")
                .checkGrayScooter()
                .sendCommentSection("GoGoGo!!!")
                .clickOrderButton()
                .clickYesButton()
                .checkNewOrderVisible();
//
        assertTrue("Отсутствует сообщение о создании заказа", isGreyScooterOrderApproved);

            }

}