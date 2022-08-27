package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.ArrayList;

public class Files {
    private String file;

    public Files(String _file) {
        file = _file;
    }

    public String readFile() throws FileNotFoundException {
        File fileObject = new File(file);

        Scanner reader = new Scanner(fileObject);

        StringBuilder content = new StringBuilder();

        while(reader.hasNextLine()) {
            content.append(reader.nextLine());
        }

        reader.close();

        return content.toString();
    }

    public String[] readLines() throws FileNotFoundException {
        File fileObject = new File(file);

        Scanner reader = new Scanner(fileObject);

        ArrayList<String> lines = new ArrayList<>();

        while(reader.hasNextLine()) {
            lines.add(reader.nextLine());
        }

        reader.close();

        String[] linesArray = new String[lines.size()];

        for(int index=0; index < lines.size(); index++) {
            linesArray[index] = lines.get(index);
        }

        return linesArray;
    }
}
