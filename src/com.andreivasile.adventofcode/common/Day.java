package com.andreivasile.adventofcode.common;

/**
 * The type Day.
 */
public class Day implements DayInterface {
    public int day, year;

    /**
     * Instantiates a new Day.
     *
     * @param day  the day
     * @param year the year
     */
    public Day(int day, int year) {
        this.day = day;
        this.year = year;
    }

    @Override
    public Object partOne() {
        return null;
    }

    @Override
    public Object partTwo() {
        return null;
    }

    public void printParts() {
        System.out.println("=".repeat(8) + "Day " + day + "=".repeat(8));
        System.out.println("Part 1: " + partOne());
        System.out.println("Part 2: " + partTwo());
        System.out.println();
    }
}
