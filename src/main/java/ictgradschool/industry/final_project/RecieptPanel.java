package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
//TODo repitiion should show only one
//TODO Remove product
//TODO SOME INDICATION of CART size
public class RecieptPanel extends JPanel implements ActionListener {

    public List<Products> checkoutList;
    public List<Products> finalCheckoutList;
    RecieptTableModelAdapter model;

    JButton proceed;

    JButton Exit;

    JButton removeProduct;

    JButton empty;

    public RecieptPanel(List<Products> checkoutList){

        this.checkoutList = checkoutList;
        model = new RecieptTableModelAdapter(this.checkoutList);

        JTable table = new JTable();
        table.setModel(model);


        JScrollPane tablePane = new JScrollPane(table);
        proceed = new JButton("Proceed");
        removeProduct = new JButton("Remove Product");
        empty = new JButton("Empty Cart");
        Exit = new JButton("Exit");

        this.add(tablePane);
        this.add(proceed);
        this.add(removeProduct);
        this.add(empty);
        this.add(Exit);

        proceed.addActionListener(this);
        removeProduct.addActionListener(this);
        empty.addActionListener(this);
        Exit.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == proceed){
            FileReadWrite write = new FileReadWrite();
            write.fileWrite("foo.csv",checkoutList);
            JComponent c = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(c);
            win.dispose();
            }
        else if (e.getSource() == Exit) {
            JComponent c = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(c);
            win.dispose();
        } else if (e.getSource() == empty) {
            model.emptyProductList(checkoutList);
        }

    }
}
