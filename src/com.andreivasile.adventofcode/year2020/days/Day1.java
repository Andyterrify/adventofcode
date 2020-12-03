package com.andreivasile.adventofcode.year2020.days;

import com.andreivasile.adventofcode.common.AdventInputFile;
import com.andreivasile.adventofcode.common.Day;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * The type Day 1.
 */
public class Day1 extends Day {

    /**
     * Instantiates a new Day 1.
     */
    public Day1() {
        super(1, 2020);
    }

    public String partOne() {
        Integer[] numbers = AdventInputFile.getInputAsIntList(day);
        List<Integer> nums = Arrays.stream(numbers).collect(Collectors.toList());

        AtomicInteger output = new AtomicInteger();

        nums.forEach(
                i -> nums.stream().parallel().filter(j -> i + j == 2020).findAny().ifPresent(j -> output.set(i * j)));
        return String.valueOf(output.get());
    }

    public String partTwo() {
        Integer[] numbers = AdventInputFile.getInputAsIntList(day);
        List<Integer> nums = Arrays.stream(numbers).collect(Collectors.toList());

        AtomicInteger output = new AtomicInteger();

        nums.forEach(
                i -> nums.forEach(j -> nums.stream().parallel().filter(k -> i + j + k == 2020).findAny().ifPresent(k -> output.set(i * j * k))));
        return String.valueOf(output.get());
    }
}
