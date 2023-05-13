package ru.netology;

import jdk.jfr.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    @BeforeEach
    void setUp() {

        open("http://localhost:7777/");

    }

    @Test
    void shouldRegistrationCardDeliveryTest() {
        $("[data-test-id=city] input").setValue("Казань");
        $("[data-test-id=date] input") .setValue("17.05.2013");
        $("[data-test-id=name] input").setValue("Маркелова Ольга");
        $("[type=tel]").setValue("+79172147958");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();

    }

}

