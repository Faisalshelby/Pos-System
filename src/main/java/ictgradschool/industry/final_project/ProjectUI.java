package ictgradschool.industry.final_project;

import javax.swing.*;

public class ProjectUI {
    public static void main(String[] args) {
        // TODO: Your code here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //WelcomeScreenFrame frame = new WelcomeScreenFrame("Welcome to Point of Sales",100,100,400,600);
                InventoryManagerFrame frame =new InventoryManagerFrame("Inventory Manager",100,100,400,600);
                frame.setVisible(true);
            }
        });
    }
}
