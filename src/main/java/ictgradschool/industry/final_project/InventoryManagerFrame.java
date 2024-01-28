package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;


public class InventoryManagerFrame extends JFrame{
    public InventoryManagerFrame(String title ,int x,int y , int width,int height){
        setTitle(title);
        setBounds(x,y,width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InventoryManagerPanel frameContent = new InventoryManagerPanel();
        Container visibleArea = getContentPane();
        visibleArea.add(frameContent);
    }

}