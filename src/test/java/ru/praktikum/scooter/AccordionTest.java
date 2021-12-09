package ru.praktikum.scooter;

import com.codeborne.selenide.Configuration;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class AccordionTest {

    @Test
    public void dropDownTest() {

        Configuration.browser = "firefox";

        final boolean dropDownTextIsTrue = open("https://qa-scooter.praktikum-services.ru/", MainPage.class)
                .scrollDropDown()
                .trueFirstDropDown();

        assertTrue("Текст не совпадает с ожидаемым", dropDownTextIsTrue);



    }
}
