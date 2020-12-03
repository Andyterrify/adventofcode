package com.andreivasile.adventofcode.year2020.days;

import com.andreivasile.adventofcode.common.AdventInputFile;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day1 {
    public static final int day = 1;
    public static final int year = 2020;

    public static String partOne() {
        Integer[] numbers = AdventInputFile.getInputAsIntList(day);
        List<Integer> nums = Arrays.stream(numbers).collect(Collectors.toList());

        AtomicInteger output = new AtomicInteger();

        nums.forEach(
                i -> nums.stream().parallel().filter(j -> i + j == 2020).findAny().ifPresent(j -> output.set(i * j)));
        return String.valueOf(output.get());
    }

    public static String partTwo() {
        Integer[] numbers = AdventInputFile.getInputAsIntList(day);
        List<Integer> nums = Arrays.stream(numbers).collect(Collectors.toList());

        AtomicInteger output = new AtomicInteger();

        nums.forEach(
                i -> nums.forEach(j -> nums.stream().parallel().filter(k -> i + j + k == 2020).findAny().ifPresent(k -> output.set(i * j * k))));
        return String.valueOf(output.get());
    }

    public static void printParts() {
        System.out.printf("The output for Day %d Part %d is: %s\n", day, 1, partOne());
        System.out.printf("The output for Day %d Part %d is: %s\n", day, 2, partTwo());
    }
}
