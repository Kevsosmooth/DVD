/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrarycollection.dao;

import com.dvdlibrarycollection.dto.Dvd;
import java.util.List;

/**
 *
 * @author MANU-EBAY
 */
public interface DvdDao {
    
    boolean addDvd(String title, Dvd dvd)throws DvdDaoException;
    boolean removeDvd(String title)throws DvdDaoException;
    Dvd editInformation(String title, Dvd dvd)throws DvdDaoException;
    List<Dvd>listDvds()throws DvdDaoException;
    Dvd listInformation(String title)throws DvdDaoException;
    Dvd searchByTitle(String title)throws DvdDaoException;
    void loadDvds() throws DvdDaoException;
    void writeDvds() throws DvdDaoException;
    
    
    
}
