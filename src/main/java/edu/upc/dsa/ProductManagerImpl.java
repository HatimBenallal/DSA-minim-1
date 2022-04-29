package edu.upc.dsa;

import edu.upc.dsa.models.*;

import java.util.*;

import org.apache.log4j.Logger;

public class ProductManagerImpl implements ProductManager {
    //instancia
    private static ProductManagerImpl instance;
    //logger
    final static Logger logger = Logger.getLogger(ProductManagerImpl.class);

    //contenidors
    private List<Product> productsList;
    private Queue<Order> orderQueue;
    HashMap<String,User> userByID;

    private ProductManagerImpl() {
        productsList = new LinkedList<>();
        orderQueue = new ArrayDeque<>();
        userByID = new HashMap<>();
    }

    public static ProductManagerImpl getInstance() {
        if (instance==null)
            instance = new ProductManagerImpl();
        return instance;
    }
    //
    public int productSize(){
        int s = productsList.size();
        logger.info("Products: " + s);
        return s;
    }

    public List<Product> getProductsList() {
        return productsList;
    }


    @Override
    public List<Product> getListProductsByPrice() {
        productsList.sort(Comparator.comparingDouble(Product::getPrice));
        return productsList;
    }

    @Override
    public List<Product> getListProductsBySells(){
        productsList.sort(Comparator.comparingDouble(Product::getNumSells).reversed());
        return productsList;
    }
    @Override
    public void addProduct(String id, double price){ productsList.add(new Product(id,price)); }

    private int getProduct(String id){
        int product = -1;
        for (Product p: productsList) {
            if(p.getId().equals(id)) {
                product = productsList.indexOf(p);
                return product;
            }
        }
        return product;
    }

    @Override
    public void placeOrder(Order o,String u){
        o.addUser(u);
        orderQueue.add(o);
    }
    @Override
    public Order deliverOrder() {
        Order o = orderQueue.poll();
        User u = userByID.get(o.getUser());
        int index;
        for (LP lp: o.getProductQuant()) {
            index = getProduct(lp.getProductID());
            if(index == -1)
                logger.warn("Product null");
            else {
                productsList.get(index).addNumSells(lp.getQuantity());
                logger.info("Product: " + productsList.get(index).getId() + " -> " + productsList.get(index).getNumSells());
            }
        }
        return o;
    }
}