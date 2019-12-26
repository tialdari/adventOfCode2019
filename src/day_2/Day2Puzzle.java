package day_2;

import common.Puzzle;

public class Day2Puzzle extends Puzzle {

    public static final int OPCODE_ADD_NUM = 1;
    public static final int OPCODE_MULT_NUM = 2;
    public static final int OPCODE_TERMINATE_NUM = 99;

    public static final int POS_1_REPLACE_NUM = 12;
    public static final int POS_2_REPLACE_NUM = 2;

    public static final int NOUN_RANGE = 99;
    public static final int VERB_RANGE = 99;

    public Day2Puzzle() {
        super();
    }

    @Override
    public int computeResult() {

        int[] intcode = convertToIntArray(getFileContentAsString().split(","));

        int[] resultPair = computeInputPair(intcode, 19690720);
        int result = 100 * resultPair[0] + resultPair[1];

        return result;

    }

    @Override
    public int computeSecondPartResult() {
        return 0;
    }

    private int[] replaceNumbers(int[] intcode, int pos1ReplaceNum, int pos2ReplaceNum){

        intcode[1] = pos1ReplaceNum;
        intcode[2] = pos2ReplaceNum;
        return intcode;
    }

    private int[] computeInputPair(int[] intcode, int givenResult){

        int[] intcodeCopy;

        for(int i = 0; i <= NOUN_RANGE; i++){
            for(int j = 0; j <= VERB_RANGE; j++){
                intcodeCopy = replaceNumbers(intcode.clone(), i, j);
                if(getProgramResult(intcodeCopy) == givenResult) return new int[]{i, j};
            }
        }
        return new int[]{0,0};
    }

    private int getProgramResult(int[] intcode){

        int resultPos;
        int firstNumPos;
        int secondNumPos;

        for (int i = 0; i < intcode.length; i++) {

            resultPos = intcode[i + 3];
            firstNumPos = intcode[i + 1];
            secondNumPos = intcode[i + 2];

            switch (intcode[i]) {

                case OPCODE_ADD_NUM:

                    intcode[resultPos] = intcode[firstNumPos] + intcode[secondNumPos];
                    if(i + 4 < intcode.length) i += 3;

                    break;

                case OPCODE_MULT_NUM:
                    intcode[resultPos] = intcode[firstNumPos] * intcode[secondNumPos];
                    if(i + 4 <= intcode.length) i += 3;

                    break;

                case OPCODE_TERMINATE_NUM:
                    return intcode[0];
            }
        }
        return intcode[0];
    }
}
