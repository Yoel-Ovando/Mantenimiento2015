package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Test;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class TestDAO {

    private Log log = LogFactory.getLog(TestDAO.class);

    public TestDAO() {
    }


    public Test buscarPorId(Long idTest, boolean bloquear)
            throws ExcepcionInfraestructura {

        Test rol = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idTest + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                rol = (Test)HibernateUtil.getSession()
                                                .load(Test.class, 
                                                      idTest, 
                                                      LockMode.UPGRADE);
            } else {
                rol = (Test)HibernateUtil.getSession()
                                                .load(Test.class,
                                                      idTest);
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
                                    .createCriteria(Test.class)
                                    .list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return roles;
    }


    public Collection buscarPorEjemplo(Test rol)
            throws ExcepcionInfraestructura {


        Collection roles;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Test.class);
            roles = criteria.add(Example.create(rol)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return roles;
    }


    public void hazPersistente(Test rol)
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


    public void hazTransitorio(Test rol)
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

    public boolean existeTest(String nombreTest)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeTest(nombreTest)");
        }

        try {
			
			
//            String consultaCuentaTests =
//            "select count(*) from Test r where r.nombre=?";
//
 //           int resultado =
 //           ((Integer) HibernateUtil.getSession()
 //                          .find(consultaCuentaTests, 
 //                                nombreTest,
 //                                StringType.INSTANCE)
 //                          .iterator()
 //                          .next()).intValue();
// de acuerdo al nuevo formato
 
			String hql = "select nombre from Test where nombre = :nombre";
			
			 if (log.isDebugEnabled()) {
           		 log.debug(hql + nombreTest);
        	}
		
			Query query = HibernateUtil.getSession()
										.createQuery(hql);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< create query ok " );
        	}

			query.setParameter("nombre", nombreTest);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
        	}
			List results = query.list();
			int resultado = results.size();
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< Result size " + resultado);
        	}
            if (resultado == 0) {
               return false;
            }
            
            return true;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }


}
