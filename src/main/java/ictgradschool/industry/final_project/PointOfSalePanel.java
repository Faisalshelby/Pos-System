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


public class PointOfSalePanel extends JPanel implements ActionListener{

    JButton checkout;
    JButton exit;
        public List<Products> productsList;
        public List<Products> checkoutList = new ArrayList<>();
        int clickCount;
        Map<Integer, Integer> rowClickCountMap = new HashMap<>();
        //int cartItems = 0;
        //JLabel cart;
    int selectedRow;
    PointOfSaleTableModelAdapter model;
    public PointOfSalePanel(List<Products> productsList){
        this.productsList = productsList;
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
                    System.out.println(productsList.get(selectedRow).getQuantity());
                    checkoutList.add(getRowData(table,selectedRow));


                }
            }

        });

            System.out.println(checkoutList);


        JScrollPane tablePane = new JScrollPane(table);

        //this.add(table);
        this.checkout = new JButton("CheckOut");
        this.exit= new JButton("Exit Point of Sale");
        //this.add(new JLabel("cart" + cartItems));
        checkout.addActionListener(this);
        exit.addActionListener(this);
        this.add(tablePane);
        this.add(checkout);
        this.add(exit);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit){
            JComponent c = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(c);
            win.dispose();
        } else if (e.getSource() == checkout) {
            //TODO Receipt
            RecieptFrame frame = new RecieptFrame("Receipt",100,100,800,800,this.checkoutList);
            frame.setVisible(true);
        }

    }
    public Products getRowData(JTable table,int row){
        int columns = 5;
        Object[] productsString = new Object[columns];
        for (int i = 0; i < columns; i++) {
            productsString[i]= table.getValueAt(row,i);
            //System.out.println(productsString[i]);
        }
        Products rowData= new Products(
                (String) productsString[0],
                (String) productsString[1],
                (String) productsString[2],
                Double.parseDouble(String.valueOf(productsString[3])),
                1
        );
        System.out.println(rowData.getId() +" "+ rowData.getName() +" "+ rowData.getDescription() +" "+ rowData.getPrice() +" "+ rowData.getQuantity());
   return rowData;
    }
}

