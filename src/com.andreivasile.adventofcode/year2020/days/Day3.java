package com.andreivasile.adventofcode.year2020.days;

import com.andreivasile.adventofcode.common.Day;
import com.andreivasile.adventofcode.year2020.util.TreeMap;

import java.util.Arrays;

/**
 * The type Day 3.
 */
public class Day3 extends Day {

    /**
     * Instantiates a new Day 3.
     */
    public Day3() {
        super(3, 2020);
    }

    @Override
    public String partOne() {
        TreeMap a = new TreeMap(day);
        return String.valueOf(a.transverseMap(3, 1));
    }

    @Override
    public String partTwo() {
        TreeMap a = new TreeMap(day);
        long multiple = 1;

        int[][] slopes = {{1, 1}, {3, 1}, {5, 1}, {7, 1}, {1, 2}};
        multiple = Arrays.stream(slopes).mapToLong(s -> a.transverseMap(s[0], s[1])).reduce(1, (c, b) -> c * b);
        return String.valueOf(multiple);
    }

}

