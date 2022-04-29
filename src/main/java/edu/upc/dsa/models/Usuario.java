package edu.upc.dsa.models;

public class Usuario {
    private String nombre;
    private String apellido;
    private String email;
    private String nacimiento;
    private String cont;
    private String id;
    private int coins;

    public Usuario(String nombre) {

    }

    public Usario(String nombre, String apellido, String email, String nacimiento, String cont, String id, int coins) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nacimiento = nacimiento;
        this.cont = cont;
        this.id = id;
        this.coins = 50;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

}
