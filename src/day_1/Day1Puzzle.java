package day_1;

import services.IO;
import common.Puzzle;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Day1Puzzle extends Puzzle {

    public Day1Puzzle() {
        super();
    }

    public Day1Puzzle(IO io, File file) {
        super();
    }

    @Override
    public int computeResult() {

        List<Integer> inputNumbers = new ArrayList<>();
        List<String> inputString = processText();
        inputString.forEach((line) -> {
            inputNumbers.add(Integer.parseInt(line));
        });

        inputNumbers.forEach((number) -> {
            computeOneLineResult(number);
        });

        return inputNumbers.stream().mapToInt(Integer::intValue).sum();
    }

    public int computeOneLineResult(int input){

        System.out.print("input: " + input);

        double result = input;

        result /= 3;
        System.out.print(", divided by 3: " + result);

        result = Math.floor((double)result);
        System.out.print(", florred: " + result);

        result -= 2;
        System.out.print(", substracted by 2: " + result + "\n");

        return (int) result;
    }
}
