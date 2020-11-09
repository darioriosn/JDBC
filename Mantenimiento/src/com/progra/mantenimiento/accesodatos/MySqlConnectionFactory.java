/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.mantenimiento.accesodatos;

/**
 *
 * @author Dario
 */
public class MySqlConnectionFactory implements ConnectionFactory{

    @Override
    public ConnectionDB getConnection() {
        return new MySqlConnection();
    }
    
}
