package ru.praktikum.scooter;

import com.codeborne.selenide.Configuration;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class TestOrderNegative {

    @Test
    public void negativeScooter() {

        Configuration.browser = "firefox";

        //В этом тесте используются тестовые данные, которыми нельзя заполнять поля формы.
        //Мне об этом известно из курса ручного тестирования.

        final boolean negativeTestScooter = open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .cookieDrop()
                .findNewOrderButton()
                .sendName("Виктор")
                .sendLastName("Фывапролджйцукенгшщзх")
                .sendAddressPlace("")
                .sendMetroStation("Я")
                .arrowMetroStation()
                .downMetroStation()
                .sendPhoneNumber("9851568785223")
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

        assertTrue("Отсутствует сообщение о создании заказа", negativeTestScooter);

    }
}