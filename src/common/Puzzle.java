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
    protected File file;

    public Puzzle() {
        io = new IO();
    }

    public Puzzle(IO io, File file) {
        this.io = io;
        this.file = file;
    }

    public void initialize(){

        if(file == null) file = new File(FULL_INPUTS_PATH_PREFIX + "day_1_input.txt");
        io.setFile(file);
    }

    public abstract int computeResult();

    public List<String> processText(){

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
            System.out.println(line);
        }

        return result;
    }
}
