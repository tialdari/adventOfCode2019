package services;

import java.io.*;

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
}
