package edu.upc.dsa.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Compra {
    private String userID;

    private List<ListaObjetos> objetosComp;


    public Compra() {

        objetosComp = new LinkedList<>();
    }


    public void addListaObjetos(String objeto){

        objetosComp.add(new ListaObjetos(objeto));
    }

    public List<ListaObjetos> getObjetoscomp(){

        return this.objetosComp;
    }

    public void addUser(String u){

        this.userID = u;
    }

    public String getUser(){

        return userID;
    }

}
