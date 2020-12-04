package com.andreivasile.adventofcode.year2020.days;

import com.andreivasile.adventofcode.common.AdventInputFile;
import com.andreivasile.adventofcode.common.Day;
import com.andreivasile.adventofcode.year2020.util.Passport;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

/**
 * The type Day 4.
 */
public class Day4 extends Day {

    /**
     * Instantiates a new Day.
     */
    public Day4() {
        super(4, 2020);
    }

    public String partOne() {
        int valid = 0;
        String[] data = getData();
        for (String item : data) {
            if (Passport.partOneValidate(item)) valid++;
        }
        return String.valueOf(valid);
    }

    public String partTwo() {
        int valid = 0;
        String[] data = getData();
        for (String item : data) {
            if (Passport.partTwoValidate(item)) valid++;
        }
        return String.valueOf(valid);
    }

    /**
     * Get data string [ ].
     *
     * @return the string [ ]
     */
    public String[] getData() {
        try {
            FileInputStream inputStream = (FileInputStream) AdventInputFile.getInputStream(day);
            byte[] data = new byte[(int) inputStream.available()];
            inputStream.read(data);
            inputStream.close();

            String str = new String(data, StandardCharsets.UTF_8);
            return str.split("\n\n");
        } catch (Exception ignore) {
            return null;
        }
    }
}
