package com.andreivasile.adventofcode.common;

/**
 * The type Day.
 */
public class Day implements DayInterface {
    /**
     * The Day.
     */
    public int day, /**
     * The Year.
     */
    year;

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
    public String partOne() {
        return null;
    }

    @Override
    public String partTwo() {
        return null;
    }

    public void printParts() {
        System.out.println("=".repeat(8) + "Day " + day + "=".repeat(8));
        System.out.println("Part 1: " + partOne());
        System.out.println("Part 2: " + partTwo());
        System.out.println();
    }
}
