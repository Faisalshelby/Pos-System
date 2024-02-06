package ictgradschool.industry.final_project;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class InventoryTableModelAdaptor extends AbstractTableModel {

    List<Products> productsList;
    public InventoryTableModelAdaptor(List<Products> productsList){
        this.productsList = productsList;

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
            case 0 -> "Product Name";
            case 1 -> "Quantity";
            case 2 -> "Price";
            default -> "NO COLUMN";
        };
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Products p = this.productsList.get(rowIndex);
        return switch (columnIndex){
            case 0 -> p.getName();
            case 1 -> p.getQuantity();
            case 2 -> p.getPrice();
            default -> "No Product";
        };
    }



    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return super.isCellEditable(rowIndex, columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }
}