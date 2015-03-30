package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Seccion;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.SeccionDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorSecciones {
    private Log log = LogFactory.getLog(ManejadorSecciones.class);
    private SeccionDAO dao;

    public ManejadorSecciones() {
        dao = new SeccionDAO();
    }


    public Collection listarSecciones() {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

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

    public Collection listarSecciones(int idTest) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarTodos(idTest);
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void eliminarSeccion(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarSeccion(rol)");
        }
        try {
            HibernateUtil.beginTransaction();           
            Seccion rol = dao.buscarPorId(id, true);
            if (rol != null) {
              dao.hazTransitorio(rol);
            }
            HibernateUtil.commitTransaction();
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
        } finally {
            HibernateUtil.closeSession();
        }

    }

    public int crearSeccion(Seccion rol) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarSeccion(rol)");
        }

        try {
            HibernateUtil.beginTransaction();           
            
            if (dao.existeSeccion(rol.getNombre())) {
               resultado = 1; // Excepción. El nombre de rol ya existe
            } else {

               dao.hazPersistente(rol);

               resultado = 0; // Exito. El rol se creo satisfactoriamente.
            }

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepción. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }    
}
