package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Respuesta;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.RespuestaDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorRespuestas {
    private Log log = LogFactory.getLog(ManejadorRespuestas.class);
    private RespuestaDAO dao;

    public ManejadorRespuestas() {
        dao = new RespuestaDAO();
    }


    public Collection listarRespuestas() {
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

    public Collection listarRespuestas(int idPregunta) {
        Collection resultado;

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarTodos(idPregunta);
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void eliminarRespuesta(Long id) {

        try {
            HibernateUtil.beginTransaction();           
            Respuesta rol = dao.buscarPorId(id, true);
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

    public int crearRespuesta(Respuesta respuesta) {

        int resultado;

        try {
            HibernateUtil.beginTransaction();           
            
            if (dao.existeRespuesta(respuesta.getNombre())) {
               resultado = 1; 
            } else {

               dao.hazPersistente(respuesta);

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
