/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.mantenimiento.accesodatos;

import java.sql.Connection;

/**
 *
 * @author Dario
 */
public interface ConnectionDB {
    public void connect();
    public Connection getConnection();
}
