package CP317.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FilesUtilites {
    public Scanner SupplierFile;
    public Scanner ProductFile;
    public Scanner InventoryFile;
    
    public Scanner CombineInventory(final Scanner SupplierFile, final Scanner ProductFile) {
        String supplierName = "",prductId = "";
        int quantity = 0;
        int price = 0; 
        ArrayList<Inventory> Inventories = new ArrayList<Inventory>();
        File tempInventoFile = new File("InventoryFile.txt");
        String[] arraySupply = null;
        

        
        return InventoryFile;
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

