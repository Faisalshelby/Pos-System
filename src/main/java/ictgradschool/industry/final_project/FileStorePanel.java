package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileStorePanel extends JPanel implements ActionListener {

    JButton closeFileStore;

    JButton openInventory;

    JButton openPointOfSale;

    public FileStorePanel(){

        setBackground(Color.WHITE);
        this.closeFileStore = new JButton("Exit");
        this.openInventory = new JButton("Open InventoryTableModelAdaptor Manager");
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
            JComponent c = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(c);
            win.dispose();
        } else if (e.getSource() == openInventory) {
             InventoryManagerFrame frame =new InventoryManagerFrame("InventoryTableModelAdaptor Manager",100,100,400,600);
            frame.setVisible(true);
            //TODO Add functionalities related to the selected file

        } else if (e.getSource() == openPointOfSale) {
            PointOfSaleFrame frame = new PointOfSaleFrame("Point Of Sale",100,100,400,600);
            frame.setVisible(true);
        }
    }
}
