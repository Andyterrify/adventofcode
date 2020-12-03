package com.andreivasile.adventofcode.year2020.days;

import com.andreivasile.adventofcode.common.AdventInputFile;
import com.andreivasile.adventofcode.year2020.util.Password;

import java.util.Arrays;

public class Day2 {
    public static final int day = 2;
    public static final int year = 2020;

    public static String partOne() {
        String[] passwords = AdventInputFile.getInputAsStringList(day);

        int validPasswords = (int) Arrays.stream(passwords).parallel().filter(i -> new Password(i).policyOne().isValid()).count();
        return String.valueOf(validPasswords);
    }

    public static String partTwo() {
        String[] passwords = AdventInputFile.getInputAsStringList(day);

        int validPasswords = (int) Arrays.stream(passwords).parallel().filter(i -> new Password(i).policyTwo().isValid()).count();
        return String.valueOf(validPasswords);
    }

    public static void printParts() {
        System.out.printf("The output for Day %d Part %d is: %s\n", day, 1, partOne());
        System.out.printf("The output for Day %d Part %d is: %s\n", day, 2, partTwo());
    }
}
