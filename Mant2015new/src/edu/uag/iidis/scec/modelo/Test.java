package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase es usada para representar un rol de un
 * usuario. 
 *
 * <p><a href="Test.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Test extends ClaseBase implements Serializable {

    private Long id;
    private String nameTest;

    public Test() {
        
    }

    public Test(Long id){
        this.id = id;
    }

    public Test(String nameTest){
        this.nameTest=nameTest;
    }

    /**
     * Regresa el id del rol.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id del rol.
     * @return void
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    /**
     * Regresa la descripción del rol.
     * @return String
     */
    public String getNombre() {
        return this.nameTest;
    }

    /**
     * Establece la descripción del rol.
     * @return void
     */
    public void setNombre(String nameTest) {
        this.nameTest = nameTest;
    }
 
}
