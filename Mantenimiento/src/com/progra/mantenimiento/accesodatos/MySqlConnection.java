/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.mantenimiento.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

/**
 *
 * @author Dario
 */
public class MySqlConnection implements ConnectionDB {
    private static Connection connection;

    public MySqlConnection() {
    }
    

    @Override
    public void connect() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            PropertiesInfo propertiesInfo = new PropertiesInfo();
            HashMap datosConexion = propertiesInfo.getPropertiesFile("mySQL");
            connection = DriverManager.getConnection(datosConexion.get("url").toString(), 
                    datosConexion.get("user").toString(), datosConexion.get("password").toString());
        }catch(Exception ex){
            System.out.println(ex.fillInStackTrace());
        }
    }

    /**
     * @return the connection
     */
    @Override
    public Connection getConnection() {
        return connection;
    }
    
}
