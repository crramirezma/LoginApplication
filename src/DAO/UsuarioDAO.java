/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author crist
 */
public class UsuarioDAO {
    private static EntityManagerFactory entity_mf
            =Persistence.createEntityManagerFactory("LabGuisCrramirezmaPU");
    
    public void crear(Usuario user){
        EntityManager em=entity_mf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }
    
    public boolean eliminar(Usuario user){
        EntityManager em=entity_mf.createEntityManager();
        em.getTransaction().begin();
        boolean v=false;
        try {
            em.remove(user);
            em.getTransaction().commit();
            v=true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
            return v;
        }
    }
    
    public Usuario leer(Usuario par){
        EntityManager em=entity_mf.createEntityManager();
        Usuario usuario=null;
        
        Query q=em.createQuery("Select u form Usuario u "+
                "WHERE u.nombre LIKE :nombre"+
                " AND u.password LIKE :password")
                .setParameter("nombre",par.getNombre())
                .setParameter("password", par.getPassword());
                
        try {
            usuario=(Usuario) q.getSingleResult();
        }catch(NonUniqueResultException e) {
            usuario=(Usuario)q.getResultList().get(0);
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            em.close();
            return usuario;
        }           
    }
    
    public boolean actualizar(Usuario user, Usuario nuevoUsuario){
        EntityManager em=entity_mf.createEntityManager();
        em.getTransaction().begin();
        boolean v=false;
        try {
            user=leer(user);
            user.setNombre(nuevoUsuario.getNombre());
            user.setPassword(nuevoUsuario.getPassword());
            em.merge(user);
            em.getTransaction().commit();
            v=true;
            
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
            return v;
        }
    }
}
