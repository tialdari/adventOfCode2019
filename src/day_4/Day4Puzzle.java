package day_4;

import common.Puzzle;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day4Puzzle extends Puzzle {

    private final int DIGITS_NUMBER = 6;
    private final int RANGE_ARR_LENGTH = 2;
    private String stringRange;
    private int[] arrRange;

    public Day4Puzzle(String stringRange) {
        this.stringRange = stringRange;
        arrRange = new int[RANGE_ARR_LENGTH];
    }

    @Override
    public int computeResult() {

        parseRange();
        List<Integer> range = IntStream.range(arrRange[0], arrRange[1])
                                        .boxed()
                                        .collect(Collectors.toList());

        List<Integer> filteredRange1 = filterNumbers(range, hasRightDigitNumberPredicate());
        List<Integer> filteredRange2 = filterNumbers(filteredRange1, hasEqualAdjacentDigitPredicate());
        List<Integer> filteredRange3 = filterNumbers(filteredRange2, hasNotDeacreasingDigitsPredicate());

        return filteredRange3.size();
    }

    public static List<Integer> filterNumbers (List<Integer> numbers,
                                                 Predicate<Integer> predicate)
    {
        return  numbers.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public int computeSecondPartResult() {
        return 0;
    }

    private boolean hasRightDigitNumber(int number){
        return false;
    }

    private Predicate<Integer> hasRightDigitNumberPredicate(){
        return n -> hasRightDigitNumber(n);
    }

    private boolean hasEqualAdjacentDigit(int number){
        return false;
    }

    private Predicate<Integer> hasEqualAdjacentDigitPredicate(){
        return n -> hasEqualAdjacentDigit(n);
    }

    private boolean hasNotDeacreasingDigits(int number){
        return false;
    }

    private Predicate<Integer> hasNotDeacreasingDigitsPredicate(){
        return n -> hasNotDeacreasingDigits(n);
    }

    private void parseRange(){

        String[] range = stringRange.split("-");
        arrRange[0] = Integer.parseInt(range[0]);
        arrRange[2] = Integer.parseInt(range[2]);
    }

}
