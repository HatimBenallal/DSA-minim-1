package edu.upc.dsa;

import edu.upc.dsa.models.Product;

import java.util.List;
import edu.upc.dsa.models.*;

public interface ProductManager {


    public void addProduct(String id, double price);
    public List<Product> getListProductsByPrice();
    public List<Product> getListProductsBySells();
    public Order deliverOrder();
    public void placeOrder(Order o,String u);
}
