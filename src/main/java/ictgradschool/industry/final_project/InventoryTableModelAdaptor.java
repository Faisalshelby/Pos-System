package ictgradschool.industry.final_project;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
* The inventory Table model adapter takes in the product list from the file read as an argument,
* sets the values for the Jtable to be displayed in the Inventory
* **/


public class InventoryTableModelAdaptor extends AbstractTableModel implements ProductObserver {

    List<Products> productsList;
    FileReadWrite write = new FileReadWrite();
    String filename;
    public InventoryTableModelAdaptor(List<Products> productsList,String filename){
        this.productsList = productsList;
        this.filename = filename;
        for (Products products : productsList) {
            products.addListener(this);
        }
    }

    @Override
    public int getRowCount() {
        return productsList.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    @Override
    public String getColumnName(int column) {
        return switch (column){
            case 0 -> "Product ID";
            case 1 -> "Product Name";
            case 2 -> "Quantity";
            case 3 -> "Price";
            default -> "NO COLUMN";
        };
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Products p = this.productsList.get(rowIndex);
        return switch (columnIndex){
            case 0 -> p.getId();
            case 1 -> p.getName();
            case 2 -> p.getQuantity();
            case 3 -> p.getPrice();
            default -> "No Product";
        };
    }

    public void addProduct(Products p) {
        if (p == null){
            return;
        }
        productsList.add(p);
        p.addListener(this);
        fireTableDataChanged();
        write.fileWrite(this.filename,this.productsList);
    }
    public void removeProduct(Products p){
        productsList.remove(p);
        p.removeListener(this);
        fireTableDataChanged();
        write.fileWrite(this.filename,this.productsList);
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Products p = this.productsList.get(rowIndex);
        switch (columnIndex){
            case 0 -> p.setId((String)aValue);
            case 1 -> p.setName((String) aValue);
            case 2 -> p.setQuantity((int) aValue);
            case 3 -> p.setPrice((double) aValue);
        };
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }

    @Override
    public void productChanged(Products p) {

        fireTableDataChanged();
    }
}