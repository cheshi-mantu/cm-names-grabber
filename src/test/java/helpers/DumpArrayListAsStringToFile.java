package helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DumpArrayListAsStringToFile {
    private String fileFullPath = "";
    private String stringToSave = "";
    public DumpArrayListAsStringToFile(ArrayList<String> arrayListToSave, String fileNamePath) {
        stringToSave = arrayListToSave.toString()
                .replaceAll(",","\r\n")
                .replaceAll("\\[","")
                .replaceAll("\\]","")
                .trim();
        try {
            File fileToSaveTo = new File("D:\\Downloads\\" + fileNamePath);
            if (!fileToSaveTo.exists()) {
                fileToSaveTo.delete();
            } else {
                fileToSaveTo.createNewFile();
                fileFullPath = fileToSaveTo.getAbsolutePath();
                System.out.println(fileFullPath);
                FileWriter doDump = new FileWriter(fileFullPath);
                doDump.write(stringToSave);
                doDump.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
