package edu.uag.iidis.scec.vista;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


public final class FormaNuevoRespuesta extends ValidatorForm {

    private int idPregunta;
    private String nombre;
    private String valor;

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getIdPregunta() {
        return this.idPregunta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return (this.nombre);
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return (this.valor);
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        nombre=null;
        idPregunta=0;
    }


    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errores = super.validate(mapping, request);
        return errores;
    }

}
