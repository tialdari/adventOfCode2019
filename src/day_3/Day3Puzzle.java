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

        Step step1 = new Step(new Point(0, 0, 0), new Point(11, 0, 11), "R", 11);
        Step step2 = new Step(new Point(5, -5, 10), new Point(5, 5, 10), "U", 10);

        System.out.println(step1.isCrossed(step2));
        System.out.println(step1.generateCrossPoint(step2).toString());


        /*
        List<String> inputInstructions = Arrays.asList(getFileContentAsString().split(" |,"));

        initializeCablesInstructions(inputInstructions.subList(1, inputInstructions.size()));

        List<Step> cable1Steps = generateStepsList(cable1Instructions);
        List<Step> cable2Steps = generateStepsList(cable2Instructions);

        cable1Steps.forEach(i -> System.out.println(i.toString()));
        cable2Steps.forEach(i -> System.out.println(i.toString()));

        List<Point> crossPoints = generateCrossPoints(cable1Steps, cable2Steps);
        //int result = getLeastManhattanValue(crossPoints);
*/

        return 0;
    }

    private List<Point> generateCrossPoints(List<Step> cable1Steps, List<Step> cable2Steps) {

        List<Point> crossPoints = new ArrayList<>();

        for(int i = 0; i < cable1Steps.size(); i++){
            for(int j = 0; j < cable2Steps.size(); j++){
                if(cable1Steps.get(i).isCrossed(cable2Steps.get(j))) crossPoints.add(new Point());
            }
        }
        return crossPoints;
    }

    private Point generateCrossPoint(Step step1, Step step2){



        return new Point();
    }

    private List<Step> generateStepsList(List<String> inputInstructions) {

        List<Step> stepsList = new ArrayList<>();

        Step nextStep;
        Point departurePoint = new Point(0, 0, 0);
        String direction = String.valueOf(inputInstructions.get(0).charAt(0));
        int stepValue = Integer.parseInt(inputInstructions.get(0).substring(1));
        nextStep = new Step(departurePoint, direction, stepValue);
        nextStep.computeDestinationPoint();
        stepsList.add(nextStep);

        for(int i = 1; i < inputInstructions.size(); i++){

            direction = String.valueOf(inputInstructions.get(i).charAt(0));
            stepValue = Integer.parseInt(inputInstructions.get(i).substring(1));

            nextStep = new Step(new Point(stepsList.get(i - 1).getDestinationPoint().getX(),
                    stepsList.get(i - 1).getDestinationPoint().getY(),
                    stepsList.get(i - 1).getDestinationPoint().getManhattanValue()), direction, stepValue);
            nextStep.computeDestinationPoint();
            stepsList.add(nextStep);
        }

        return stepsList;
    }

    private void initializeCablesPointsPairs() {
    }


    private void initializeCablesInstructions(List<String> inputInstructions){

        int secondCableFirstInstrIndex = inputInstructions.indexOf(SECOND_CABLE_FIRST_INSTRUCTION);

        cable1Instructions = inputInstructions.subList(0, secondCableFirstInstrIndex);
        cable2Instructions = inputInstructions.subList(secondCableFirstInstrIndex, inputInstructions.size());
    }


}
