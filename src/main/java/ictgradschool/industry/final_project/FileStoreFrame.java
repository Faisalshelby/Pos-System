package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FileStoreFrame extends JFrame {

    private List<Products> productsList;
    String filename;
    public FileStoreFrame(String title,int x , int y, int width,int height,List<Products> productsList,String filename){
        this.productsList = productsList;
        this.filename = filename;
        setTitle(title);
        setBounds(x,y,width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FileStorePanel frameContent = new FileStorePanel(this.productsList,filename);
        Container visibleArea = getContentPane();
        visibleArea.add(frameContent);
    }


}


