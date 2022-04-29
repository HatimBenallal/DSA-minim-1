package edu.upc.dsa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CompraServiceTest {
    CompraManager cm;
    @Before
    public void setUp(){
        cm=CompraManagerImpl.getInstance();
        cm.addObjeto("vida", 1.5);
        cm.addObjeto("corona", 3);

        Compra c = new Compra();
        c.addCompra("vida");
        c.addCompra("corona");

        CompraManagerImpl.getInstance().addUsuario("Paco");
        CompraManagerImpl.getInstance().addUsuario("Julia");
        CompraManagerImpl.getInstance().addUsuario("Jose");

        public void testListarUsuariosOrdenados(){
            Assert.assertEquals("Julia",CompraManagerImpl.getInstance().listaUsuarioApellido().get(0).getApellido());
    }

    @Test

}
