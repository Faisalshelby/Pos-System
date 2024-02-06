package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class InventoryManagerFrame extends JFrame{
    public List<Products> productsList;
    public InventoryManagerFrame(String title , int x, int y , int width, int height, List<Products> productsList){
        this.productsList = productsList;
        setTitle(title);
        setBounds(x,y,width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InventoryManagerPanel frameContent = new InventoryManagerPanel(this.productsList);
        Container visibleArea = getContentPane();
        visibleArea.add(frameContent);
//        pack();
    }

}