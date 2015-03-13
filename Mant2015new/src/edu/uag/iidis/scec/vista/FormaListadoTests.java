package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el registro de una nueva persona.
 *
 * @author Victor Ramos
 */
public final class FormaListadoTests extends ValidatorForm {

    private Collection tests;
    private int contador;


    public void setTests(Collection tests) {
        this.tests = tests;
        if (tests != null) {
          this.contador = tests.size();
        } else this.contador = -1;
    }

    public Collection getTests() {
        return (this.tests);
    }
  
    public int getContador() {
        return (this.contador);
    }


    public void reset(ActionMapping mapping,HttpServletRequest request) {
        contador=0;
        tests=null;
    }


    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);
        // Validaciones no cubiertas por Struts-Validator
        return errores;
    }

}
