package services;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IO {

    private File file;
    private Scanner scanner;

    public IO() {
        scanner = new Scanner(System.in);
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

    public int getInt(){

        int input = -1;

       if(scanner.hasNextInt()) return scanner.nextInt();
       else return input;
    }
}
