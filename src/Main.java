import common.Puzzle;
import day_1.Day1Puzzle;
import day_2.Day2Puzzle;

public class Main {

    public static void main(String[] args) {

        Puzzle day1puzzle = new Day1Puzzle();
        day1puzzle.initialize("day_1_input.txt");
        System.out.println("Result:" + day1puzzle.computeResult());

        Puzzle day2Puzzle = new Day2Puzzle();
        day2Puzzle.initialize("day_2_input.txt");
        day2Puzzle.computeResult();
    }
}
