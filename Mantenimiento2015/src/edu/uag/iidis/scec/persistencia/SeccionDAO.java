package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Seccion;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class SeccionDAO {

    private Log log = LogFactory.getLog(SeccionDAO.class);

    public SeccionDAO() {
    }


    public Seccion buscarPorId(Long idSeccion, boolean bloquear)
            throws ExcepcionInfraestructura {

        Seccion rol = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idSeccion + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                rol = (Seccion)HibernateUtil.getSession()
                                                .load(Seccion.class, 
                                                      idSeccion, 
                                                      LockMode.UPGRADE);
            } else {
                rol = (Seccion)HibernateUtil.getSession()
                                                .load(Seccion.class,
                                                      idSeccion);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return rol;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection roles;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            roles = HibernateUtil.getSession()
                                    .createCriteria(Seccion.class)
                                    .list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return roles;
    }


    public Collection buscarPorEjemplo(Seccion rol)
            throws ExcepcionInfraestructura {


        Collection roles;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Seccion.class);
            roles = criteria.add(Example.create(rol)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return roles;
    }


    public void hazPersistente(Seccion rol)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(rol)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(rol);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Seccion rol)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(rol)");
        }

        try {
            HibernateUtil.getSession().delete(rol);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeSeccion(String nombre) throws ExcepcionInfraestructura {

        try {
			
			
//            String consultaCuentaSecciones =
//            "select count(*) from Seccion r where r.nombre=?";
//
 //           int resultado =
 //           ((Integer) HibernateUtil.getSession()
 //                          .find(consultaCuentaSecciones, 
 //                                nombreSeccion,
 //                                StringType.INSTANCE)
 //                          .iterator()
 //                          .next()).intValue();
// de acuerdo al nuevo formato
 
			/*String hql = "select nombre from secciones where nombre = :nombre";
			
			 if (log.isDebugEnabled()) {
           		 log.debug(hql + nombreSeccion);
        	}
		
			Query query = HibernateUtil.getSession()
										.createQuery(hql);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< create query ok " );
        	}

			query.setParameter("nombre", nombreSeccion);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
        	}
			List results = query.list();*/

            List results = HibernateUtil.getSession().createCriteria(Seccion.class).add(Restrictions.eq("nombre", nombre)).list();
			int resultado = results.size();
		
            if (resultado == 0) {
               return false;
            }
            
            return true;

        } catch (HibernateException ex) {
 
            throw new ExcepcionInfraestructura(ex);
        }
    }

    public Collection buscarTodos(int idTest) throws ExcepcionInfraestructura {
        Collection roles;
        if (log.isDebugEnabled()) {
            log.debug(">existeSeccion(nombreSeccion)");
        }

        try {
            String hql = "from secciones where idTest = "+idTest+";";
            roles = HibernateUtil.getSession().createCriteria(Seccion.class).add(Restrictions.eq("idTest", idTest)).list();


        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
        return roles;
    }

}
