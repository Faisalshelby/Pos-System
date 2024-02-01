package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class PointOfSalePanel extends JPanel implements ActionListener{

    JButton checkout;
    JButton exit;
    List<Products> productsList = new ArrayList<>();
    public PointOfSalePanel(){
        productsList.add(new Products(1,"Qwerty","Sample",3.99,87));
        setBackground(Color.WHITE);

        for (int i = 0; i < productsList.size(); i++) {

            this.add(new JLabel(productsList.get(i).name));
            //TODO add to cart
            this.add(new JButton("Add to Cart"));
        }

        this.checkout = new JButton("CheckOut");
        this.exit= new JButton("Exit Point of Sale");
        checkout.addActionListener(this);
        exit.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit){
            JComponent c = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(c);
            win.dispose();
        } else if (e.getSource() == checkout) {
            //TODO Receipt

        }

    }
}

