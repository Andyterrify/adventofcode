package com.andreivasile.adventofcode.common;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * The Advent of Code input file grabber
 */
public abstract class AdventInputFile {

    /**
     * Gets InputStream from local source if it exists
     * If it cannot find the given file then it will throw IOException
     *
     * @param day to catch
     * @return InputStream containing the file
     * @throws IOException If the file is not found at source the error is thrown
     */
    private static InputStream getInputStreamLocal(int day) throws IOException {
        Path fileName = Path.of(System.getProperty("user.dir") + "/days/day" + day + ".txt");
//        return new BufferedInputStream(new FileInputStream(fileName.toString()));
        return new FileInputStream(fileName.toString());
    }

    /**
     * Gets InputStream from external source at https://adventofcode.com/2020/day/<DAY>/input
     * If it cannot find the given file then it will throw IOException
     *
     * @param day to catch
     * @return InputStream containing the file
     * @throws IOException If the file is not found at source the error is thrown
     */
    private static InputStream getInputStreamExternal(int day) throws IOException {
        String session = getSessionID();
        URL url = new URL(String.format("https://adventofcode.com/2020/day/%d/input", day));

        URLConnection connection = url.openConnection();
        connection.addRequestProperty("Cookie", "session=" + session);

        return connection.getInputStream();
    }

    /**
     * Gets input stream.
     *
     * @param day the day
     * @return the input stream
     */
    public static InputStream getInputStream(int day) {
        InputStream inputStream;
        try {
            inputStream = getInputStreamLocal(day);
        } catch (IOException e) {
            try {
                saveInputFile(day);
            } catch (IOException e2) {
                System.out.println(e2.getMessage());
                System.exit(-1);
            }
            inputStream = getInputStream(day);
        }
        return inputStream;
    }

    /**
     * Save input file.
     *
     * @param day the day
     * @throws IOException the io exception
     */
    private static void saveInputFile(int day) throws IOException {
        InputStream inputStream = getInputStreamExternal(day);

        Path filePath = Path.of(System.getProperty("user.dir") + "/days/day" + day + ".txt");
        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * Get input as string list string [ ].
     *
     * @param day the day
     * @return the string [ ]
     */
    public static String[] getInputAsStringList(int day) {
        InputStream inputStream = getInputStream(day);
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return lines.toArray(new String[0]);
    }

    /**
     * Get input as int list integer [ ].
     *
     * @param day the day
     * @return the integer [ ]
     */
    public static Integer[] getInputAsIntList(int day) {
        InputStream inputStream = getInputStream(day);
        ArrayList<Integer> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                lines.add(Integer.parseInt(line));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return lines.toArray(new Integer[0]);
    }

    /**
     * Returns the inputDay separated by a blank like
     *
     * @param day The day
     * @return Blank line separated array of String
     */
    public static String[] getInputSeparatedByBlankLine(int day) {
        FileInputStream inputStream = (FileInputStream) getInputStream(day);
        ArrayList<String> groups = new ArrayList<>();

        Scanner scanner = new Scanner(inputStream);
        scanner.useDelimiter("\n\n");
        while (scanner.hasNext()) {
            groups.add(scanner.next());
        }

        return groups.toArray(new String[0]);
    }

    /**
     * Reads and returns the session ID from the file
     *
     * @return the session ID
     * @throws IOException if the file is not found
     */
    private static String getSessionID() throws IOException {

        InputStream in = AdventInputFile.class.getClassLoader().getResourceAsStream("config/session");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(in)))) {
            return bufferedReader.readLine();
        }
    }
}
