/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrarycollection.controller;

import com.dvdlibrarycollection.dao.DvdDao;
import com.dvdlibrarycollection.dao.DvdDaoException;
import com.dvdlibrarycollection.dto.Dvd;
import com.dvdlibrarycollection.view.DvdView;
import java.util.List;

/**
 *
 * @author KEVIN SURIEL
 */
public class DvdController{
    DvdDao dao;
    DvdView view;
    
    public DvdController(DvdDao dao, DvdView view){
        this.dao = dao;
        this.view=view;
    }
    
    public void run(){
        boolean keepRunning = true;
        try{
            while(keepRunning){
                switch(getUserSelection()){
                    case 1:
                        //adds dvd
                        addDvd();;
                        break;

                    case 2:
                        //REMOVE DVD
                        removeDvd();
                        break;

                    case 3:
                        editExisting();
                        break;

                    case 4:
                        listAllDvds();
                        break;

                    case 5:
                        displayDvd();
                        break;

                    case 6:
                        searchByTitle();
                        break;

                    case 7: 
                        keepRunning = false;
                        //program ends
                        break;

                    default:
                        // wrong input message


                }//end of switch

            }// end of while loop (false)
            ///good bye message
     }catch(DvdDaoException e){
         view.displayErrorMessage(e.getMessage());
      }
   }
    
        
   private int getUserSelection(){
       return
               view.getMenuandSelection();
   }
   private void addDvd() throws DvdDaoException{
       Dvd dvd = view.createDvd();
       boolean sucess = dao.addDvd(dvd.getTitle(), dvd);
       view.successOrNotBanner(sucess);
   }
   private void removeDvd() throws DvdDaoException{
       String dvd = view.dvdSelection();
       boolean dvdToRemove = dao.removeDvd(dvd);
       view.successOrNotBanner(dvdToRemove);
   }
   private void editExisting() throws DvdDaoException{
       String dvd = view.dvdSelection();
       Dvd exsist = dao.searchByTitle(dvd);
       Dvd newUpdate = view.getNewDvdInfo(exsist, dvd);
       dao.editInformation(dvd, newUpdate);
       
  }
  private void listAllDvds() throws DvdDaoException{
      //DAO RETURNS VALUES() of the HASHMAP
      //LIST takes all those values and sends it to the view
      List<Dvd>allDvds = dao.listDvds();
      view.listAllDvds(allDvds);
  }
  private void displayDvd() throws DvdDaoException{
     // GETS USER INPUT (LOOKING FOR TITLE HERE) (HASHMAPS KEY)
     String dvd = view.dvdSelection();
     // STORE THE OBJECT INTO (DVD) Which will list the information
     // On a particular dvd or return null if a dvd does not exsist
     Dvd getDvdSelection = dao.listInformation(dvd);
     view.displayDvdSelection(getDvdSelection);
  }
  private void searchByTitle() throws DvdDaoException{
      // ENTIRE METHOD IS BASED ON THE ABOVE ONE
      String dvd = view.dvdSelection();
      Dvd getDvdSelection = dao.listInformation(dvd);
      view.displayDvdSelection(getDvdSelection);
  }
}
