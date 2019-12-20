package day_1;

import services.IO;
import common.Puzzle;
import java.io.File;

public class Day1Puzzle extends Puzzle {

    public Day1Puzzle() {
        super();
    }

    public Day1Puzzle(IO io, File file) {
        super();
    }

    @Override
    public int computeResult() {

        for (String line : processText()) {
            System.out.println(line);
        }

        return 0;
    }
}
