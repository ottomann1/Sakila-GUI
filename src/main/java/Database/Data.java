package Database;

import Business.Actor;

import javax.persistence.*;
import java.util.List;

public class Data {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    public void setData(Object o){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction= null;
        try{
            transaction= em.getTransaction();
            transaction.begin();
            em.persist(o);
            transaction.commit();
        }catch(Exception e){
            if(transaction!= null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            em.close();
        }
    }
    public void setDataQuery(String query){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction= null;
        try{
            transaction= em.getTransaction();
            transaction.begin();
            Query tempquery = em.createNativeQuery(query);
            tempquery.executeUpdate();
            transaction.commit();
        }catch(Exception e){
            if(transaction!= null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            em.close();
        }
    }

    public Object getData(Class tableClass, short id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        Object tempObject = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            tempObject = em.find(tableClass, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        return tempObject;
    }
    public Object getData(Class tableClass, byte id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        Object tempObject = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            tempObject = em.find(tableClass, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        return tempObject;
    }

    public List<Object[]> getDataListQuery(String query) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Object[]> Objects = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            Query tempQuery = em.createNativeQuery(query);
            Objects = tempQuery.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Objects;
    }


    public void deleteDataQuery(String query){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            Query tempQuery = em.createNativeQuery(query);
            tempQuery.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public void deleteEm(Class tableClass, int id){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction= null;
        Object tempObject = null;
        try{
            transaction= em.getTransaction();
            transaction.begin();
            tempObject = em.find(tableClass, id);
            em.remove(tempObject);
            transaction.commit();
        }catch(Exception e){
            if(transaction!= null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            em.close();
        }
    }
    public void updateData(Object o){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction= null;
        try{
            transaction= em.getTransaction();
            transaction.begin();
            em.merge(o);
            transaction.commit();
        }catch(Exception e){
            if(transaction!= null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            em.close();
        }
    }
}
