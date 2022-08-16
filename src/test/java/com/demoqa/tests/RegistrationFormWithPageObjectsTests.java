package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormWithPageObjectsTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillFormTest() {


        registrationFormPage.openPage()
                .setFirstName("Alexander")
                .setLastName("Ivanov")
                .setEmail("alexivanov22@mail.ru")
                .setGender("Male")
                .setNumber("8999888776")
                .setBirthDate("26", "October", "1970")
                .setSubjects("English")
                .setHobbies("Sports")
                .setPicture("nature.jpeg")
                .setCurrentAddress("Ufa")
                .setStateAndCity("NCR", "Delhi")
                .setSubmit()

                .checkResultsModalIsVisible()
                .checkResult("Student Name", "Alexander Ivanov")
                .checkResult("Student Email", "alexivanov22@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8999888776")
                .checkResult("Date of Birth", "26 October,1970")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "nature.jpeg")
                .checkResult("Address", "Ufa")
                .checkResult("State and City", "NCR Delhi");
    }

    @Test
    void fillFormWithMinimumDataTest() {

        registrationFormPage.openPage()
                .setFirstName("Alexander")
                .setLastName("Ivanov")
                .setGender("Male")
                .setNumber("8999888776")
                .setSubmit()

                .checkResultsModalIsVisible()
                .checkResult("Student Name", "Alexander Ivanov")
                .checkResult("Mobile", "8999888776");

    }
}
