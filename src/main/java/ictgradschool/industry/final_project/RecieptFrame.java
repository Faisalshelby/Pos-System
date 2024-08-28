package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;
import java.util.List;
/**The RecieptFrame class calls the reciept Panel which is the final window of the application**/


public class RecieptFrame extends JFrame {

    public List<Products> checkoutList;
    public String filename;
    public RecieptFrame(String title,int x , int y, int width,int height,List<Products> checkoutList,String filename){
        this.checkoutList = checkoutList;
        this.filename = filename;
        setTitle(title);
        setBounds(x,y,width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RecieptPanel frameContent = new RecieptPanel(this.checkoutList,filename);
        Container visibleArea = getContentPane();
        visibleArea.add(frameContent);
    }
}
