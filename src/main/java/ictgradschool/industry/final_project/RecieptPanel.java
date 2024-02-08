package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class RecieptPanel extends JPanel implements ActionListener {

    public List<Products> checkoutList;
    RecieptTableModelAdapter model;

    JButton proceed;

    JButton Exit;

    JButton removeProduct;

    JButton empty;
    int selectedRow;


    public RecieptPanel(List<Products> checkoutList){

        this.checkoutList = filter(checkoutList);

        model = new RecieptTableModelAdapter(this.checkoutList);
        JTable table = new JTable();
        table.setModel(model);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRow = table.rowAtPoint(e.getPoint());
                if (selectedRow != -1){
                    model.removeProductFromCart(checkoutList.get(selectedRow));
                }
            }

        });

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

    public List<Products> filter(List<Products> productsList){
        List<cartFilter> cart = new ArrayList<>();
        List<Products> checkout = new ArrayList<>();
        Products lastSeen = null;
        int count = 0;
        for (Products p : productsList){
            if (lastSeen != null && lastSeen.id.equals(p.id)){
                count++;
                lastSeen.setQuantity(count);
                continue;
            }
            if (lastSeen != null && !(lastSeen.id.equals(p.id))){
                cart.add(new cartFilter(lastSeen,count));
                lastSeen.setQuantity(count);
                checkout.add(lastSeen);
            }
            lastSeen = p;
            count = 1;
        }
        checkout.add(lastSeen);
    return checkout;}

}
