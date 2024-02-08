package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InventoryManagerPanel extends JPanel implements ActionListener{

    JButton createProduct;
    JButton modifyProduct;
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
        model = new InventoryTableModelAdaptor(productsList);
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
        modifyProduct = new JButton("Modify Product");
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
        this.add(modifyProduct);
        this.add(viewProduct);
        this.add(removeProduct);
        this.add(exitButton);

        createProduct.addActionListener(this);
        modifyProduct.addActionListener(this);
        viewProduct.addActionListener(this);
        removeProduct.addActionListener(this);
        exitButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createProduct){
            model.addProduct(createProducts());

        } else if (e.getSource() == modifyProduct) {
            if (productIdField.getText()!=null){
                viewProduct();
            }
            Products p = createProducts();
            for (Products products: this.productsList){
                if (products.equals(p)){
                    System.out.println("No changes Made");
                }
                else {
                    products =p;
                }
            }

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
                    System.out.println("INVALID ID");
                }
                Products product = new Products(
                productIdField.getText()
                ,productNameField.getText(),
                productDescriptionField.getText(),
                Double.parseDouble(productPriceField.getText()),
                Integer.parseInt(productQuantityField.getText()));
               //this.productsList.add(product);

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
