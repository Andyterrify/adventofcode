package com.andreivasile.adventofcode.year2020.days;

import com.andreivasile.adventofcode.common.AdventInputFile;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day1 {
    private static final int day = 1;

    public static int partOne() {
        Integer[] numbers = AdventInputFile.getInputAsIntList(day);
        List<Integer> nums = Arrays.stream(numbers).collect(Collectors.toList());

        AtomicInteger output = new AtomicInteger();
        AtomicInteger firstNumber = new AtomicInteger();
        AtomicInteger secondNumber = new AtomicInteger();

        nums.forEach(
                i -> nums.stream().parallel().filter(j -> i + j == 2020).findAny().ifPresent(j -> {
                    output.set(i * j);
                    firstNumber.set(i);
                    secondNumber.set(j);
                }));
        return output.get();
    }

    public static int partTwo() {
        Integer[] numbers = AdventInputFile.getInputAsIntList(day);
        List<Integer> nums = Arrays.stream(numbers).collect(Collectors.toList());

        AtomicInteger output = new AtomicInteger();
        AtomicInteger firstNumber = new AtomicInteger();
        AtomicInteger secondNumber = new AtomicInteger();
        AtomicInteger thirdNumber = new AtomicInteger();

        nums.forEach(
                i -> nums.forEach(j -> nums.stream().parallel().filter(k -> i + j + k == 2020).findAny().ifPresent(k -> {
                    output.set(i * j * k);
                    firstNumber.set(i);
                    thirdNumber.set(k);
                })));
        return output.get();
    }

    public static void printParts() {
        System.out.printf("The output for Day %d Part %d is: %d\n", day, 1, partOne());
        System.out.printf("The output for Day %d Part %d is: %d\n", day, 2, partTwo());
    }
}
