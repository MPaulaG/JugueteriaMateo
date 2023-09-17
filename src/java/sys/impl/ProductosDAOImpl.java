package sys.impl;

import java.util.List;
import sys.dao.ProductosDAO;
import sys.modelo.Productos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sys.util.HibernateUtil;

public class ProductosDAOImpl implements ProductosDAO {

    @Override
    public List<Productos> select() {
        List<Productos> productos = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        String hql = "FROM Productos";
        try {
            productos = session.createQuery(hql).list();
            trans.commit();
          
        } catch (Exception ex) {
            ex.printStackTrace();
            trans.rollback();
        }finally{
             session.close(); 
        }
        return productos;

    }

    @Override
    public void insert(Productos productos) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(productos);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();

        }

    }

    @Override
    public void update(Productos productos) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(productos);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public void delete(Productos productos) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(productos);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

}
