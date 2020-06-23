/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrarycollection.app;

import com.dvdlibrarycollection.controller.DvdController;
import com.dvdlibrarycollection.dao.DvdDao;
import com.dvdlibrarycollection.dao.DvdDaoException;
import com.dvdlibrarycollection.dao.DvdDaoImpl;
import com.dvdlibrarycollection.view.DvdView;
import com.dvdlibrarycollection.view.UserIOImpl;

/**
 *
 * @author KEVIN SURIEL
 */
public class App {
    public static void main(String[] args) throws DvdDaoException {
        DvdDao dao = new DvdDaoImpl();
        DvdView view = new DvdView(new UserIOImpl());
        DvdController controller = new DvdController(dao, view);
        controller.run();
    }
}
