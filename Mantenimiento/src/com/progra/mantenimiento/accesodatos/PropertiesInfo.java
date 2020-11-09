/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.mantenimiento.accesodatos;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author Dario
 */
public class PropertiesInfo {
    public HashMap getPropertiesFile(String nombreConexion){
        try(InputStream input = this.getClass().getResourceAsStream("/com/progra/properties/" + nombreConexion + ".properties")){
            Properties prop = new Properties();
            if(input == null){
                System.out.println("Archivo de propiedades no encontrado");
                return null;
            }
            prop.load(input);
            HashMap<String, String> databaseInfo = new HashMap<>();
            if(prop.getProperty("db.url") != null){
                databaseInfo.put("url", prop.getProperty("db.url"));
            }
            if(prop.getProperty("db.user") != null){
                databaseInfo.put("user", prop.getProperty("db.user"));
            }
            if(prop.getProperty("db.password") != null){
                databaseInfo.put("password", prop.getProperty("db.password"));
            }
            return databaseInfo;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
