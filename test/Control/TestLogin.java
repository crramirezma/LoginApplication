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
public class TestLogin {
    
    private static ValidarLogin validarLogin= new ValidarLogin();
    
    private String LONG_NOMBRE_INCORRECTA="Longitud nombre incorrecta"
            , LONG_PASSWORD_INCORRECTA="Longitud contraseña incorrecta"
            ,DATOS_INCORRECTOS="Datos incorrectos"
            ,USUARIO_AUTORIZADO="Bienvenido";
    
    public TestLogin() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        UsuarioDAO dao=new UsuarioDAO();
        Usuario user;
        
        for(int i=0;i<3;i++){
            user=new Usuario();
            user.setNombre("Carl"+i);
            user.setPassword("1234"+i);
            
            System.out.println(user.getNombre());
            System.out.println(user.getPassword());
            System.out.println("------------------");
            dao.crear(user);
        }
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
    
    @Test
    public void testLongitudNombre(){
        Usuario u=new Usuario();
        u.setNombre("R");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLogin(u),LONG_NOMBRE_INCORRECTA);
        
        //segundo dato de prueba
        u.setNombre("Roberto");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLogin(u),LONG_NOMBRE_INCORRECTA);
        
    }
    
    @Test
    public void testLongitudContrasena(){
        Usuario u=new Usuario();
        u.setNombre("Pepe");
        u.setPassword("12");
        assertEquals(validarLogin.verificarLogin(u),LONG_PASSWORD_INCORRECTA);
        
        //segundo dato de prueba
        u.setNombre("Pepe");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLogin(u),LONG_PASSWORD_INCORRECTA);
    }
    
    @Test
    public void testNombre(){
        Usuario u=new Usuario();
        //toca probar con usuario existentes dentro de la base, por lo que usare
        //alguno que ya halla creado yo, recalco, yo no cree los mismos que el profe
        u.setNombre("Carl0");
        u.setPassword("12340");
        assertEquals(validarLogin.verificarLogin(u),DATOS_INCORRECTOS);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
