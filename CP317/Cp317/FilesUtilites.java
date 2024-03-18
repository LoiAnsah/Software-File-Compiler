package Cp317.src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;






// Read Supplier filee
/**
 * Utilities for working with Files.
 *
 * @author Ama Ansah, 210744370, ansa4370@mylaurier.ca
 * @version 2024-03-11
 */
public class FilesUtilites {


   public static void main(String[] args) {
    try {

      // Create Scanner objects for supplier and product files
      Scanner supplierScanner = new Scanner(new File("Suppliers.txt"));
      Scanner productScanner = new Scanner(new File("Product.txt"));

      // Call the combine method to get FileWriter
      FileWriter finalFileWriter = combine(supplierScanner, productScanner);

      // Close the scanners after use
      supplierScanner.close();
      productScanner.close();

      // Close the FileWriter
      finalFileWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  public static ArrayList<Supplier> readSupplier(final Scanner fileIn){


    // create a list
    ArrayList<Supplier> supplierList = new ArrayList<>();

    while(fileIn.hasNextLine()) {

    String line = fileIn.nextLine();
    String[] attributes = line.split("\\,");

    Supplier supplier_data = new Supplier(Integer.parseInt(attributes[0].trim()), attributes[1],
		  attributes[2], attributes[3], attributes[4]);
    
        supplierList.add(supplier_data);
    }
    return supplierList;
  }



  // read Product File 
  public static ArrayList<Product> readProducts(final Scanner fileIn){

    ArrayList<Product> productList = new ArrayList<Product>();
   while(fileIn.hasNextLine()){

      String line = fileIn.nextLine();
      String [] attributes = line.split("\\,");


      Product product_data = new Product(Integer.parseInt(attributes[0]), attributes[1], attributes[2],
		    (attributes[3]), (attributes[4]), attributes[5], Integer.parseInt(attributes[6].trim()));
    
        productList.add(product_data);
        Collections.sort(productList);

    }
   
    return productList;
  }


  // Combine

  public static FileWriter combine(final Scanner SupFile, final Scanner ProFile) {
    FileWriter InFile = null;

    try {
        InFile = new FileWriter("Inventory.txt");

        // List of product objects organized by ID
        ArrayList<Product> productList = readProducts(ProFile);
        // List of supplier objects
        ArrayList<Supplier> supplierList = readSupplier(SupFile);

        // Use to iterate through the product list
        int i = 0;
        // Use to iterate through the supplier list
        int n;

        while (i < productList.size()) {
            n = 0; // Reset the supplier index for each product
            while (n < supplierList.size() && productList.get(i).getSupplierId() != supplierList.get(n).getSupplierId()) {
                n++;
            }

            // Check if a matching supplier was found
            if (n < supplierList.size()) {
                Inventory inventory = new Inventory(productList.get(i).getProductId(),
                        productList.get(i).getProductName(), productList.get(i).getQuantity(),
                        productList.get(i).getPrice(), productList.get(i).getStatus(),
                        supplierList.get(n).getSupplierName());

                InFile.write(inventory.toString());
                InFile.write("\n");
            }

            i++;
        }
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    } finally {
        try {
            if (InFile != null) {
                InFile.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    return InFile;
  }
}




/**   OLD VERSION
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

*/


