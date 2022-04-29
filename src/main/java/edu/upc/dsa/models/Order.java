package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class Order {

    private String userID;

    private List<LP> productQuant;


    public Order() {

        productQuant = new LinkedList<>();
    }


    public void addLP(String product,int quant){

        productQuant.add(new LP(product,quant));
    }

    public List<LP> getProductQuant(){

        return this.productQuant;
    }

    public void addUser(String u){

        this.userID = u;
    }

    public String getUser(){

        return userID;
    }
}
