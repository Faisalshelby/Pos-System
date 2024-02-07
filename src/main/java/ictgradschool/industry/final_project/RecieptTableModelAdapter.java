package ictgradschool.industry.final_project;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class RecieptTableModelAdapter extends AbstractTableModel {

    public List<Products> checkoutList;
    public RecieptTableModelAdapter(List<Products> checkoutList){

        this.checkoutList  = checkoutList;
    }
    @Override
    public int getRowCount() {
        return this.checkoutList.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        return switch (column){
            case 0 -> "Product Name";
            case 1 -> "Quantity";
            case 2 -> "Price";
            default -> "NOTHING";
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Products p = this.checkoutList.get(rowIndex);
        return switch (columnIndex){
            case 0 -> p.getName();
            case 1-> p.getQuantity();
            case 2 -> p.getPrice();
            default -> "NOTHING";
        };
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }

    public void removeProductFromCart(Products products){
        checkoutList.remove(products);
        fireTableDataChanged();
    }
    public void emptyProductList(List<Products> products){
        checkoutList.removeAll(products);
        fireTableDataChanged();
    }

}
