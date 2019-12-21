package day_2;

import common.Puzzle;

import java.util.List;

public class Day2Puzzle extends Puzzle {

    public Day2Puzzle() {
        super();
    }

    @Override
    public int computeResult() {

        List<String> inputStrings = toArray();
        inputStrings.stream().forEach(e-> System.out.println(e));
        return 0;
    }
}
