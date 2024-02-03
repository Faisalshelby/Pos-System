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

    public PointOfSalePanel(){

        JTable table = new JTable();
        FileReadWrite readWrite = new FileReadWrite();
        JScrollPane tablePane = new JScrollPane(table);
        table.setModel(new PointOfSaleTableModelAdapter(readWrite.fileRead("./src/main/resources/hello.csv")));
        this.add(table);
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

