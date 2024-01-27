package ictgradschool.industry.final_project;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class WelcomeScreenPanel extends JPanel implements ActionListener{

    JButton openFileStore;

    JButton createFileStore;

    JButton openInventory;
    JButton openPointOfSale;

    public WelcomeScreenPanel(){

        setBackground(Color.WHITE);
        this.openFileStore = new JButton("Open FileStore");
        this.createFileStore = new JButton("Create New FileStore");
        this.openInventory = new JButton("Open Inventory");
        this.openPointOfSale = new JButton("Open Point Of Sale");
        this.add(openFileStore);
        this.add(createFileStore);
        openFileStore.addActionListener(this);
        createFileStore.addActionListener(this);
        openInventory.addActionListener(this);
        openPointOfSale.addActionListener(this);

    }

// Action Event For FileStore Buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openFileStore){
            fileSelector();
        } else if (e.getSource() == createFileStore) {
            fileSelector();
        }

    }


    //Function to select the Set File Type
    private void fileSelector(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setCurrentDirectory(new File("./src/main/resources"));
        FileNameExtensionFilter filter= new FileNameExtensionFilter("Text Files","txt");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showDialog(WelcomeScreenPanel.this,"select");
        if (result == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();

        }

    }

}