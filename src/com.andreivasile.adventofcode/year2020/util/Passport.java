package com.andreivasile.adventofcode.year2020.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Passport.
 */
public class Passport {
    /**
     * The Height.
     */
    long height;
    /**
     * The Hair colour.
     */
    String hairColour, /**
     * The Eye colour.
     */
    eyeColour;
    /**
     * The Passport id.
     */
    int passportID, /**
     * The Country id.
     */
    countryID, /**
     * The Birth year.
     */
    birthYear, /**
     * The Issue year.
     */
    issueYear, /**
     * The Expiration year.
     */
    expirationYear;

    private static HashMap<String, String> extractData(String data) {
        HashMap<String, String> items = new HashMap<>();

        for (String i : data.split("\n")) {
            for (String j : i.split(" ")) {
                String[] x = j.split(":");
                items.put(x[0], x[1]);
            }
        }
        return items;
    }

    /**
     * Part one validate boolean.
     *
     * @param data the data
     * @return the boolean
     */
    public static boolean partOneValidate(String data) {
        HashMap<String, String> items = extractData(data);
        items.remove("cid");
        return items.size() >= 7;
    }

    /**
     * Part two validate boolean.
     * <p>
     * This was a huge pain because of regex and I didn't account for how much checking has to be done to verify the pattern
     *
     * @param item the item
     * @return true if the passport data is valid
     */
    public static boolean partTwoValidate(String item) {
        HashMap<String, String> items = extractData(item);
        String[] order = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        StringBuilder organizedItems = new StringBuilder();
        Arrays.stream(order).forEach(i -> organizedItems.append(i).append(":").append(items.get(i)).append(","));
        String organizedString = organizedItems.toString();

        Pattern regex = Pattern.compile("byr:(19[2-9][0-9]|200[0-2]),iyr:(201[0-9]|2020),eyr:(202[0-9]|2030),hgt:((1[5-8][0-9]|19[0-3])cm|(59|6[0-9]|7[0-6])in),hcl:(#(?:[0-9a-f]){6}),ecl:(amb|blu|brn|gry|grn|hzl|oth),pid:(\\d{9,9}),");
        Matcher matcher = regex.matcher(organizedString);

        return matcher.find();
    }
}
