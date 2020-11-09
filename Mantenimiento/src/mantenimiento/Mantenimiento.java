/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimiento;

import com.progra.mantenimiento.accesodatos.ConnectionFactory;
import com.progra.mantenimiento.accesodatos.MySqlConnectionFactory;
import com.progra.mantenimiento.accesodatos.PropertiesInfo;
import com.progra.mantenimiento.accesodatos.UsuarioCrud;
import com.progra.mantenimiento.modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dario
 */
public class Mantenimiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            
            UsuarioCrud usuarioCrud = new UsuarioCrud();
            Usuario usuario = new Usuario();
           /* usuario.setEmail("juangomez@gmail.com");
            usuario.setPassword("123456");
            Boolean insertado = usuarioCrud.insertarUsuario(usuario);
            if(insertado){
                System.out.println("Se inserto correctamente");
            }else{
                System.out.println("Ocurrio un error");
            }*/
            
            //buscar por email
        /*    usuario.setEmail("dario.rios@gmail.com");
            usuario = usuarioCrud.seleccionarPorEmail(usuario);
            
            System.out.println(usuario.toString());
            
            //actualizar por id el email
            usuario.setEmail("drios@una.ac.cr");
            Boolean actualizado = usuarioCrud.actualizarUsuario(usuario);
            if(actualizado){
                System.out.println("Se modifico correctamente");
            }else{
                System.out.println("Ocurrio un error");
            }*/
        
        /*Borrado fisico*/
           /* usuario.setEmail("juangomez@gmail.com");
            usuario = usuarioCrud.seleccionarPorEmail(usuario);
            
            System.out.println(usuario.toString());
             Boolean eliminado = usuarioCrud.borrarUsuario(usuario);
            if(eliminado){
                System.out.println("Se elimino correctamente");
            }else{
                System.out.println("Ocurrio un error");
            }*/
            
              /*Borrado logico*/
            /*usuario.setEmail("martarojas@gmail.com");
            usuario = usuarioCrud.seleccionarPorEmail(usuario);
            
            System.out.println(usuario.toString());
             Boolean eliminado = usuarioCrud.borrarUsuarioLogico(usuario);
            if(eliminado){
                System.out.println("Se elimino correctamente");
            }else{
                System.out.println("Ocurrio un error");
            }*/
            
            ArrayList<Usuario> usuarios = usuarioCrud.seleccionarTodoActivo(1);
            for(Usuario u : usuarios){
                 System.out.println(u.toString());
            }
        
            
        } catch (Exception ex) {
            Logger.getLogger(Mantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
