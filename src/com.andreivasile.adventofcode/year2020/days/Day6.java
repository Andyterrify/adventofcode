package com.andreivasile.adventofcode.year2020.days;

import com.andreivasile.adventofcode.common.AdventInputFile;
import com.andreivasile.adventofcode.common.Day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day6 extends Day {

    private final String[] groups;

    public Day6() {
        super(6, 2020, "Customs Customs");
        this.groups = AdventInputFile.getInputSeparatedByBlankLine(day);
    }

    public String partOne() {
        int totalChoices = 0;

        for (String group : groups) {
            group = group.replace("\n", "");
            Set<String> choices = Arrays.stream(group.split("")).collect(Collectors.toSet());
            totalChoices += choices.size();
        }
        return String.valueOf(totalChoices);

    }

    public String partTwo() {
        AtomicInteger totalChoices = new AtomicInteger();

        Arrays.stream(groups).parallel().forEach(group -> {

            HashMap<Integer, Set<String>> personCharacters = new HashMap<>();
            HashMap<Character, Integer> characterCount = new HashMap<>();
            int count = 0;
            String[] people = group.split("\n");

            // Creates a dictionary of the person num and their characters
            for (String person : people) {
                personCharacters.put(count, Arrays.stream(person.split("")).collect((Collectors.toSet())));
                count++;
            }

            // Creates a dictionary of the number of times character occurs
            for (Integer person : personCharacters.keySet()) {
                for (String character : personCharacters.get(person)) {
                    if (characterCount.containsKey(character.charAt(0))) {
                        characterCount.put(character.charAt(0), characterCount.get(character.charAt(0)) + 1);
                    } else {
                        characterCount.put(character.charAt(0), 1);
                    }
                }
            }

            // Finds and counts characters shared between all members
            int finalCount = count;
            int matches = (int) characterCount.values().stream().filter(i -> i == finalCount).count();
            totalChoices.addAndGet(matches);
        });
        return String.valueOf(totalChoices.get());
    }
}