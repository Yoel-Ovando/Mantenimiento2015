package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Test;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.TestDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorTests {
    private Log log = LogFactory.getLog(ManejadorTests.class);
    private TestDAO dao;

    public ManejadorTests() {
        dao = new TestDAO();
    }


    public Collection listarTests() {
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

    public void eliminarTest(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarTest(rol)");
        }
        try {
            HibernateUtil.beginTransaction();           
            Test rol = dao.buscarPorId(id, true);
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

    public int crearTest(Test rol) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarTest(rol)");
        }

        try {
            HibernateUtil.beginTransaction();           
            
            if (dao.existeTest(rol.getNombre())) {
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
