package com.andreivasile.adventofcode.common;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Objects;

/**
 * The Advent of Code input file grabber
 */

public abstract class AdventInputFile {

    private static InputStream getInputStreamLocal(int day) throws IOException {
        Path fileName = Path.of(System.getProperty("user.dir") + "/days/day" + day + ".txt");
        return new BufferedInputStream(new FileInputStream(fileName.toString()));
    }

    private static InputStream getInputStreamExternal(int day) throws IOException {
        String session = getSessionID();
        URL url = new URL(String.format("https://adventofcode.com/2020/day/%d/input", day));

        URLConnection connection = url.openConnection();
        connection.addRequestProperty("Cookie", "session=" + session);

        return connection.getInputStream();
    }

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

    public static void saveInputFile(int day) throws IOException {
        InputStream inputStream = getInputStreamExternal(day);

        Path filePath = Path.of(System.getProperty("user.dir") + "/days/day" + day + ".txt");
        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
    }

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

    private static String getSessionID() throws IOException {

        InputStream in = AdventInputFile.class.getClassLoader().getResourceAsStream("config/session");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(in)))) {
            return bufferedReader.readLine();
        }
    }
}
