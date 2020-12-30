package helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DumpArrayListAsStringToFile {
    public DumpArrayListAsStringToFile(ArrayList<String> arrayListToSave, String fileNamePath) {
        String stringToSave;
        stringToSave = convertedToStringAndCleaned(arrayListToSave);
            File fileToSaveTo = new File(fileNamePath);
            if (fileToSaveTo.exists())
                fileToSaveTo.delete();
        try {
            FileWriter doDump = new FileWriter(fileNamePath);
            doDump.write(stringToSave);
            doDump.close();
        } catch (IOException e) {
            e.printStackTrace(); // yeah I know it's problem swallowing
        }
    }
    private String convertedToStringAndCleaned(ArrayList<String> arrayListToSave) {
        String stringToSave;
        stringToSave = arrayListToSave.toString()
                .replaceAll(",","\r\n")
                .replaceAll("\\[","")
                .replaceAll("]","")
                .trim();
        return stringToSave;
    }
}
