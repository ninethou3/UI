package ru.praktikum.scooter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import java.util.Calendar;
import java.util.TimeZone;

import static com.codeborne.selenide.Condition.visible;


public class MainPage {
    //Константа для ЮРЛ адреса
    public final static String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    @FindBy(id = "rcc-confirm-button")
    public SelenideElement cookie;
    //Кнопка заказа на главной странице
    @FindBy(className = "Button_Button__ra12g")
    public SelenideElement newOrderButton;
    //Кнопка заказа в середине страницы
    @FindBy(className = "Home_FinishButton__1_cWm")
    public SelenideElement newOrderButton2;
    //Поле ввода имени
    @FindBy(xpath = ".//input [@placeholder = '* Имя']")
    public SelenideElement namePlace;
    //Поле ввода фамилии
    @FindBy(xpath = ".//input [@placeholder = '* Фамилия']")
    public SelenideElement lastNamePlace;
    //Поле ввода адреса
    @FindBy(xpath = ".//input [@placeholder = '* Адрес: куда привезти заказ']")
    public SelenideElement addressNamePlace;
    //Поле ввода станции метро
    @FindBy(xpath = ".//input [@placeholder = '* Станция метро']")
    public SelenideElement metroStationName;
    //Поле ввода телефона
    @FindBy(xpath = ".//input [@placeholder = '* Телефон: на него позвонит курьер']")
    public SelenideElement phoneNumberPlace;
    //Кнопка Далее
    @FindBy(xpath = ".//button[contains(text(), 'Далее')]")
    public SelenideElement nextButton;
    //Поле Дата доставки
    @FindBy(xpath = ".//input [@placeholder = '* Когда привезти самокат']")
    public SelenideElement deliveryDate;
    //Стрелка Выпадающего меню
    @FindBy(className = "Dropdown-arrow")
    public SelenideElement dropDownClick;
    //Выбор периода аренды
    @FindBy(className = "Dropdown-option")
    private SelenideElement rentalPeriodChoice;
    //Чек-бокс на черный скутер
    @FindBy(xpath = "//*[@id=\"black\"]")
    public SelenideElement blackScooter;
    //Чек-бокс на серый скутер
    @FindBy(xpath = "//*[@id=\"grey\"]")
    public SelenideElement grayScooter;
    //Поле комментарий
    @FindBy(xpath = ".//input [@placeholder = 'Комментарий для курьера']")
    public SelenideElement commentSection;
    //Кнопка заказа
    @FindBy(xpath = ".//div[contains(@class, 'Order_Buttons__1xGrp')]//*[contains(text(), 'Заказать')]")
    public SelenideElement orderButton;
    //Кнопка ДА наокне подтверждения заказа
    @FindBy(xpath = ".//button[contains(text(), 'Да')]")
    public SelenideElement yesButton;
    //Локатор выпадающего меню ЧаВо
    @FindBy(id = "accordion__heading-0")
    public SelenideElement questionDropDown;
    //Локатор на первый выпадающий вопрос
    @FindBy(id = "accordion__panel-0")
    public SelenideElement firstDropDown;
    //Локатор подтверждения заказа
    @FindBy(className = "Order_Text__2broi")
    public SelenideElement orderNumber;
    //Локатор подтверждения текста заказа
    @FindBy(xpath = ".//div[contains(@class, 'Order_Content')]//*[contains(text(), 'Заказ оформлен')]")
    public SelenideElement getNewOrderText;




    public boolean checkNewOrderVisible(){
        return getNewOrderText.is(visible);

    }

    public MainPage clickYesButton(){
        yesButton.click();
        Selenide.sleep(8000);
        return this;
    }


    public MainPage cookieDrop(){
        cookie.click();
        return this;
    }

    public MainPage orderNumberText(){
        orderNumber.shouldBe(visible);
        return this;
    }

    //Метод клика на кнопку нового заказа
    public MainPage clickNewOrderButton(){
        newOrderButton.click();
                return this;
    }
    //Метод поиска кнопки новго заказа
    public MainPage findNewOrderButton(){
        newOrderButton2.scrollIntoView(true).click();
                return this;
    }
    //Метод ввода имени заказчика
    public MainPage sendName(String name){
        namePlace.sendKeys(name);
                return this;
    }
    //Метод ввода фамилии заказчика
    public MainPage sendLastName(String LastName){
        lastNamePlace.sendKeys(LastName);
                return this;
    }
    //Метод Метод ввода адреса доставки
    public MainPage sendAddressPlace(String AddressPlace){
        addressNamePlace.sendKeys(AddressPlace);
                return this;
    }
    //Метод ввода станции метро
    public MainPage sendMetroStation(String metroStation){
        metroStationName.setValue(metroStation);
                return this;
    }

    //Метод нажатия на стрелочку выпадающего меню станции метро
    public MainPage arrowMetroStation(){
        metroStationName.sendKeys(Keys.ARROW_DOWN);
                return this;
    }
    //Метод подтверждения выбора станции нажатием Ентер
    public MainPage downMetroStation(){
        metroStationName.sendKeys(Keys.ENTER);
                return this;
    }
    //Метод ввода номера телефона
    public MainPage sendPhoneNumber(String PhoneNumber){
        phoneNumberPlace.sendKeys(PhoneNumber);
                return this;
    }
    //Метод клика на кнопку продолжить
    public MainPage clickNextButton(){
        nextButton.scrollTo().click();
                return this;
    }
    //ВТОРАЯ СТРАНИЦА ЗАКАЗА
    //Метод ввода даты доставки
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault()); int day = calendar. get(Calendar. DATE);


    public MainPage sendDate(String date){
        deliveryDate.sendKeys(date);
                return this;
    }
    //Метод клика на выпадающее меню
    public MainPage dropDownRent(){
        dropDownClick.click();
                return this;
    }
    //Метод наведения мышки и клика по ней
    public MainPage dropDownMenu(String option){
        rentalPeriodChoice.hover().click();
                return this;
    }
    //Метод выбора чек-бокса
    public MainPage checkBlackScooter(){
        blackScooter.click();
                return this;
    }
    //Метод выбора чек-бокса 2
    public MainPage checkGrayScooter(){
        grayScooter.click();
                return this;
    }
    //Метод ввода комментария
    public MainPage sendCommentSection(String Comment){
        commentSection.sendKeys(Comment);
                        return this;
    }
    //Метод клика по кнопке заказа
    public MainPage clickOrderButton(){
        orderButton.click();
        Selenide.sleep(8000);
        return this;

    }

    //метод скролла на экран с вопросами
    public MainPage scrollDropDown(){
        questionDropDown.scrollTo().click();
        return this;
    }

//    метод возвращающий правильное значение выпадающего меню
    public boolean trueFirstDropDown(){
        return firstDropDown.is(Condition.exactText("Сутки — 400 рублей. Оплата курьеру — наличными или картой."));
    }
//    метод скролла до кнопки заказа в середине страницы
    public MainPage newOrderButton2() {
        newOrderButton2.scrollTo().click();
                return this;
    }



}