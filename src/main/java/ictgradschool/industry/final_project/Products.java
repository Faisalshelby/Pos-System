package ictgradschool.industry.final_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Products {

    public String id;
    public String name;
    public String description;
    public double price;
    public int quantity;

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

    public String generateAlphaNumeric() {
        char[] alphanumeric = "0123456789QWERTYUIOPASDFGHJKLMNBVCXZ".toCharArray();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int index = (int) (Math.random() * alphanumeric.length);
            builder.append(alphanumeric[index]);

        }
        return builder.toString();
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