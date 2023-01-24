package com.epam.jmpServiceApi.util;

import java.time.LocalDate;
import java.time.Period;

public class AgeUtil {
    public static int getAge(LocalDate birthDate) {
        var currentDate = LocalDate.now();
        if (birthDate != null) {
            var age = Period.between(birthDate, currentDate).getYears();
            return age;
        } else {
            return 0;
        }
    }
}
