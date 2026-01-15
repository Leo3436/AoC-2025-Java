package aoc2025;

import java.io.IOException;

public class Day03 extends Day {
    
    public Day03() {
        super(3);
    }

    // Each line is a digit sequence representing batteries. Select exactly 2 digits
    // to form the largest possible 2-digit number. Sum the max values from all lines.
    public String part1() throws IOException {
        long totalJoltage = 0;

        String inputString = super.readInput();
        String[] rows = inputString.split("\n");

        for (String row: rows) {

            // find biggest number, that will be the first digit
            int firstIdx = 0;
            for(int i = 0; i < row.length() - 1; i++) {
                if(Character.getNumericValue(row.charAt(i)) > Character.getNumericValue(row.charAt(firstIdx))) {
                    firstIdx = i;
                }
            }

            int secondIdx = firstIdx + 1;
            // find second-biggest number after the first one
            for(int j = firstIdx + 1; j < row.length(); j++) {
                if(Character.getNumericValue(row.charAt(j)) > Character.getNumericValue(row.charAt(secondIdx))) {
                    secondIdx = j;
                }
            }

            totalJoltage += Long.parseLong("" + row.charAt(firstIdx) + row.charAt(secondIdx));
        }

        return Long.toString(totalJoltage);
    }

    // Select exactly 12 digits from each line to form the largest possible 12-digit number.
    // Sum the max values from all lines.
    public String part2() throws IOException {
        long totalJoltage = 0;
        final int DIGIT_COUNT = 12;

        String inputString = super.readInput();
        String[] rows = inputString.split("\n");

        for(String row: rows) {
            int[] numberIndexArray = new int[DIGIT_COUNT];
            for(int j = 0; j < DIGIT_COUNT; j++) {
                int leftBoundary = (j == 0) ? 0 : numberIndexArray[j - 1] + 1;
                numberIndexArray[j] = leftBoundary;
                // Right boundary ensures enough digits remain for the positions we still need to fill.
                // E.g., when picking digit 0, we need 11 more digits after it, so stop at row.length() - 11.
                int rightBoundary = (DIGIT_COUNT - 1) - j;
                for(int i = leftBoundary; i < row.length() - rightBoundary; i++) {
                    if(Character.getNumericValue(row.charAt(i)) > Character.getNumericValue(row.charAt(numberIndexArray[j]))) {
                        numberIndexArray[j] = i;
                    }
                }
            }

            long rowBiggestNumber = this.reconstructNumber(row, numberIndexArray);
            totalJoltage += rowBiggestNumber;
        }


        return Long.toString(totalJoltage);
    }

    private long reconstructNumber(String row, int[] indexArray) {
        StringBuilder numberStringBuilder = new StringBuilder();

        for (int index: indexArray) {
            numberStringBuilder.append(row.charAt(index));
        }

        return Long.parseLong(numberStringBuilder.toString());
    }
}
