package com.andreivasile.adventofcode.year2020.days;

import com.andreivasile.adventofcode.common.AdventInputFile;
import com.andreivasile.adventofcode.common.Day;
import com.andreivasile.adventofcode.year2020.util.Password;

import java.util.Arrays;

/**
 * The type Day 2.
 */
public class Day2 extends Day {
    /**
     * Instantiates a new Day 2.
     */
    public Day2() {
        super(2, 2020);
    }

    public String partOne() {
        String[] passwords = AdventInputFile.getInputAsStringList(day);

        int validPasswords = (int) Arrays.stream(passwords).parallel().filter(i -> new Password(i).policyOne().isValid()).count();
        return String.valueOf(validPasswords);
    }

    public String partTwo() {
        String[] passwords = AdventInputFile.getInputAsStringList(day);

        int validPasswords = (int) Arrays.stream(passwords).parallel().filter(i -> new Password(i).policyTwo().isValid()).count();
        return String.valueOf(validPasswords);
    }

}
