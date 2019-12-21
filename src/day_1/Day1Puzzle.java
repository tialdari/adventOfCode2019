package day_1;

import common.Puzzle;
import java.util.ArrayList;
import java.util.List;

public class Day1Puzzle extends Puzzle {

    public Day1Puzzle() {
        super();
    }

    @Override
    public int computeResult() {

        List<String> inputString = processText();
        List<Integer> inputNumbers = new ArrayList<>();

        inputString.forEach((line) -> inputNumbers.add(Integer.parseInt(line)));

        return inputNumbers.stream().mapToInt(Integer::intValue).map(this::computeOneLineResult).sum();
    }

    public int computeOneLineResult(int input){

        return (input /3) - 2;
    }
}
