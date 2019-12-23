package day_3;

import java.util.Arrays;
import java.util.List;
import common.Puzzle;

import java.util.ArrayList;

public class Day3Puzzle extends Puzzle {

    public final String SECOND_CABLE_FIRST_INSTRUCTION = "L1009";

    List<String> cable1Instructions;
    List<String> cable2Instructions;

    List<CoordinatesPair> cable1KeyCoordinatesPairs;
    List<CoordinatesPair> cable2KeyCoordinatesPairs;

    public Day3Puzzle() {
        super();
        cable1KeyCoordinatesPairs = new ArrayList<>();
        cable2KeyCoordinatesPairs = new ArrayList<>();

        cable1Instructions = new ArrayList<>();
        cable2Instructions = new ArrayList<>();
    }

    @Override
    public int computeResult() {
        
        List<String> inputInstructions = Arrays.asList(getFileContentAsString().split(" |,"));
        initializeCablesInstructions(inputInstructions);
        initializeCablesPointsPairs();
        
        return 0;
    }

    private void initializeCablesPointsPairs() {
    }


    private void initializeCablesInstructions(List<String> inputInstructions){

        int secondCableFirstInstrIndex = inputInstructions.indexOf(SECOND_CABLE_FIRST_INSTRUCTION);

        cable1Instructions = inputInstructions.subList(0, secondCableFirstInstrIndex);
        cable2Instructions = inputInstructions.subList(secondCableFirstInstrIndex, inputInstructions.size() - 1);
    }
}
