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
public interface ConnectionFactory {
    ConnectionDB getConnection();
}
