package com.andreivasile.adventofcode.year2020.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Password.
 */
public class Password {
    private Pattern p = Pattern.compile("(\\d+)-(\\d+)\\s([a-z]):\\s([a-z]*)");
    private int min, max;
    private char key;
    private String password;
    private boolean valid = false;

    /**
     * Instantiates a new Password.
     * Uses the Regex pattern to capture data that's important to create the class
     *
     * @param line the line
     */
    public Password(String line) {
        Matcher m = p.matcher(line);
        if (m.find()) {
            this.min = Integer.parseInt(m.group(1));
            this.max = Integer.parseInt(m.group(2));
            this.key = m.group(3).charAt(0);
            this.password = m.group(4);
        }
    }

    /**
     * Policy one password rules
     *
     * @return the password
     */
    public Password policyOne() {
        int repeats = (int) this.password.chars().filter(ch -> ch == this.key).count();
        this.valid = this.min <= repeats && repeats <= this.max;
        return this;
    }

    /**
     * Policy two password rules
     *
     * @return the password
     */
    public Password policyTwo() {
        this.valid = this.password.charAt(this.min - 1) == this.key ^ this.password.charAt(this.max - 1) == this.key; // the ^ is a bitwise XOR gate
        return this;
    }

    /**
     * Is this a valid password
     *
     * @return the boolean
     */
    public boolean isValid() {
        return this.valid;
    }
}
