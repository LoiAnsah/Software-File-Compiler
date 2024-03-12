package CP317.src;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class UploadFrame extends JFrame implements ActionListener {
    private final JButton button=new JButton("Upload File");
    UploadFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setTitle("Upload File");
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        
        button.setFocusable(false);
        button.addActionListener(this);

        this.add(button);

        this.pack();
        this.setVisible(true);
    }
  

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource()==button) {
            JFileChooser fileupload = new JFileChooser();
            int response = fileupload.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileupload.getSelectedFile().getAbsolutePath());
                FilesUtilites.UploadFile(file);
            }
        }
    }
}
