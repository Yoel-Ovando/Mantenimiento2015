package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


public final class FormaListadoPreguntas extends ValidatorForm {

    private Collection roles;
    private int contador;
    private int idSeccion;

    public void setIdSeccion(int idSeccion){
        this.idSeccion = idSeccion;
    }

    public int getIdSeccion(){
        return this.idSeccion;
    }

    public void setPreguntas(Collection roles) {
        this.roles = roles;
        if (roles != null) {
          this.contador = roles.size();
        } else
          this.contador = -1;
    }

    public Collection getPreguntas() {
        return (this.roles);
    }
  
    public int getContador() {
        return (this.contador);
    }


    public void reset(ActionMapping mapping, HttpServletRequest request) {
        contador=0;
        roles=null;
    }


    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errores = super.validate(mapping, request);
        return errores;
    }

}
