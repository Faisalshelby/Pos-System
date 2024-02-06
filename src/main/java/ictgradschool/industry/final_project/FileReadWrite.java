package ictgradschool.industry.final_project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReadWrite {

//TODO read the CSV file selected by the user,
// returned by filechooser() and return a products array and
// also write function to input a product list and save a csv file

public List<Products> fileRead(String filename){
List<Products> productsList = new ArrayList<>();
    String line = "";
    String[] product;
    try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {

        while (((line = reader.readLine())!=null)){
            line = reader.readLine();
            product = line.split(",");
            productsList.add(new Products(product[0], product[1],
                    product[2],Double.parseDouble(product[3]),
                    Integer.parseInt(product[4])));
            System.out.println(product[0] + ", Name=" + product[1] + ", Description=" + product[2] + ", Price = " + product[3] + ", Quantity " + product[4]);
        }

    } catch (FileNotFoundException fne) {
        System.out.println("Error : File not found");
    } catch (IOException ioe) {
        System.out.println("Error : IOException");
    }
    return productsList;
}

public void fileWrite(String filename,List<Products> productsList){
    List<Products> products = productsList;
    char delimeter = ',';
    String dir = "./src/main/resources/";
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(dir+filename))){
        writer.write("PRODUCT ID" +delimeter+ "PRODUCT NAME"+delimeter+"PRODUCT DESCRIPTION"+delimeter+"PRODUCT PRICE"+delimeter+"PRODUCT QUANTITY");
        writer.newLine();
        if (products!=null){
        for (int i = 0; i < products.size(); i++) {
            writer.write(products.get(i).getId() +delimeter+
                    products.get(i).getName()+delimeter+
                    products.get(i).getDescription()+delimeter+
                    products.get(i).getPrice()+delimeter+
                    products.get(i).getQuantity());
            writer.newLine();
        }
        }
    }catch (IOException e){
        System.out.println("INCORRECT FILE");
    }
}

}