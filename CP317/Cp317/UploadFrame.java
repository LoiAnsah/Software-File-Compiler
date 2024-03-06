package CP317.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FilesUtilites {
    public static void UploadFile(final File file) {
        try {
            Scanner SupplyFileIn = new Scanner(file);
            String line;
            while (SupplyFileIn.hasNext()) {
                line = SupplyFileIn.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
