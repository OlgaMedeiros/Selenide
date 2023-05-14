package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Configuration;
//import org.jsoup.select.Evaluator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    int days = 3;
    DeliveryDays deliveryDays = new DeliveryDays();

    @BeforeEach
    void setUp() {

        open("http://localhost:7777/");

    }

    @Test
    void shouldRegistrationCardDeliveryTest() {

        $("[data-test-id='city'] input").setValue("Казань");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(deliveryDays.generateDate(days));
        $("[data-test-id='name'] input").setValue("Маркелова Ольга");
        $("[data-test-id='phone'] input").setValue("+79172147958");
        $("[data-test-id='agreement']").click();
        $$("button").find(exactText("Забронировать")).click();

        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована"), Duration.ofSeconds(15));

    }


    }

