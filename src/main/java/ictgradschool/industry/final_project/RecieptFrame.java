package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RecieptFrame extends JFrame {

    public List<Products> checkoutList;
    public RecieptFrame(String title,int x , int y, int width,int height,List<Products> checkoutList){
        this.checkoutList = checkoutList;

        setTitle(title);
        setBounds(x,y,width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RecieptPanel frameContent = new RecieptPanel(this.checkoutList);
        Container visibleArea = getContentPane();
        visibleArea.add(frameContent);
    }
}
