package CP317.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FilesUtilites {
    public Scanner SupplierFile;
    public Scanner ProductFile;

    public static void UploadFile(final File file) {
        try {
            System.out.println(file.getName());
            if (file.getName().equals("SupplierFile.txt")) {
                Scanner SupplierFile = new Scanner(file);
                SupplierFile.close();
            } else if (file.getName()=="ProductFile.txt\n"){
                Scanner ProductFile = new Scanner(file);
                ProductFile.close();
            } else {
                System.out.println("Not a suitable file. Please pick the proper files.");
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
    
    public static void SupplierPrint(final Scanner SupplierFile) {
        String line;
        while (SupplierFile.hasNext()) {
            line = SupplierFile.nextLine();
            System.out.println(line);
        }
        SupplierFile.close();
    }

    public static void ProductPrint(final Scanner ProductFile) {
        String line;
        while (ProductFile.hasNext()) {
            line = ProductFile.nextLine();
            System.out.println(line);
        }
        ProductFile.close();
    }
}
