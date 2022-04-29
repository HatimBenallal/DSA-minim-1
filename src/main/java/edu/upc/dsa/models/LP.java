package edu.upc.dsa.models;

public class LP {

    private int quantity;
    private String productID;

    public LP(String p,int q){
        this.quantity = q;
        this.productID = p;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String pID) {
        this.productID = pID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
