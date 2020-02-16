package day_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import common.Puzzle;

public class Day2Puzzle extends Puzzle {

    public static final int OPCODE_ADD_NUM = 1;
    public static final int OPCODE_MULT_NUM = 2;
    public static final int OPCODE_INPUT_NUM = 3;
    public static final int OPCODE_OUTPUT_NUM = 4;
    public static final int OPCODE_TERMINATE_NUM = 99;

    public static final int POS_1_REPLACE = 1;
    public static final int POS_2_REPLACE = 2;

    public static final int NOUN_RANGE = 99;
    public static final int VERB_RANGE = 99;

    private int currentPos;

    public Day2Puzzle() {
        super();
        currentPos = 0;
    }

    @Override
    public int computeResult() {

        int[] intcode = convertToIntArray(getFileContentAsString().split(","));
        intcode = replaceNumbers(intcode, 12, 2);
//        int[] resultPair = computeInputPair(intcode, 19690720);
//        int result = 100 * resultPair[0] + resultPair[1];

        return getProgramResult(intcode);
    }

    @Override
    public int computeSecondPartResult() {
        return 0;
    }

    private int[] replaceNumbers(int[] intcode, int pos1ReplaceNum, int pos2ReplaceNum){

        intcode[POS_1_REPLACE] = pos1ReplaceNum;
        intcode[POS_2_REPLACE] = pos2ReplaceNum;
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

        int[] intCodeCopy = intcode;
        List<Integer> instruction = new ArrayList<>();

        while(currentPos < intCodeCopy.length){

            instruction.clear();

            switch (intCodeCopy[currentPos]) {

                case OPCODE_INPUT_NUM:
                    Collections.addAll(instruction, intCodeCopy[currentPos], intCodeCopy[currentPos+1]);
                    intCodeCopy = manageOpcodeInputNum(intCodeCopy, instruction);
                    break;

                case OPCODE_OUTPUT_NUM:
                    Collections.addAll(instruction, intCodeCopy[currentPos], intCodeCopy[currentPos+1]);
                    manageOpcodeOutputNum(intCodeCopy, instruction);
                    break;

                case OPCODE_TERMINATE_NUM:
                    return intCodeCopy[0];

                default:
                    Collections.addAll(instruction, intCodeCopy[currentPos], intCodeCopy[currentPos+1], intCodeCopy[currentPos+2], intCodeCopy[currentPos+3]);
                    intCodeCopy = decodeInstruction(intCodeCopy, instruction);
            }
        }
        return intCodeCopy[0];
    }

    private int[] manageOpcodeAddNum(int[] intcode, List<Integer> instruction){

        int resultPos = computeResultPos(instruction);
        int firstNumPos = computeFirstNumPos(instruction);
        int secondNumPos = computeSecondNumPos(instruction);

        intcode[resultPos] = intcode[firstNumPos] + intcode[secondNumPos];
        if(currentPos + 4 < intcode.length) currentPos += 4;

        return intcode;
    }

    private int[] manageOpcodeMultNum(int[] intcode, List<Integer> instruction){

        int resultPos = computeResultPos(instruction);
        int firstNumPos = computeFirstNumPos(instruction);
        int secondNumPos = computeSecondNumPos(instruction);

        intcode[resultPos] = intcode[firstNumPos] * intcode[secondNumPos];
        if(currentPos + 4 <= intcode.length) currentPos += 4;

        return intcode;
    }

    private int[] manageOpcodeInputNum(int[] intcode, List<Integer> instruction){

        int inputSavePos = instruction.get(1);
        intcode[inputSavePos] = io.getInt();
        return intcode;
    }

    private void manageOpcodeOutputNum(int[] intcode, List<Integer> instruction){

        System.out.println(intcode[instruction.get(1)] + " ");
    }

    private int computeResultPos(List<Integer> instruction){
        return instruction.get(3);
    }

    private int computeFirstNumPos(List<Integer> instruction){
        return instruction.get(1);
    }

    private int computeSecondNumPos(List<Integer> instruction){
        return instruction.get(2);
    }

    private int[] decodeInstruction(int[] intcode, List<Integer> instruction){

        switch (decodeOpCode(instruction.get(0))) {

            case OPCODE_ADD_NUM:
                return manageOpcodeAddNum(intcode, instruction);

            case OPCODE_MULT_NUM:
                return manageOpcodeMultNum(intcode, instruction);

            default:
                System.out.println("Error, opcode: " + instruction.get(0) + " doesn't exist");
        }

        return intcode;
    }

    public int decodeOpCode(int opCodeInstruction){

        char[] charArr = String.valueOf(opCodeInstruction).toCharArray();
        return Integer.valueOf(String.valueOf(charArr[charArr.length - 1]));
    }
}
