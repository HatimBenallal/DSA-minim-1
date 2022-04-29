package edu.upc.dsa.models;

public class ListaUsuarios {

    private String apellidosU;
    private String nombreU;

    public ListaUsuarios() {}

    public ListaUsuarios( String apellidosU, String nombreU){
        this.apellidosU = apellidosU;
        this.nombreU = nombreU;
    }

    public String getApellidosU() {
        return apellidosU;
    }

    public void setApellidosU(String apellidosU) {
        this.apellidosU = apellidosU;
    }

    public String getNombreU() {
        return nombreU;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }
}

