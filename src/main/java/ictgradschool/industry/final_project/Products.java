package ictgradschool.industry.final_project;

import java.util.List;
import java.util.Objects;

public class Products {

    public int id;
    public String name;
    public String description;
    public double price;
    public int quantity;

    public Products(int id,String name,String description,double price,int quantity){

        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;

    }

    public int getId() {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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