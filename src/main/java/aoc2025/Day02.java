package aoc2025;

import java.io.IOException;
import java.util.Arrays;

public class Day02 extends Day {

    public Day02() {
        super(2);
    }

    // Parse comma-separated ranges of product IDs. Find all IDs within ranges
    // that consist of a digit sequence repeated exactly twice (e.g., 11, 6464, 123123).
    // Sum all such invalid IDs.
    public String part1() throws IOException {
        String inputString = super.readInput();
        String[] rows = inputString.split(",");
        long invalidIdSum = 0;

        for (String row: rows) {
            String[] edges = row.split("-");
            long startingEdge = Long.parseLong(edges[0].trim());
            long endingEdge = Long.parseLong(edges[1].trim());

            for (long i = startingEdge; i <= endingEdge; i++) {
                if(!isValid(i)) {
                    invalidIdSum += i;
                }
            }
        }

        return Long.toString(invalidIdSum);
    }


    public boolean isValid(long number) {
        final String numberString = Long.toString(number);

        // early return if number length is not even
        if(numberString.length() % 2 != 0) {
            return true;
        }

        String firstHalf = numberString.substring(0, numberString.length()/2);
        String secondHalf = numberString.substring(numberString.length()/2);

        return !firstHalf.equals(secondHalf);
    }

    // Same as part 1, but invalid IDs are now digit sequences repeated
    // two or more times (e.g., 11, 123123, 1234123412341234). Sum all invalid IDs.
    public String part2() throws IOException {
        String inputString = super.readInput();
        String[] rows = inputString.split(",");
        long invalidIdSum = 0;

        for (String row: rows) {
            String[] edges = row.split("-");
            long startingEdge = Long.parseLong(edges[0].trim());
            long endingEdge = Long.parseLong(edges[1].trim());

            for (long i = startingEdge; i <= endingEdge; i++) {
                if(!isValid2(i)) {
                    invalidIdSum += i;
                }
            }
        }

        return Long.toString(invalidIdSum);
    }

    public boolean isValid2(long number) {
        final String numberString = Long.toString(number);
        final int numberStringLength = numberString.length();

        for(int i = 1; i <= numberStringLength/2; i++) {
            String tempSubstring = numberString.substring(0, i);

            if(numberStringLength % tempSubstring.length() != 0) {
                continue;
            }

            final String regex = "(?<=\\G.{" + tempSubstring.length() + "})";
            String[] substrings = numberString.split(regex);

            boolean allSame = Arrays.stream(substrings).allMatch(tempSubstring::equals);
            if(allSame) return false;
        }

        return true;
    }
}
