package ictgradschool.industry.final_project;

import javax.swing.*;
//TODO CREATE filestore
//TODO Reciept
//TODO Reciept model adapter
//todo save file from reciept
public class ProjectUI {
    public static void main(String[] args) {
        // TODO: Your code here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WelcomeScreenFrame frame = new WelcomeScreenFrame("Welcome to Point of Sales",100,100,400,600);
                frame.setVisible(true);
            }
        });
    }
}
