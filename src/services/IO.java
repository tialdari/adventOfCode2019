package services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IO {

    public BufferedReader getFileContent(File file){

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return new BufferedReader(fileReader);

    }

    public List<String> processFileText(BufferedReader bufferedReader){

        ArrayList<String> result = new ArrayList<String>();
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
