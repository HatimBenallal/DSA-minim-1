package edu.upc.dsa;


import edu.upc.dsa.models.*;

import java.util.*;

import org.apache.log4j.Logger;

public class CompraManagerImpl implements CompraManager {
    //instancia
    private static CompraManagerImpl instance;
    //logger
    final static Logger logger = Logger.getLogger(ProductManagerImpl.class);

    //contenidors
    private List<Objeto> objetoList;
    private List<Compra> compraList;
    private HashMap<String, Usuario> userapellido;

    private CompraManagerImpl() {
        this.objetoList = new LinkedList<>();
        this.compraList = new LinkedList<>();
        this.userapellido = new HashMap<>();
    }

    public static CompraManagerImpl getInstance() {
        if (instance == null) {
            logger.info("New instance edu.upc.dsa.CompraManagerImpl");
            instance = new CompraManagerImpl();
        }
        return instance;
    }

    @Override
    public List<Usuario> listaUsuarioApellido() {

        List<Usuario> usuariosOrden = Arrays.asList(userapellido.values().stream().sorted(
                (s1, s2) -> s1.getApellido().compareToIgnoreCase(s2.getApellido())).toArray(Usuario[]::new));


        return usuariosOrden;
    }

    public Usuario addUsuario(String nombre, String apellido, String email, String id, String cont) {
        return this.addUsuario(new Usuario(nombre, apellido, email, id, cont));
    }



    @Override
    public void addObjeto(String nombre, double precio) {

    }

    @Override
    public List<Objeto> getListObjetoPorPrecio() {
        objetoList.sort(Comparator.comparingDouble(Objeto::getPrecio));
        return objetoList;
    }

    @Override
    public Compra hechaCompra() {
        return null;
    }

    @Override
    public void listaCompra(Compra c, String u) {

    }

    @Override
    public List<Usuario> listaUsuariosApellidos() {
        return null;
    }


    @Override
    public void addObjeto(String nombre, int precio, String desc) {
        objetoList.add(new Objeto(nombre,precio, desc));
    }

    private int getObjeto(String id) {
        int objeto = -1;
        for (Objeto obj : objetoList) {
            if (obj.getNombre().equals(id)) {
                objeto = objetoList.indexOf(obj);
                return objeto;
            }
        }
        return objeto;
    }

    @Override
    public void hechaCompra(Compra c, String u) {
        c.addUser(u);
        compraList.add(c);
    }



}

