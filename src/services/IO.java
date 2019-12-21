package services;

import java.io.*;
import java.util.ArrayList;

public class IO {

    private File file;

    public IO() {
    }

    public void setFile(File file) {
        this.file = file;
    }

    public BufferedReader getFileContent(){

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return new BufferedReader(fileReader);
    }

    public BufferedReader getCsvFileContent(){

        BufferedReader csvReader = null;
        try {
            csvReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return new BufferedReader(csvReader);
    }
}
