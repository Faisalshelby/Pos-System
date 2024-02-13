package ictgradschool.industry.final_project;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**The POS table model adapter class
* sets the values for the Jtable to be displayed in the
* POS panel **/

public class PointOfSaleTableModelAdapter extends AbstractTableModel {

    List<Products> productsList;
    String filename;
    public PointOfSaleTableModelAdapter(List<Products> productsList){
        this.productsList = productsList;
    }

    @Override
    public int getRowCount() {
        return productsList.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
@Override
public String getColumnName(int column){
   return switch (column){
        case 0 -> "ID";
        case 1->"Name";
        case 2->"Description";
        case 3->"Price";
        case 4->"In Stock";
        default -> "NOTHING";
   };
}
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Products p = this.productsList.get(rowIndex);
        return switch (columnIndex){
            case 0->p.getId();
            case 1->p.getName();
            case 2->p.getDescription();
            case 3->p.getPrice();
            case 4->p.getQuantity();
            default -> "0000";
        };
    }

    public void updateQuantityRemove(Products p){
        p.setQuantity(p.getQuantity() - 1);
        fireTableDataChanged();
    }
    public void addProduct(Products products){
        productsList.add(products);
        fireTableDataChanged();
    }
    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }
}
