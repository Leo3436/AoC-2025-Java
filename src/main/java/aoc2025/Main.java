package aoc2025;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        int inputNumber = 0;

        while(inputNumber < 1 || inputNumber > 12) {
            System.out.println("Input a number 1-12");

            Scanner s = new Scanner(System.in);
            inputNumber = s.nextInt();
        }

        int dayNumber = inputNumber-1;

        Day[] days = {
                new Day01(),
                new Day02(),
                new Day03(),
                new Day04(),
                new Day05(),
                new Day06(),
                new Day07(),
                new Day08(),
                new Day09(),
                new Day10(),
                new Day11(),
                new Day12()
        };

        Day day = days[dayNumber];

        String partOneResult = day.part1();
        String partTwoResult = day.part2();

        System.out.println("Part 1 result: " + partOneResult);
        System.out.println("Part 2 result: " + partTwoResult);
    }
}
