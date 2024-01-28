package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InventoryManagerPanel extends JPanel implements ActionListener{

    JButton createProduct;
    JButton modifyProduct;
    JButton viewProduct;
    JButton removeProduct;
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

    List<Products> productsList = new ArrayList<>();
    public InventoryManagerPanel(){

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
        modifyProduct = new JButton("Modify Product");
        viewProduct = new JButton("View Product");
        removeProduct = new JButton("Remove Product");

        //adding elements to Panel
        this.add(productIdLabel);this.add(productIdField);
        this.add(productNameLabel);this.add(productNameField);
        this.add(productDescriptionLabel);this.add(productDescriptionField);
        this.add(productPriceLabel);this.add(productPriceField);
        this.add(productQuantityLabel);this.add(productQuantityField);

        //adding buttons
        this.add(createProduct);
        this.add(modifyProduct);
        this.add(viewProduct);
        this.add(removeProduct);

        createProduct.addActionListener(this);
        modifyProduct.addActionListener(this);
        viewProduct.addActionListener(this);
        removeProduct.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createProduct){
          createProducts();
        } else if (e.getSource() == modifyProduct) {
            productsList.remove(productsList.get(Integer.parseInt(productIdField.getText())));
            Products product = new Products(Integer.parseInt(productIdField.getText()
            ),productNameField.getText(),
                    productDescriptionField.getText(),
                    Double.parseDouble(productPriceField.getText()),
                    Integer.parseInt(productIdField.getText()));
            productsList.add(Integer.parseInt(productIdField.getText()),product);
            } else if (e.getSource() == viewProduct) {
                try {
                    viewProduct();
                }catch (Exception exception){
                    System.out.println("Product not found");
                }
            }


            }


        public void createProducts(){

                Products product = new Products(
                Integer.parseInt(productIdField.getText()
                ),productNameField.getText(),
                productDescriptionField.getText(),
                Double.parseDouble(productPriceField.getText()),
                Integer.parseInt(productIdField.getText()));
                productsList.add(product);

    }
    public void viewProduct(){
        for (Products p : productsList){
            if(p.getId() == Integer.parseInt(productIdField.getText())){
                productIdField.setText(String.valueOf(p.getId()));
                productNameField.setText(p.getName());
                productDescriptionField.setText(p.getDescription());
                productPriceField.setText(String.valueOf(p.getPrice()));
                productQuantityField.setText(String.valueOf(p.getQuantity()));
            }
        }
    }




    }
