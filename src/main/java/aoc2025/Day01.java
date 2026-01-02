package aoc2025;

import java.io.IOException;

public class Day01 extends Day {

    public Day01() {
        super(1);
    }

    // Simulate circular dial (0-99) starting at 50.
    // Process L/R rotations with given distances (wrapping around).
    // Count how many times dial lands on 0 after each rotation.
    public String part1() throws IOException {
        String inputString = super.readInput();
        String[] rows = inputString.split("\n");

        int pointer = 50;
        int counter = 0;

        for(String command: rows) {
            char direction = command.charAt(0);
            int distance = Integer.parseInt(command.substring(1));

            if(direction == 'R') {
                pointer = (pointer + distance) % 100;
                if(pointer == 0) counter++;
            } else {
                pointer = (pointer - distance + 100) % 100;
                if(pointer == 0) counter++;
            }
        }

        return Integer.toString(counter);
    }

    // Same as part 1, but count every time the dial passes through 0 during rotation,
    // not just when it lands on 0 at the end of a rotation.
    public String part2() throws IOException {
        String inputString = super.readInput();
        String[] rows = inputString.split("\n");

        int pointer = 50;
        int counter = 0;

        for(String command: rows) {
            char direction = command.charAt(0);
            int distance = Integer.parseInt(command.substring(1));

            if(direction == 'R') {
                pointer = (pointer + distance) % 100;
                if(pointer == 0) counter++;
            } else {
                pointer = (pointer - distance + 100) % 100;
                if(pointer == 0) counter++;
            }
        }

        return Integer.toString(counter);
    }
}
