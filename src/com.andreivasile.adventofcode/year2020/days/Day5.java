package com.andreivasile.adventofcode.year2020.days;

import com.andreivasile.adventofcode.common.AdventInputFile;
import com.andreivasile.adventofcode.common.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Day5 extends Day {

    String[] seatNumbers;

    /**
     * Instantiates a new Day.
     */
    public Day5() {
        super(5, 2020, "Binary Boarding");
        seatNumbers = AdventInputFile.getInputAsStringList(day);
    }

    public String partOne() {
        ArrayList<Integer> b = new ArrayList<>();

        Arrays.stream(seatNumbers).forEach(i -> b.add(getValue(i)));

        return String.valueOf(Collections.max(b));
    }

    public String partTwo() {
        ArrayList<Integer> b = new ArrayList<>();
        Arrays.stream(seatNumbers).forEach(i -> b.add(getValue(i)));

        Collections.sort(b);

        AtomicInteger seat = new AtomicInteger();

        Optional<Integer> item = b.stream().filter(i -> !b.contains(i + 1) && b.contains(i + 2)).findFirst();
        return item.map(integer -> String.valueOf(integer + 1)).orElse("");
    }

    private int getValue(String seat) {
        seat = seat.replace('R', '1').replace('B', '1');
        seat = seat.replace('L', '0').replace('F', '0');
        return Integer.parseInt(seat, 2);
    }
}
