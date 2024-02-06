package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class PointOfSaleFrame extends JFrame{
public List<Products> productsList;
public PointOfSaleFrame(String title, int x , int y, int width, int height, List<Products> productsList){
    this.productsList = productsList;
    setTitle(title);
    setBounds(x,y,width,height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    PointOfSalePanel frameContent = new PointOfSalePanel(this.productsList);
    Container visibleArea = getContentPane();
    visibleArea.add(frameContent);
}

}