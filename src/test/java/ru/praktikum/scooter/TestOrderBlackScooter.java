package ru.praktikum.scooter;

import com.codeborne.selenide.Configuration;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class TestOrderBlackScooter{

                @Test
                public void blackScooter() {

                    Configuration.browser = "chrome";

                    final boolean isOrderConfirmed = open(MainPage.MAIN_PAGE_URL, MainPage.class)
                                .cookieDrop()
                                .clickNewOrderButton()
                                .sendName("Виктор")
                                .sendLastName("Анатольевич")
                                .sendAddressPlace("Коптевский бульвар, 16")
                                .sendMetroStation("Коптево")
                                .arrowMetroStation().downMetroStation()
                                .sendPhoneNumber("89851568788")
                                .clickNextButton()
                    //вторая страница
                                .sendDate("05.10.2021")
                                .dropDownRent()
                                .dropDownMenu("сутки")
                                .checkBlackScooter()
                                .sendCommentSection("Ride!!!")
                                .clickOrderButton().clickYesButton()
                                .checkNewOrderVisible();


                    assertTrue("Отсутствует сообщение о создании заказа", isOrderConfirmed);

                }



}