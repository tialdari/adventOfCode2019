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

    public Day4Puzzle() {
        arrRange = new int[RANGE_ARR_LENGTH];
    }

    @Override
    public int computeResult() {

        List<Integer> range = getRangeList();

        return filterWithPredicates(range).size();
    }

    @Override
    public int computeSecondPartResult() {

        List<Integer> range = getRangeList();

        return filterWithPredicates2(range).size();
    }

    private List<Integer> getRangeList(){

        stringRange = getFileContentAsString();
        parseRange();
        return IntStream.range(arrRange[0], arrRange[1])
                .boxed()
                .collect(Collectors.toList());
    }

    private List<Integer> filterWithPredicates(List<Integer> listNumbers){

        List<Integer> filteredRange1 = filterNumbers(listNumbers, hasRightDigitNumberPredicate());
        List<Integer> filteredRange2 = filterNumbers(filteredRange1, hasEqualAdjacentDigitPredicate());
        List<Integer> filteredRange3 = filterNumbers(filteredRange2, hasNotDeacreasingDigitsPredicate());

        return filteredRange3;
    }

    private List<Integer> filterWithPredicates2(List<Integer> listNumbers){

        List<Integer> filteredRange1 = filterNumbers(listNumbers, hasRightDigitNumberPredicate());
        List<Integer> filteredRange2 = filterNumbers(filteredRange1, hasEqualSeparateAdjacentDigitPredicate());
        List<Integer> filteredRange3 = filterNumbers(filteredRange2, hasNotDeacreasingDigitsPredicate());

        return filteredRange3;
    }

    public static List<Integer> filterNumbers (List<Integer> numbers,
                                                 Predicate<Integer> predicate)
    {
        return  numbers.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public boolean hasRightDigitNumber(int number){

        int digitsNumber = String.valueOf(number).toCharArray().length;
        return digitsNumber >= 1 && digitsNumber <= DIGITS_NUMBER;
    }

    private Predicate<Integer> hasRightDigitNumberPredicate(){
        return n -> hasRightDigitNumber(n);
    }

    public boolean hasEqualAdjacentDigit(int number){

        char[] charArrNumber = String.valueOf(number).toCharArray();

        for(int i = 0; i < charArrNumber.length - 1; i++){
            if(charArrNumber[i] == charArrNumber[i + 1]) {
                return true;
            }
        }
        return false;
    }

    private Predicate<Integer> hasEqualAdjacentDigitPredicate(){
        return n -> hasEqualAdjacentDigit(n);
    }

    public boolean hasEqualSeperateAdjacentDigit(int number){

        char[] charArrNumber = String.valueOf(number).toCharArray();
        int charArrLength = charArrNumber.length;

        for(int i = 1; i < charArrNumber.length - 2; i++){
            if(charArrNumber[i] == charArrNumber[i + 1]
                && charArrNumber[i - 1] != charArrNumber[i]
                && charArrNumber[i + 1] != charArrNumber[i + 2]) return true;
        }

        if((charArrNumber[0] == charArrNumber[1] && charArrNumber[1] != charArrNumber[2])
                || (charArrNumber[charArrLength- 1] == charArrNumber[charArrLength - 2]
                && charArrNumber[charArrLength - 2] != charArrNumber[charArrLength - 3])) return true;
        return false;
    }

    private Predicate<Integer> hasEqualSeparateAdjacentDigitPredicate(){
        return n -> hasEqualSeperateAdjacentDigit(n);
    }

    public boolean hasNotDeacreasingDigits(int number){

        char[] charArrNumber = String.valueOf(number).toCharArray();

        for(int i = 0; i < charArrNumber.length - 1; i++){
            if(charArrNumber[i] > charArrNumber[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private Predicate<Integer> hasNotDeacreasingDigitsPredicate(){
        return n -> hasNotDeacreasingDigits(n);
    }

    private void parseRange(){

        String[] range = stringRange.split("-");
        arrRange[0] = Integer.parseInt(range[0]);
        arrRange[1] = Integer.parseInt(range[1]);
    }
}
