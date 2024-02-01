package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;


public class PointOfSaleFrame extends JFrame{

public PointOfSaleFrame(String title,int x , int y, int width,int height){
    setTitle(title);
    setBounds(x,y,width,height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    PointOfSalePanel frameContent = new PointOfSalePanel();
    Container visibleArea = getContentPane();
    visibleArea.add(frameContent);
}

}