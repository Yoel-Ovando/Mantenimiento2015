package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Respuesta;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class RespuestaDAO {

    private Log log = LogFactory.getLog(RespuestaDAO.class);

    public RespuestaDAO() {
    }


    public Respuesta buscarPorId(Long idRespuesta, boolean bloquear) throws ExcepcionInfraestructura {

        Respuesta rol = null;

        try {
            if (bloquear) {
                rol = (Respuesta)HibernateUtil.getSession().load(Respuesta.class, idRespuesta,  LockMode.UPGRADE);
            } else {
                rol = (Respuesta)HibernateUtil.getSession().load(Respuesta.class, idRespuesta);
            }
        } catch (HibernateException ex) {
            
            throw new ExcepcionInfraestructura(ex);
        }
        return rol;
    }


    public Collection buscarTodos() throws ExcepcionInfraestructura {

        Collection roles;

        try {
            roles = HibernateUtil.getSession().createCriteria(Respuesta.class).list();
        } catch (HibernateException e) {
            
            throw new ExcepcionInfraestructura(e);
        }
        return roles;
    }


    public Collection buscarPorEjemplo(Respuesta rol) throws ExcepcionInfraestructura {

        Collection roles;
 
        try {
            Criteria criteria = HibernateUtil.getSession() .createCriteria(Respuesta.class);
            roles = criteria.add(Example.create(rol)).list();
        } catch (HibernateException e) {
           
            throw new ExcepcionInfraestructura(e);
        }
        return roles;
    }


    public void hazPersistente(Respuesta rol)throws ExcepcionInfraestructura {

        try {
            HibernateUtil.getSession().saveOrUpdate(rol);
        } catch (HibernateException e) {
            
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Respuesta rol) throws ExcepcionInfraestructura {

        try {
            HibernateUtil.getSession().delete(rol);
        } catch (HibernateException e) {
            
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeRespuesta(String nombre) throws ExcepcionInfraestructura {

        try {

            List results = HibernateUtil.getSession().createCriteria(Respuesta.class).add(Restrictions.eq("nombre", nombre)).list();
			int resultado = results.size();
		
            if (resultado == 0) {
               return false;
            }
            
            return true;

        } catch (HibernateException ex) {
 
            throw new ExcepcionInfraestructura(ex);
        }
    }

    public Collection buscarTodos(int idPregunta) throws ExcepcionInfraestructura {
        Collection roles;

        try {

            roles = HibernateUtil.getSession().createCriteria(Respuesta.class).add(Restrictions.eq("idPregunta", idPregunta)).list();


        } catch (HibernateException ex) {
            
            throw new ExcepcionInfraestructura(ex);
        }
        return roles;
    }

}
