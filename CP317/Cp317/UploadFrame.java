package Cp317.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class UploadFrame extends JPanel{
    //GUI Elements
    private final JButton button = new JButton("Upload File");
    public Scanner SupplierFile = null;
    public Scanner ProductFile = null;
    /*
     * Inner class that accesses button
     */
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(final ActionEvent e) {
            if (e.getSource()==button) {
                JFileChooser fileupload = new JFileChooser();
                int response = fileupload.showOpenDialog(null);
                if (response==JFileChooser.APPROVE_OPTION) {
                    File file = new File(fileupload.getSelectedFile().getAbsolutePath());
                    try {
                        if (file.getName().equals("SupplierFile.txt")) {
                            SupplierFile = new Scanner(file);
                            FilesUtilites.readSupplier(SupplierFile);
                        } else if (file.getName().equals("ProductFile.txt")) {
                            ProductFile = new Scanner(file);
                            FilesUtilites.readProducts(ProductFile);
                        } else {
                            System.out.println("Invalid file. Please select the proper files.");
                        }   
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }
            } 
            if (SupplierFile!=null && ProductFile!=null) {
                System.out.println("it works!");
            } 
        }
    }
    
    /*
     * Panel constructor. Lays out GUI elements then applies their listeners.
     */
    public UploadFrame() {
        this.add(this.button);
        this.button.setFocusable(false);    
        this.button.addActionListener(new ButtonListener());

    }
}

