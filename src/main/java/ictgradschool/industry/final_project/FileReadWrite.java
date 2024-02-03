package ictgradschool.industry.final_project;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
           // System.out.println(product[0] + ", Name=" + product[1] + ", Description=" + product[2] + ", Price = " + product[3] + ", Quantity " + product[4]);
        }

    } catch (FileNotFoundException fne) {
        System.out.println("Error : File not found");
    } catch (IOException ioe) {
        System.out.println("Error : IOException");
    }
    return productsList;
}


}