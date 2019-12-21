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

    public void initialize(){

        io.setFile(new File(FULL_INPUTS_PATH_PREFIX + "day_1_input.txt"));
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

        return result;
    }
}
