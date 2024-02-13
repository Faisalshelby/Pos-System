package ictgradschool.industry.final_project;

/**
 * The Product observer Interface is an observer which tells us whenever a product is modified, added or removed**/
public interface ProductObserver {
    void productChanged(Products p);
}
