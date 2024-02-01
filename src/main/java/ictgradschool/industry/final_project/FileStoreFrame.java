package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;

public class FileStoreFrame extends JFrame {

    public FileStoreFrame(String title,int x , int y, int width,int height){

        setTitle(title);
        setBounds(x,y,width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FileStorePanel frameContent = new FileStorePanel();
        Container visibleArea = getContentPane();
        visibleArea.add(frameContent);
    }


}


