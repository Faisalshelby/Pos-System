package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FileStoreFrame extends JFrame {

    private List<Products> productsList;
    public FileStoreFrame(String title,int x , int y, int width,int height,List<Products> productsList){
        this.productsList = productsList;
        setTitle(title);
        setBounds(x,y,width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FileStorePanel frameContent = new FileStorePanel(this.productsList);
        Container visibleArea = getContentPane();
        visibleArea.add(frameContent);
    }


}


