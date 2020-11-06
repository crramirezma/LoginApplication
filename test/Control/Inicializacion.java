/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author crist
 */
public class Inicializacion {
    
    @Test
    public void initData(){
        UsuarioDAO dao=new UsuarioDAO();
        Usuario user;
        
        for(int i=0;i<3;i++){
            user=new Usuario();
            user.setNombre("Carlos"+i);
            user.setPassword("1234"+i);
            
            System.out.println(user.getNombre());
            System.out.println(user.getPassword());
            System.out.println("------------------");
            dao.crear(user);
        }
    }
    
    public Inicializacion() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
