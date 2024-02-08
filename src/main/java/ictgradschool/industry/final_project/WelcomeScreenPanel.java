package ictgradschool.industry.final_project;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class WelcomeScreenPanel extends JPanel implements ActionListener{

    JButton openFileStore;

    JButton createFileStore;
    JButton exit;
 List<Products> productsList;

    public WelcomeScreenPanel(){

        setBackground(Color.WHITE);
        this.openFileStore = new JButton("Open FileStore");
        this.createFileStore = new JButton("Create New FileStore");
        this.exit = new JButton("Exit");

        this.add(openFileStore);
        this.add(createFileStore);
        this.add(exit);



        openFileStore.addActionListener(this);
        createFileStore.addActionListener(this);
        exit.addActionListener(this);

    }

// Action Event For FileStore Buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openFileStore){
    try {
        String filename = fileSelector();
        FileReadWrite readWrite = new FileReadWrite();
        this.productsList = readWrite.fileRead(filename);

         }catch (IOException ioe){
        System.out.println("Incorrect File");
        }
            //TODO for file not null make a separate panel or appropriate display with three buttons

            if (this.productsList != null) {
                closeCurrentWindow(e);
                FileStoreFrame frame = new FileStoreFrame("File Store",100,100,800,800,this.productsList);
                 frame.setVisible(true);
            }
        } else if (e.getSource() == createFileStore) {
            try {
                String filename = fileSelector();
                File f = new File(filename);
                if (f.exists()) {
                    throw new FileSystemException("File Already Exists");
                }
                FileReadWrite write = new FileReadWrite();
                this.productsList = new ArrayList<>();
                write.fileWrite(filename,this.productsList);
                closeCurrentWindow(e);
                FileStoreFrame frame = new FileStoreFrame("File Store",100,100,800,800,this.productsList);
                frame.setVisible(true);
            }catch (IOException exc){
                System.out.println("Incorrect File");
            }

        } else if (e.getSource() == exit) {
            JComponent c = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(c);
            win.dispose();
        }
    }


    //Function to select the Set File Type
    private String fileSelector() throws IOException {
        String s = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setCurrentDirectory(new File("./src/main/resources"));
        FileNameExtensionFilter filter= new FileNameExtensionFilter("CSV Files","csv");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showDialog(WelcomeScreenPanel.this,"select");
        if (result == JFileChooser.APPROVE_OPTION){
             s = String.valueOf(fileChooser.getSelectedFile());
            return s;
        }
        else {
            System.out.println("NO FILE SELECTED");
            return "default.csv";
        }

    }

    public void closeCurrentWindow(ActionEvent e){
        JComponent c = (JComponent) e.getSource();
        Window win = SwingUtilities.getWindowAncestor(c);
        win.dispose();
    }
}
