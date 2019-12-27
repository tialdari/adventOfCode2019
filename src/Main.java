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
        System.out.print("Result: " + day3Puzzle.computeSecondPartResult());
//        System.out.println("First part result, test1 (159): " + day3Puzzle.computeResult());
//        System.out.println("Second part result, test1 (610): " + day3Puzzle.computeSecondPartResult());

//        day3Puzzle.initialize("day_3_test_input2.txt");
//        System.out.println("First part result, test2 (135): " + day3Puzzle.computeResult());
//        System.out.println("Second part result, test2 (410): " + day3Puzzle.computeSecondPartResult());
    }
}
