/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.mantenimiento.accesodatos;

import com.progra.mantenimiento.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dario
 */
public class UsuarioCrud {

    private static Connection connection;

    public UsuarioCrud() {
        ConnectionFactory connectionFactory = new MySqlConnectionFactory();

        connectionFactory.getConnection().connect();
        
       connection = connectionFactory.getConnection().getConnection();
    }
    
    
    public Boolean insertarUsuario(Usuario usuario) throws SQLException{
        
        PreparedStatement ppmt = null;
        try {
            String consulta = "insert into usuario(email, password) values (?, md5(?))";
            ppmt = connection.prepareStatement(consulta);
            ppmt.setString(1, usuario.getEmail());
            ppmt.setString(2, usuario.getPassword());
            ppmt.execute();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioCrud.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ppmt.close();
        }
    }
    
     public Boolean actualizarUsuario(Usuario usuario) throws SQLException{
        
        PreparedStatement ppmt = null;
        try {
            String consulta = "UPDATE usuario set email = ? where id = ?";
            ppmt = connection.prepareStatement(consulta);
            ppmt.setString(1, usuario.getEmail());
            ppmt.setInt(2, usuario.getId());
            ppmt.execute();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioCrud.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ppmt.close();
        }
    }
     
      public Usuario seleccionarPorEmail(Usuario usuario) throws SQLException{
        
        PreparedStatement ppmt = null;
        try {
            String consulta = "select * from usuario where email = ?";
            ppmt = connection.prepareStatement(consulta);
            ppmt.setString(1, usuario.getEmail());
            ResultSet rs = ppmt.executeQuery();
            if(rs.next()){
                usuario.setEstado(rs.getInt("estado"));
                usuario.setId(rs.getInt("id"));
            }
            return usuario;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioCrud.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            ppmt.close();
        }
    }
      
      /*BORRADO FISICO */
       public Boolean borrarUsuario(Usuario usuario) throws SQLException{
        
        PreparedStatement ppmt = null;
        try {
            String consulta = "DELETE FROM usuario WHERE id = ?";
            ppmt = connection.prepareStatement(consulta);
            ppmt.setInt(1, usuario.getId());
            ppmt.execute();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioCrud.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ppmt.close();
        }
    }

    public Boolean borrarUsuarioLogico(Usuario usuario) throws SQLException{
        PreparedStatement ppmt = null;
        try {
            String consulta = "UPDATE usuario set estado = 0 where id = ?";
            ppmt = connection.prepareStatement(consulta);
            ppmt.setInt(1, usuario.getId());
            ppmt.execute();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioCrud.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ppmt.close();
        }
    }
    
      public ArrayList<Usuario> seleccionarTodoActivo(int estado) throws SQLException{
        
        PreparedStatement ppmt = null;
        try {
            String consulta = "select * from usuario where estado = ?";
            ppmt = connection.prepareStatement(consulta);
            ppmt.setInt(1, estado);
            ResultSet rs = ppmt.executeQuery();
            ArrayList<Usuario> usuarios = new ArrayList<>();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEstado(rs.getInt("estado"));
                usuario.setId(rs.getInt("id"));
                usuarios.add(usuario);
            }
            return usuarios;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioCrud.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            ppmt.close();
        }
    }

}
