package aoc2025;

import java.io.IOException;
import java.util.Objects;

public abstract class Day {
    protected int dayNumber;

    public Day(int dayNumber) {
        this.dayNumber = dayNumber;
    }


    protected String readInput() throws IOException {
        String fileName ="/" + dayNumber + ".txt";
        try {
            byte[] inputStream = Objects.requireNonNull(getClass().getResourceAsStream(fileName)).readAllBytes();
            return new String(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read input file: " + fileName, e);
        }
    }

    abstract String part1() throws IOException;
    abstract String part2() throws IOException;
}
