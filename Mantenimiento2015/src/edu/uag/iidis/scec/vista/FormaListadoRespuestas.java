package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


public final class FormaListadoRespuestas extends ValidatorForm {

    private Collection roles;
    private int contador;
    private int idPregunta;

    public void setIdPregunta(int idPregunta){
        this.idPregunta = idPregunta;
    }

    public int getIdPregunta(){
        return this.idPregunta;
    }

    public void setRespuestas(Collection roles) {
        this.roles = roles;
        if (roles != null) {
          this.contador = roles.size();
        } else
          this.contador = -1;
    }

    public Collection getRespuestas() {
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
