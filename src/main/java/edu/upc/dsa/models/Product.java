package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Product {

    private String id;
    private double price;
    private int numSells;

    public Product(String id, double price) {
        this.id = id;
        this.price = price;
        this.numSells = 0;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id=id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumSells(int numSells) {
        this.numSells = numSells;
    }

    public int getNumSells() {
        return numSells;
    }

    public void addNumSells(int sells){
        this.numSells += sells;
    }

    //@Override
    //public String toString() {
       // return "Product [id="+id+", price=" + price + "]";
    //}

}