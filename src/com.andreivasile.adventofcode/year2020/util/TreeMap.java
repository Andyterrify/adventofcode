package com.andreivasile.adventofcode.year2020.util;

import com.andreivasile.adventofcode.common.AdventInputFile;

/**
 * The type Tree map.
 */
public class TreeMap {
    /**
     * The Pointer.
     */
    int pointer = 0;
    /**
     * The Rows.
     */
    int rows, /**
     * The Columns.
     */
    columns;

    /**
     * The Data.
     */
//    ArrayList<ArrayList<Character>> map = new ArrayList<>();
//    ArrayList<Character> path = new ArrayList<>();
    String[] data;

    /**
     * Instantiates a new Tree map.
     *
     * @param day the day
     */
    public TreeMap(int day) {
        data = AdventInputFile.getInputAsStringList(day);
        this.rows = data.length;
        this.columns = data[0].length();
    }

    /*
    public TreeMap parseData(InputStream data) throws IOException {
        ArrayList<Character> line = new ArrayList<>();

        ByteBuffer buffer = ByteBuffer.allocate(4 * 1024);
        FileChannel in = ((FileInputStream) data).getChannel();
        int bytesRead = in.read(buffer);

        while (bytesRead != -1) {
            buffer.flip();

            char readCharacter = (char) buffer.get();

            do {
                line.add(readCharacter);
                readCharacter = (char) buffer.get();
            } while (readCharacter != '\n');

            buffer.compact();
            bytesRead = in.read(buffer);
            map.add(line);
            line = new ArrayList<>();
        }
        rows = this.map.size();
        columns = this.map.get(0).size();
        return this;
    }
    */

    /**
     * Transverse map int.
     *
     * @param right the right
     * @param down  the down
     * @return the int
     */
    public int transverseMap(int right, int down) {
        int[] coordinates = {0, 0};
        String currentLine;
        int trees = 0;

        while (coordinates[0] < rows) {
            currentLine = data[coordinates[0]];
            char currentCharacter = currentLine.charAt(coordinates[1]);
            if (currentCharacter == '#') trees++;
            coordinates[0] += down;
            coordinates[1] = (coordinates[1] + right) < 31 ? coordinates[1] += right : (coordinates[1] + right) % 30 - 1;
        }
        return trees;
    }

    /*
    public void printLine(ArrayList<Character> line, int repeat) {
        StringBuilder builder = new StringBuilder(line.size());
        line.forEach(i -> builder.append(i));
        System.out.println(builder.toString().repeat(repeat));
    }

    public void printMap(int right, int down) {
        char direction = 'r';
        int count = 0;
    }*/
}
