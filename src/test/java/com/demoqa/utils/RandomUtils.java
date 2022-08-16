package com.demoqa.utils;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

import static org.apache.commons.lang3.ArrayUtils.contains;

public class RandomUtils {
    private final static String[] genders = {"Male", "Female", "Other"};
    private final static String[] subjects = {"English", "Maths", "Arts"};
    private final static String[] hobbies = {"Sports", "Reading", "Music"};


    public String generateRandomMonth() {
        Random random = new Random();
        OptionalInt randomNumberMonth = random.ints(0, 12).findFirst();
        return Month.of(randomNumberMonth.getAsInt()).getDisplayName(TextStyle.FULL, Locale.US);

    }

    public String generateRandomGenders() {
        Random random = new Random();
        int randomGender = random.nextInt(genders.length);
        return genders[randomGender];
    }

    public String generateRandomSubjects() {
        Random random = new Random();
        int randomSubjects = random.nextInt(subjects.length);
        return subjects[randomSubjects];
    }

    public String generateRandomHobbies() {
        Random random = new Random();
        int randomHobbies = random.nextInt(hobbies.length);
        return hobbies[randomHobbies];
    }
}













