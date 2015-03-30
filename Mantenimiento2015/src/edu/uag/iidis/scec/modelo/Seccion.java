package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase es usada para representar un rol de un
 * usuario. 
 *
 * <p><a href="Seccion.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Seccion extends ClaseBase implements Serializable {

    private Long id;
    private int idTest;
    private String nombre;

    public Seccion() {
    }

    public Seccion(Long id){
        this.id = id;
    }

    public Seccion(int idTest, String nombre){
        this.idTest=idTest;
        this.nombre=nombre;
    }

   
    public Long getId() {
        return this.id;
    }

 
    public void setId(Long id) {
        this.id = id;
    }


    public int getIdTest() {
        return this.idTest;
    }


    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }


    public String getNombre() {
        return this.nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
