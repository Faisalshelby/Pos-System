package ictgradschool.industry.final_project;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
        productsList = readWrite.fileRead(filename);

    }catch (IOException ioe){
        System.out.println("Incorrect File");
    }
            //TODO for file not null make a separate panel or appropriate display with three buttons

            if (productsList != null) {
                FileStoreFrame frame = new FileStoreFrame("File Store",100,100,400,600);
                 frame.setVisible(true);
            }
        } else if (e.getSource() == createFileStore) {

            //TODO Add functionality

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
        //TODO select csv files, and make a default csv file for a products list
        //Todo call the read file from file reader, and store the value in the inventory class
        fileChooser.setCurrentDirectory(new File("./src/main/resources"));
        FileNameExtensionFilter filter= new FileNameExtensionFilter("CSV Files","csv");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showDialog(WelcomeScreenPanel.this,"select");
        if (result == JFileChooser.APPROVE_OPTION){
             s = String.valueOf(fileChooser.getSelectedFile());
            return s;
        }

        return null;

    }



}