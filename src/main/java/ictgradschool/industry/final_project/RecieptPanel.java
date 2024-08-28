package ictgradschool.industry.final_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
/**The reciept panel is the final window of the application, it consists of all the items in the cart,
 * it also has a proceed butoon which save the reciept.txt file and closes the application
 * in order to remove the product individually user has to click on the product whereas if the user wants to
 * empty the cart, there is an empty cart button which will empty the cart
 * **/
public class RecieptPanel extends JPanel implements ActionListener {

    public String filename;
    public List<Products> checkoutList;
    RecieptTableModelAdapter model;

    JButton proceed;

    JButton Exit;
    JButton empty;
    int selectedRow;
    JLabel remove;


    public RecieptPanel(List<Products> checkoutList,String filename){

        this.checkoutList = filter(checkoutList);
        this.filename = filename;
        model = new RecieptTableModelAdapter(this.checkoutList);
        JTable table = new JTable();
        table.setModel(model);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRow = table.rowAtPoint(e.getPoint());
                if (selectedRow != -1){
                    model.removeProductFromCart(checkoutList.get(selectedRow));
                }
            }

        });

        JScrollPane tablePane = new JScrollPane(table);
        proceed = new JButton("Proceed");
        remove = new JLabel("Click on the product to remove");
        empty = new JButton("Empty Cart");
        Exit = new JButton("Exit");
        this.add(remove);
        this.add(tablePane);
        this.add(proceed);
        this.add(empty);
        this.add(Exit);

        proceed.addActionListener(this);
        empty.addActionListener(this);
        Exit.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileReadWrite write = new FileReadWrite();
        if (e.getSource() == proceed){
            write.writeReceipt(checkoutList,"./src/main/resources/receipt/receipt.txt");
            System.exit(0);
            }
        else if (e.getSource() == Exit) {
            JComponent c = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(c);
            win.dispose();
        } else if (e.getSource() == empty) {
            model.emptyProductList(checkoutList);
        }

    }

    public List<Products> filter(List<Products> productsList){
        List<cartFilter> cart = new ArrayList<>();
        List<Products> checkout = new ArrayList<>();
        Products lastSeen = null;
        int count = 0;
        for (Products p : productsList){
            if (lastSeen != null && lastSeen.id.equals(p.id)){
                count++;
                lastSeen.setQuantity(count);
                continue;
            }
            if (lastSeen != null && !(lastSeen.id.equals(p.id))){
                cart.add(new cartFilter(lastSeen,count));
                lastSeen.setQuantity(count);
                checkout.add(lastSeen);
            }
            lastSeen = p;
            count = 1;
        }

        checkout.add(lastSeen);
        for (Products products: checkout){
            products.setPrice(products.getQuantity()*products.getPrice());
        }

    return checkout;}

}
