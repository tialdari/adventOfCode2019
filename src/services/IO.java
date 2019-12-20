package services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IO {

    private File file;

    public IO() {
    }

    public IO(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
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
