package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;


public class RegistrationFormWithFakerTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @Test
    void fillFormTest() {


        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjects(userSubjects)
                .setHobbies(userHobbies)
                .setPicture(userPicture)
                .setCurrentAddress(currentAdress)
                .setStateAndCity(state, city)
                .setSubmit()

                .checkResultsModalIsVisible()
                .checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", expectedDateOfBirth)
                .checkResult("Subjects", userSubjects)
                .checkResult("Hobbies", userHobbies)
                .checkResult("Picture", userPicture)
                .checkResult("Address", currentAdress)
                .checkResult("State and City", expectedLocation);
    }

    @Test
    void fillFormWithMinimumDataTest() {

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setNumber(userNumber)
                .setSubmit()

                .checkResultsModalIsVisible()
                .checkResult("Student Name", expectedFullName)
                .checkResult("Mobile", userNumber);

    }
}
