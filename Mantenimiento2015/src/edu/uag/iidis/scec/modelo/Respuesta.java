package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


public class Respuesta extends ClaseBase implements Serializable {

    private Long id;
    private int idPregunta;
    private String nombre;
    private String valor;

    public Respuesta() {
    }

    public Respuesta(Long id){
        this.id = id;
    }

    public Respuesta(int idPregunta, String nombre, String valor){
        this.idPregunta=idPregunta;
        this.nombre=nombre;
        this.valor=valor;
    }

   
    public Long getId() {
        return this.id;
    }

 
    public void setId(Long id) {
        this.id = id;
    }


    public int getIdPregunta() {
        return this.idPregunta;
    }


    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }


    public String getNombre() {
        return this.nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return this.valor;
    }


    public void setValor(String valor) {
        this.valor = valor;
    }

}