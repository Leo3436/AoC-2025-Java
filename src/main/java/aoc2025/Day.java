package aoc2025;

import java.io.IOException;
import java.util.Objects;

public abstract class Day {
    protected String readInput(int dayNumber) throws IOException {
        String fileName ="/" + dayNumber + ".txt";
        byte[] inputStream = Objects.requireNonNull(getClass().getResourceAsStream(fileName)).readAllBytes();

        return new String(inputStream);
    }

    abstract String part1() throws IOException;
    abstract String part2();
}
