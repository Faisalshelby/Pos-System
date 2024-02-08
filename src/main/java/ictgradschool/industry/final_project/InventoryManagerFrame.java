package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class InventoryManagerFrame extends JFrame{
    public List<Products> productsList;
    public String filename;
    public InventoryManagerFrame(String title , int x, int y , int width, int height, List<Products> productsList,String filename){
        this.productsList = productsList;
        this.filename = filename;
        setTitle(title);
        setBounds(x,y,width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InventoryManagerPanel frameContent = new InventoryManagerPanel(this.productsList,filename);
        Container visibleArea = getContentPane();
        visibleArea.add(frameContent);
//        pack();
    }

}