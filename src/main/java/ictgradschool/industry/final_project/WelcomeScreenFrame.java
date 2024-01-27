package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;


public class WelcomeScreenFrame extends JFrame{

    public WelcomeScreenFrame(String title,int x , int y, int width,int height){
        setTitle(title);
        setBounds(x,y,width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WelcomeScreenPanel frameContent = new WelcomeScreenPanel();
        Container visibleArea = getContentPane();
        visibleArea.add(frameContent);
    }



}