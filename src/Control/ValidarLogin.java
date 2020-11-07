/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

//import Entidad.Sistema;
import Entidad.Usuario;
//import Frontera.FramePrincipal;
import DAO.UsuarioDAO;
/**
 *
 * @author cristian
 * @crramirezma
 */
public class ValidarLogin {
    
    //private Sistema sistema=FramePrincipal.sistema;
    private UsuarioDAO dao=new UsuarioDAO();
    
    public ValidarLogin() {
    }
    
    public String verificarLogin(Usuario usuario){
        if(!verificarLongitudNombre(usuario.getNombre())){
            return("Longitud nombre incorrecta");
        }
        if(!verificarLongitudPassword(usuario.getPassword())){
            return("Longitud contraseña incorrecta");
        }
        if(dao.leer(usuario)!=null){
            return("Bienvenido");
        }
        return ("Datos incorrectos");
    }
    public boolean verificarLongitudNombre(String nombre){
        if(nombre.length()>1&&nombre.length()<=6){
            return true;
        }
        return false;
    }
    public boolean verificarLongitudPassword(String password){
        if(password.length()>=3&&password.length()<6)
            return true;
        return false;
    }
}
