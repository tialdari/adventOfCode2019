import common.Puzzle;
import day_1.Day1Puzzle;
import day_2.Day2Puzzle;
import day_3.Day3Puzzle;

public class Main {

    public static void main(String[] args) {

        Puzzle day1puzzle = new Day1Puzzle();
        day1puzzle.initialize("day_1_input.txt");
        System.out.println("Result:" + day1puzzle.computeResult());

        Puzzle day2Puzzle = new Day2Puzzle();
        day2Puzzle.initialize("day_2_input.txt");
        System.out.println("Result:" + day2Puzzle.computeResult());

        Puzzle day3Puzzle = new Day3Puzzle();
        day3Puzzle.initialize("day_3_input.txt");
        day3Puzzle.computeResult();
    }
}
