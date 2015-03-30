package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Pregunta;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class PreguntaDAO {

    private Log log = LogFactory.getLog(PreguntaDAO.class);

    public PreguntaDAO() {
    }


    public Pregunta buscarPorId(Long idPregunta, boolean bloquear) throws ExcepcionInfraestructura {

        Pregunta rol = null;

        try {
            if (bloquear) {
                rol = (Pregunta)HibernateUtil.getSession().load(Pregunta.class, idPregunta,  LockMode.UPGRADE);
            } else {
                rol = (Pregunta)HibernateUtil.getSession().load(Pregunta.class, idPregunta);
            }
        } catch (HibernateException ex) {
            
            throw new ExcepcionInfraestructura(ex);
        }
        return rol;
    }


    public Collection buscarTodos() throws ExcepcionInfraestructura {

        Collection roles;

        try {
            roles = HibernateUtil.getSession().createCriteria(Pregunta.class).list();
        } catch (HibernateException e) {
            
            throw new ExcepcionInfraestructura(e);
        }
        return roles;
    }


    public Collection buscarPorEjemplo(Pregunta rol) throws ExcepcionInfraestructura {

        Collection roles;
 
        try {
            Criteria criteria = HibernateUtil.getSession() .createCriteria(Pregunta.class);
            roles = criteria.add(Example.create(rol)).list();
        } catch (HibernateException e) {
           
            throw new ExcepcionInfraestructura(e);
        }
        return roles;
    }


    public void hazPersistente(Pregunta rol)throws ExcepcionInfraestructura {

        try {
            HibernateUtil.getSession().saveOrUpdate(rol);
        } catch (HibernateException e) {
            
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Pregunta rol) throws ExcepcionInfraestructura {

        try {
            HibernateUtil.getSession().delete(rol);
        } catch (HibernateException e) {
            
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existePregunta(String nombre) throws ExcepcionInfraestructura {

        try {

            List results = HibernateUtil.getSession().createCriteria(Pregunta.class).add(Restrictions.eq("nombre", nombre)).list();
			int resultado = results.size();
		
            if (resultado == 0) {
               return false;
            }
            
            return true;

        } catch (HibernateException ex) {
 
            throw new ExcepcionInfraestructura(ex);
        }
    }

    public Collection buscarTodos(int idSeccion) throws ExcepcionInfraestructura {
        Collection roles;

        try {

            roles = HibernateUtil.getSession().createCriteria(Pregunta.class).add(Restrictions.eq("idSeccion", idSeccion)).list();


        } catch (HibernateException ex) {
            
            throw new ExcepcionInfraestructura(ex);
        }
        return roles;
    }

}
