/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.FramePrincipal;

/**
 *
 * @author cristian
 * @crramirezma
 */
public class ValidarLogin {
    
    private Sistema sistema=FramePrincipal.sistema;
    
    public ValidarLogin() {
    }
    
    public String verificarLogin(Usuario usuario){
        if(!verificarLongitudNombre(usuario.getNombre())){
            return("Longitud nombre incorrecta");
        }
        if(!verificarLongitudPassword(usuario.getPassword())){
            return("Longitud contraseña incorrecta");
        }
        for(Usuario user:sistema.getUsuarios()){
            if(user.getNombre().equals(usuario.getNombre())
                    &&user.getPassword().equals(usuario.getPassword())){
                return("Bienvenido");
            }
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
