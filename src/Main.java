import common.Puzzle;
import day_1.Day1Puzzle;

public class Main {

    public static void main(String[] args) {

        Puzzle day1puzzle = new Day1Puzzle();
        day1puzzle.initialize();
        //System.out.println("Result:" + day1puzzle.computeResult());

        System.out.println("Result:" + ((Day1Puzzle) day1puzzle).computeOneLineResult(12));

    }
}
