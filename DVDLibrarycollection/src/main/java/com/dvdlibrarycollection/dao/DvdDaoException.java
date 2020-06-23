/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrarycollection.dao;

/**
 *
 * @author MANU-EBAY
 */
public class DvdDaoException extends Exception{
    
    public DvdDaoException(String message){
        super(message);
    }
    public DvdDaoException(String message, Throwable t){
        super(message, t);
    }
}
