package common;

import services.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static resources.values.Values.*;

public abstract class Puzzle {

    protected IO io;

    public Puzzle() {
        io = new IO();
    }

    public void initialize(String fileName){

        io.setFile(new File(FULL_INPUTS_PATH_PREFIX + fileName));
    }

    public abstract int computeResult();

    public abstract int computeSecondPartResult();


    public List<String> toArrayList(){

        BufferedReader bufferedReader = io.getFileContent();
        ArrayList<String> result = new ArrayList<>();
        String line = "";

        while(true){
            try {
                if (!((line = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            result.add(line);
        }

        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String getFileContentAsString(){

        BufferedReader bufferedReader = io.getFileContent();
        String result = "";
        String line = "";

        while(true){
            try {
                if (!((line = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            result += " " + line;
        }

        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public int[] convertToIntArray(String[] inputArray){

        int[] resultArray = new int[inputArray.length];

        for(int i = 0; i < inputArray.length; i++){
            resultArray[i] = Integer.parseInt(inputArray[i].trim());
        }

        return resultArray;
    }
}
