package day_1;

import common.Puzzle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1Puzzle extends Puzzle {

    private static int MIN_VALID_FUEL_MASS = 6;

    public Day1Puzzle() {
        super();
    }

    @Override
    public int computeResult() {

        List<String> inputStrings = toArrayList();
        List<Integer> inputNumbers = new ArrayList<>();

        inputStrings.forEach((line) -> inputNumbers.add(Integer.parseInt(line)));

        int modulesFuel = inputNumbers.stream().mapToInt(Integer::intValue).map(this::computeOneModuleFuel).sum();
        int fuelForFuel = inputNumbers.stream().mapToInt(Integer::intValue).map(this::computeOneModuleFuel).map(i -> computeFuelForFuel(i, 0)).sum();

        return modulesFuel + fuelForFuel;
    }

    private int computeOneModuleFuel(int input){

        return (input /3) - 2;
    }

    public int computeFuelForFuel(int fuelMass, int fuelSum){

        while(fuelMass >= MIN_VALID_FUEL_MASS){

            return computeFuelForFuel((fuelMass /3) - 2, fuelSum + (fuelMass /3) - 2);
        }
        return fuelSum;
    }
}
