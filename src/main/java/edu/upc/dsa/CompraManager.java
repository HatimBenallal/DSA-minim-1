package edu.upc.dsa;

import java.util.List;
import edu.upc.dsa.models.*;

public interface CompraManager {


    public void addObjeto(String nombre, double precio);
    public List<Objeto> getListObjetoPorPrecio();




    public List<Usuario> listaUsuariosApellidos();

    List<Usuario> listaUsuarioApellido();

    public Usuario addUsuario(String nombreUsuario);
    public Usuario addUsuario(Usuario usuario);

    void addObjeto(String nombre, int precio, String desc);

    void hechaCompra(Compra c, String u);
}
