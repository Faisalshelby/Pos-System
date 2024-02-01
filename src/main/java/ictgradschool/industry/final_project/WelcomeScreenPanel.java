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
    JButton exit;
    File file;

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
            File f = fileSelector();
            //TODO for file not null make a separate panel or appropriate display with three buttons

            if (f != null) {
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
    private File fileSelector(){

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //TODO select csv files, and make a default csv file for a products list

        fileChooser.setCurrentDirectory(new File("./src/main/resources"));
        FileNameExtensionFilter filter= new FileNameExtensionFilter("Text Files","txt");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showDialog(WelcomeScreenPanel.this,"select");
        if (result == JFileChooser.APPROVE_OPTION){
            file = new File(String.valueOf(fileChooser.getSelectedFile()));
        }
        //TODO return the required file
        return file;
    }

}