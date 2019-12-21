package common;

import services.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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

    public List<String> toArray(){

        BufferedReader csvReader = io.getFileContent();
        List<String> newList = new ArrayList<>();

        String row = "";

        while (true) {
            try {
                if (!((row = csvReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] data = row.split(",");
            Collections.addAll(newList, data);
        }
        try {
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newList;
    }
}
