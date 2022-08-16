package com.demoqa.tests;

import com.demoqa.utils.RandomUtils;
import com.github.javafaker.Faker;

import static java.lang.String.format;

public class TestData {
    public static Faker faker = new Faker();
    public static RandomUtils randomUtils = new RandomUtils();
    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = randomUtils.generateRandomGenders(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            day = faker.number().numberBetween(1, 30) + "",
            month = randomUtils.generateRandomMonth(),
            year = faker.number().numberBetween(1960, 2002) + "",
            userSubjects = randomUtils.generateRandomSubjects(),
            userHobbies = randomUtils.generateRandomHobbies(),
            userPicture = "nature.jpeg",
            currentAdress = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi",
            expectedFullName = format("%s %s", firstName, lastName),
            expectedDateOfBirth = format("%s %s,%s", day, month, year),
            expectedLocation = format("%s %s", state, city);


}
