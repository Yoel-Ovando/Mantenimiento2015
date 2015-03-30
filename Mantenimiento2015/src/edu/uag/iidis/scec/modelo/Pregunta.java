package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


public class Pregunta extends ClaseBase implements Serializable {

    private Long id;
    private int idSeccion;
    private String nombre;

    public Pregunta() {
    }

    public Pregunta(Long id){
        this.id = id;
    }

    public Pregunta(int idSeccion, String nombre){
        this.idSeccion=idSeccion;
        this.nombre=nombre;
    }

   
    public Long getId() {
        return this.id;
    }

 
    public void setId(Long id) {
        this.id = id;
    }


    public int getIdSeccion() {
        return this.idSeccion;
    }


    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }


    public String getNombre() {
        return this.nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
