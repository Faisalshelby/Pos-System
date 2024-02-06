package ictgradschool.industry.final_project;

import javax.swing.*;
import java.util.List;

public class RecieptPanel extends JPanel {

    public List<Products> checkoutList;
    public RecieptPanel(List<Products> checkoutList){
        this.checkoutList = checkoutList;

        for (int i = 0; i < checkoutList.size(); i++) {
            this.add(new JLabel(checkoutList.get(i).name));
            this.add(new JLabel(String.valueOf(checkoutList.get(i).quantity)));
        }

    }
}
