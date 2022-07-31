package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alexander");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("alexivanov22@mail.ru");
        $(".custom-radio:nth-child(1)").click();
        $("#userNumber").setValue("89998887766");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1970");
        $(".react-datepicker__day--026").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/nature.jpeg"));
        $("#currentAddress").setValue("Ufa");
        $("#state .css-1wa3eu0-placeholder").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Alexander Ivanov"));
        $(".modal-body").shouldHave(text("alexivanov22@mail.ru"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("8999888776"));
        $(".modal-body").shouldHave(text("26 October,1970"));
        $(".modal-body").shouldHave(text("English"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("nature.jpeg"));
        $(".modal-body").shouldHave(text("Ufa"));
        $(".modal-body").shouldHave(text("NCR Delhi"));

    }
}
