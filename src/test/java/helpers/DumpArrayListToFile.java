package helpers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DumpArrayListToFile {
    DumpArrayListToFile(ArrayList arrayListToSave, String fileNamePath) throws FileNotFoundException {
            FileOutputStream fout= new FileOutputStream (fileNamePath);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(arrayListToSave);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
