package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
* The inventory Manager Panel, takes in a product List as an input,
*  the product list is the inventory's main data source
* the inventory panel generates a Jtable of products
* the inventory panel also contains a create product button, a view product button,
* and a remove product button.
* and an exit button to close the inventory
* **/


public class InventoryManagerPanel extends JPanel implements ActionListener{

    JButton createProduct;
    JButton viewProduct;
    JButton removeProduct;

    JButton exitButton;
    JLabel productIdLabel;
    JLabel productNameLabel;
    JLabel productDescriptionLabel;
    JLabel productPriceLabel;
    JLabel productQuantityLabel;
    JTextField productIdField;
    JTextField productNameField;
    JTextField productDescriptionField;
    JTextField productPriceField;
    JTextField productQuantityField;
    List<Products> productsList;
    InventoryTableModelAdaptor model;
    public String filename;
    public InventoryManagerPanel(List<Products> productsList,String filename){
        this.productsList = productsList;
        this.filename = filename;
        model = new InventoryTableModelAdaptor(this.productsList,this.filename);
        //table model
        JTable table = new JTable();
        table.setModel(model);
        JScrollPane tablePane = new JScrollPane(table);


        //Labels
        productIdLabel = new JLabel("Product Id : ");
        productNameLabel = new JLabel("Product Name : ");
        productDescriptionLabel = new JLabel("Product Description");
        productPriceLabel = new JLabel("Product Price : ");
        productQuantityLabel = new JLabel("Product Quantity : ");

        //TextFields
        productIdField = new JTextField(25);
        productNameField = new JTextField(25);
        productDescriptionField = new JTextField(25);
        productPriceField = new JTextField(25);
        productQuantityField = new JTextField(25);

        //buttons
        createProduct = new JButton("Create Product");
        viewProduct = new JButton("View Product");
        removeProduct = new JButton("Remove Product");
        exitButton = new JButton("Exit Inventory");


        //adding elements to Panel
        this.add(tablePane);
        this.add(productIdLabel);this.add(productIdField);
        this.add(productNameLabel);this.add(productNameField);
        this.add(productDescriptionLabel);this.add(productDescriptionField);
        this.add(productPriceLabel);this.add(productPriceField);
        this.add(productQuantityLabel);this.add(productQuantityField);

        //adding buttons
        this.add(createProduct);
        this.add(viewProduct);
        this.add(removeProduct);
        this.add(exitButton);

        createProduct.addActionListener(this);
        viewProduct.addActionListener(this);
        removeProduct.addActionListener(this);
        exitButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createProduct){
            model.addProduct(createProducts());

        } else if (e.getSource() == viewProduct) {
                    viewProduct();

            } else if (e.getSource() == removeProduct) {
            for (int i = 0; i < productsList.size(); i++) {
                if (productsList.get(i).id.equals(productIdField.getText())){
                    model.removeProduct(productsList.get(i));
                    System.out.println("Product Removed");
                }
                else {
                    System.out.println("Product Does Not Exist");
                }
            }
        } else if (e.getSource() == exitButton) {
            closeCurrentWindow(e);
            FileStoreFrame frame = new FileStoreFrame("File Store",100,100,800,800,this.productsList,filename);
            frame.setVisible(true);
        }

    }


        public Products createProducts(){
                if (productIdField.getText().length() !=10){
                    JOptionPane.showMessageDialog(this, "Product Id Length must be 10 characters",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
                for (Products p : this.productsList){
                    if (p.getId().equals(productIdField.getText())){
                        JOptionPane.showMessageDialog(this, "Product Id's Cannot be same",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    return null;
                    }
                }try {
                    Integer.parseInt(productQuantityField.getText());
                    Double.parseDouble(productPriceField.getText());
                    }catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(this, "Cannot Take Characters in Integer Values",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

                Products product = new Products(
                productIdField.getText()
                ,productNameField.getText(),
                productDescriptionField.getText(),
                Double.parseDouble(productPriceField.getText()),
                Integer.parseInt(productQuantityField.getText()));

              return product;
    }
    public void viewProduct(){
        for (Products p : this.productsList){
            if(p.getId().equals(productIdField.getText())){
                productIdField.setText(p.getId());
                productNameField.setText(p.getName());
                productDescriptionField.setText(p.getDescription());
                productPriceField.setText(String.valueOf(p.getPrice()));
                productQuantityField.setText(String.valueOf(p.getQuantity()));
            }
        }
    }

    public void closeCurrentWindow(ActionEvent e){
        JComponent c = (JComponent) e.getSource();
        Window win = SwingUtilities.getWindowAncestor(c);
        win.dispose();
    }
}
