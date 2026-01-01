package aoc2025;

import java.io.IOException;

public class Day01 extends Day {

    public String part1() throws IOException {
        String inputString = super.readInput(1);
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

    public String part2() {
        // TODO SOLVE THIS!
        return "1.2";
    }
}
