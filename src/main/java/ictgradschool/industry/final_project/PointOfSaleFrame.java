package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/** POINT OF SALE
* The point of sale frame calls the POS panel which is the selling window of the app
* **/

public class PointOfSaleFrame extends JFrame{
public List<Products> productsList;
public String filename;
public PointOfSaleFrame(String title, int x , int y, int width, int height, List<Products> productsList,String filename){
    this.productsList = productsList;
    this.filename = filename;
    setTitle(title);
    setBounds(x,y,width,height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    PointOfSalePanel frameContent = new PointOfSalePanel(this.productsList,filename);
    Container visibleArea = getContentPane();
    visibleArea.add(frameContent);
}

}