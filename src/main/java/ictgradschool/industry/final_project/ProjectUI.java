package ictgradschool.industry.final_project;

import javax.swing.*;
//TODO Save File whenever changes are made
//TODO create Filestore should create a new file if the file does not exist
public class ProjectUI {
    public static void main(String[] args) {
        // TODO: Your code here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WelcomeScreenFrame frame = new WelcomeScreenFrame("Welcome to Point of Sales",100,100,800,800);
                frame.setVisible(true);
            }
        });
    }
}
