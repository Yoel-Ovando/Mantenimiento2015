package edu.uag.iidis.scec.vista;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



public final class FormaEliminarRespuesta extends ValidatorForm {

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return (this.id);
    }


    public void reset(ActionMapping mapping, HttpServletRequest request) {
        id= new Long(0);
    }


    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errores = super.validate(mapping, request);
        return errores;
    }

}
