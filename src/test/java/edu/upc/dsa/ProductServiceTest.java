package edu.upc.dsa;

import edu.upc.dsa.models.Order;
import edu.upc.dsa.models.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductServiceTest {
    ProductManager pm;
    @Before
    public void setUp(){
        pm=ProductManagerImpl.getInstance();
        pm.addProduct("donetes", 1.5);
        pm.addProduct("donuts", 1.2);
        pm.addProduct("cola",2);
        Order o = new Order();
        o.addLP("donetes",2);
        o.addLP("cola",1);
        pm.placeOrder(o,"31567455H");
        Order o2 = new Order();
        o2.addLP("donuts",3);
        o2.addLP("donetes",2);
        o2.addLP("cola",4);
        pm.placeOrder(o2,"57987321K");
    }

    @Test
    public void testGetProducts(){
        List<Product> products = pm.getListProductsByPrice();
        assertEquals("donuts", products.get(0).getId());
        assertEquals("donetes", products.get(1).getId());
        assertEquals("cola", products.get(2).getId());
        Order o1 = pm.deliverOrder();
        Order o2 = pm.deliverOrder();
        assertEquals("31567455H", o1.getUser());
        assertEquals("57987321K",o2.getUser());
        products = pm.getListProductsBySells();
        assertEquals("cola", products.get(0).getId());
        assertEquals("donetes", products.get(1).getId());
        assertEquals("donuts", products.get(2).getId());
    }
}
