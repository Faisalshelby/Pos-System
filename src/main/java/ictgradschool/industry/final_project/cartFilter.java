package ictgradschool.industry.final_project;
/**The cart Filter class constructor takes in a list of Products as an argument and an integer,
which then can be used to
group like products together
**/
public class cartFilter {
    public Products products;
    public int count;

    public cartFilter(Products products , int count){
        this.products = products;
        this.count = count;
    }
}
