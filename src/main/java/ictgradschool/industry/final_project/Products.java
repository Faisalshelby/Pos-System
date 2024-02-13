package ictgradschool.industry.final_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**The class Products is the main class of this project, each product in the Inventory is an instance of this class,
Each Product has its own unique ID, a name, A description, Price and the quantity, which can be set in the inventory
 **/

public class Products {

    public String id;
    public String name;
    public String description;
    public double price;
    public int quantity;

    private List<ProductObserver> obs = new ArrayList<>();

    public void addListener(ProductObserver p) {
        if (!obs.contains(p)) {
            obs.add(p);
        }
    }

    public void removeListener(ProductObserver p) {
        obs.remove(p);
    }

    private void notifyObservers() {
        for (ProductObserver ob : obs) {
            ob.productChanged(this);
        }
    }

    public Products(String id,String name,String description,double price,int quantity){

        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(String id) {
        this.id = id;
        notifyObservers();
    }

    public void setName(String name) {
        this.name = name;
        notifyObservers();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return id == products.id && Double.compare(price, products.price) == 0 && quantity == products.quantity && Objects.equals(name, products.name) && Objects.equals(description, products.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, quantity);
    }
}