package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Pregunta;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.PreguntaDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorPreguntas {
    private Log log = LogFactory.getLog(ManejadorPreguntas.class);
    private PreguntaDAO dao;

    public ManejadorPreguntas() {
        dao = new PreguntaDAO();
    }


    public Collection listarPreguntas() {
        Collection resultado;

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarTodos();
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public Collection listarPreguntas(int idSeccion) {
        Collection resultado;

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarTodos(idSeccion);
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void eliminarPregunta(Long id) {

        try {
            HibernateUtil.beginTransaction();           
            Pregunta rol = dao.buscarPorId(id, true);
            if (rol != null) {
              dao.hazTransitorio(rol);
            }
            HibernateUtil.commitTransaction();
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
     
        } finally {
            HibernateUtil.closeSession();
        }

    }

    public int crearPregunta(Pregunta pregunta) {

        int resultado;

        try {
            HibernateUtil.beginTransaction();           
            
            if (dao.existePregunta(pregunta.getNombre())) {
               resultado = 1; 
            } else {

               dao.hazPersistente(pregunta);

               resultado = 0; 
            }

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            resultado = 2;   
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }    
}
