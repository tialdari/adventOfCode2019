package day_2;

import common.Puzzle;

public class Day2Puzzle extends Puzzle {

    public static final int OPCODE_ADD_NUM = 1;
    public static final int OPCODE_MULT_NUM = 2;
    public static final int OPCODE_TERMINATE_NUM = 99;

    public static final int POS_1_REPLACE_NUM = 12;
    public static final int POS_2_REPLACE_NUM = 2;

    public Day2Puzzle() {
        super();
    }

    @Override
    public int computeResult() {

        int[] intcode = convertToIntArray(getFileContentAsString().split(","));

        intcode[1] = POS_1_REPLACE_NUM;
        intcode[2] = POS_2_REPLACE_NUM;
        int resultPos;
        int firstNumPos;
        int secondNumPos;

        for (int i = 0; i < intcode.length; i++) {

            switch (intcode[i]) {

                case OPCODE_ADD_NUM:
                    resultPos = intcode[i + 3];
                    firstNumPos = intcode[i + 1];
                    secondNumPos = intcode[i + 2];
                    intcode[resultPos] = intcode[firstNumPos] + intcode[secondNumPos];
                    if(i + 4 < intcode.length) i += 3;

                    break;

                case OPCODE_MULT_NUM:
                    resultPos = intcode[i + 3];
                    firstNumPos = intcode[i + 1];
                    secondNumPos = intcode[i + 2];
                    intcode[resultPos] = intcode[firstNumPos] * intcode[secondNumPos];
                    if(i + 4 <= intcode.length) i += 3;

                    break;

                case OPCODE_TERMINATE_NUM:
                    return intcode[0];
            }
        }
        return intcode[0];
    }

    private int[] convertToIntArray(String[] inputArray){

        int[] resultArray = new int[inputArray.length];

        for(int i = 0; i < inputArray.length; i++){
            resultArray[i] = Integer.parseInt(inputArray[i].trim());
        }

        return resultArray;
    }
}
