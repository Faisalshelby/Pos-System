package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FileStorePanel extends JPanel implements ActionListener {

    JButton closeFileStore;

    JButton openInventory;

    JButton openPointOfSale;
    List<Products> productsList;
    public FileStorePanel(List<Products> productsList){
        this.productsList = productsList;
        setBackground(Color.WHITE);
        this.closeFileStore = new JButton("Exit");
        this.openInventory = new JButton("Open Inventory Manager");
        this.openPointOfSale = new JButton("Open Point Of Sale");


        this.add(openInventory);
        this.add(openPointOfSale);
        this.add(closeFileStore);

        openInventory.addActionListener(this);
        openPointOfSale.addActionListener(this);
        closeFileStore.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeFileStore){
            closeCurrentWindow(e);
        } else if (e.getSource() == openInventory) {
            closeCurrentWindow(e);
             InventoryManagerFrame frame =new InventoryManagerFrame("Inventory Manager",100,100,800,800,this.productsList);
            frame.setVisible(true);

        } else if (e.getSource() == openPointOfSale) {
            PointOfSaleFrame frame = new PointOfSaleFrame("Point Of Sale",100,100,800,800,this.productsList);
            frame.setVisible(true);
        }
    }
public void closeCurrentWindow(ActionEvent e){
    JComponent c = (JComponent) e.getSource();
    Window win = SwingUtilities.getWindowAncestor(c);
    win.dispose();
    }
}
