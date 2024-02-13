package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* POS panel is the selling window of the project, it allows the user to add a product to the cart
* by clicking on the product, it takes the inventory product list as an argument and creates a Jtable,
* each time the product is added to the cart , it is removed from the inventory,
*  the Point of sale Panel has a checkout button and an exit button, the exit button saves the current cart and closes the window
* the checkout button takes the user to the receipt window
* **/

public class PointOfSalePanel extends JPanel implements ActionListener{

    JButton checkout;
    JButton exit;

        public String filename;
        public List<Products> productsList;
        public List<Products> checkoutList = new ArrayList<>();
        int clickCount;
        Map<Integer, Integer> rowClickCountMap = new HashMap<>();

    int selectedRow;
    PointOfSaleTableModelAdapter model;
    FileReadWrite write = new FileReadWrite();
    public PointOfSalePanel(List<Products> productsList,String filename){
        this.productsList = productsList;
        this.filename = filename;
        JTable table = new JTable();
         model = new PointOfSaleTableModelAdapter(this.productsList);
        table.setModel(model);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRow = table.rowAtPoint(e.getPoint());
                if (selectedRow != -1){

                    clickCount = rowClickCountMap.getOrDefault(selectedRow,0);
                    rowClickCountMap.put(selectedRow,clickCount+1);
                    clickCount = rowClickCountMap.get(selectedRow);

                    model.updateQuantityRemove(productsList.get(selectedRow));

                    if (productsList.get(selectedRow).quantity == 0){
                        productsList.remove(productsList.get(selectedRow));
                    }
                    checkoutList.add(getRowData(table,selectedRow));
                    write.fileWrite("./src/main/resources/receipt/receipt.txt",checkoutList);

                }
            }

        });


        JScrollPane tablePane = new JScrollPane(table);

        //this.add(table);
        this.checkout = new JButton("CheckOut");
        this.exit= new JButton("Exit Point of Sale");
        checkout.addActionListener(this);
        exit.addActionListener(this);
        this.add(tablePane);
        this.add(checkout);
        this.add(exit);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit){
            write.writeReceipt(checkoutList,"./src/main/resources/receipt/receipt.txt");
            closeCurrentWindow(e);
            WelcomeScreenFrame frame = new WelcomeScreenFrame("Point Of Sale",100,100,800,800);
            frame.setVisible(true);
        } else if (e.getSource() == checkout) {
            write.writeReceipt(checkoutList,"./src/main/resources/receipt/receipt.txt");
            RecieptFrame frame = new RecieptFrame("Receipt",100,100,800,800,this.checkoutList,filename);
            frame.setVisible(true);
        }

    }
    public Products getRowData(JTable table,int row){
        int columns = 5;
        Object[] productsString = new Object[columns];
        for (int i = 0; i < columns; i++) {
            productsString[i]= table.getValueAt(row,i);
        }
        Products rowData= new Products(
                (String) productsString[0],
                (String) productsString[1],
                (String) productsString[2],
                Double.parseDouble(String.valueOf(productsString[3])),
                1
        );
   return rowData;
    }

    public void closeCurrentWindow(ActionEvent e){
        JComponent c = (JComponent) e.getSource();
        Window win = SwingUtilities.getWindowAncestor(c);
        win.dispose();
    }
}

