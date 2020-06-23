/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrarycollection.view;

import com.dvdlibrarycollection.controller.DvdController;
import com.dvdlibrarycollection.dto.Dvd;
import java.util.List;

/**
 *
 * @author MANU-EBAY
 */
public class DvdView {
    UserIO io;
    DvdController controller;
    
    //DEPENDECY INJECTION
    public DvdView (UserIO io){
       this.io = io; 
    }
    
    
    // returns the users input and creates a menu
    public int getMenuandSelection(){
        io.print("MENU");
        io.print("1) ADD NEW DVD");
        io.print("2) REMOVE DVD");
        io.print("3) EDIT DVD");
        io.print("4) LIST ALL DVDS");
        io.print("5) GET INFORMATION ON DVD");
        io.print("6) SEARCH BY DVD TITLE");
        io.print("7) EXIT");
        return
                // makes a call to my USERIO method readInt (STRING,MIN,MAX)
                io.readInt("SELECT FROM",1,7);
        
    }
    // Returning a banner if the methods are sucessful
    public String successOrNotBanner(boolean value){
        if(value==true){
            io.print("=== SUCCESS ===");
        }else{
            io.print("=== DID NOTHING ===");
        }
        io.print("PRESS ENTER TO CONTINUE!");
        return
                io.readString("");
    }
    
    //RETURNS A DVD OBJECT ( CREATES A DVD OBJECT)
    // OBJECT WILL BE SENT TO THE CONTROLLERS AddDvd() Method
    public Dvd createDvd(){
        String getTitle = io.readString("DVD TITLE: ");
        String getDirectorName = io.readString("DIRECTOR'S NAME: ");
        String getMpaaRating = io.readString("MPAA RATING: ");
        String getStudio = io.readString("STUDIO: ");
        String getUserRating = io.readString("USER RATING: ");
        String getReleaseDate = io.readString("RELEASE DATE: ");
        // Creating a new DVD OBJECT TO STORE THE INFORMATION
        Dvd dvd = new Dvd();
        dvd.setTitle(getTitle);
        dvd.setDirectorName(getDirectorName);
        dvd.setMpaaRating(getMpaaRating);
        dvd.setStudio(getStudio);
        dvd.setUserRating(getUserRating);
        dvd.setReleaseDate(getReleaseDate);
        return
                // returns newly made information with a dvd object and its info
                dvd;
    }
    // Just asking the user to select a dvd (nothing special)
    public String dvdSelection(){
        return
                io.readString("Please enter the DVD Ttitle");
    }
    //Makes sure dvd is not NULL before printing out the information
    //Otherwise the user will see that the selection they made was never valid
    public void displayDvdSelection(Dvd dvd){
        if(dvd!=null){
            io.print(dvd.getTitle() + " " + dvd.getDirectorName() + " "
            + dvd.getMpaaRating() + " " + dvd.getStudio() + " " +
                    dvd.getUserRating() + " " + dvd.getReleaseDate());
        }else{
            io.print("Does not exsist");
        }
        
    }
    
    /*
        returns the dvd objects either NULL or NOT 
        and the string that 
        user wanted to change before
    */
    public Dvd getNewDvdInfo(Dvd dvd, String title){
        
        Dvd updatedDvd = null;
        String getDirectorName = null, getMpaaRating = null, getStudio = null, 
                getUserRating = null, getReleaseDate = null;
        
        // Checks to see if the dvd that the user was trying to change in the past
        // even exsisted if it did not exsist then goes to else statement
        
        if(dvd!=null){
             updatedDvd = new Dvd();
             getDirectorName = io.readString("DIRECTOR'S NAME: ");
             getMpaaRating = io.readString("MPAA RATING: ");
             getStudio = io.readString("STUDIO: ");
             getUserRating = io.readString("USER RATING: ");
             getReleaseDate = io.readString("RELEASE DATE: ");
             updatedDvd.setTitle(title);
             updatedDvd.setDirectorName(getDirectorName);
             updatedDvd.setMpaaRating(getMpaaRating);
             updatedDvd.setStudio(getStudio);
             updatedDvd.setUserRating(getUserRating);
             updatedDvd.setReleaseDate(getReleaseDate);
        }else{
            System.out.println("Does not exsist!");
        }
        
        
        return
                updatedDvd;
    }
    public void listAllDvds(List<Dvd>dvd){
        //Gets a list with all the values from the hashmap
        if(dvd!=null){
            //Prints out one dvd object per time 
            for(Dvd currentDvd:dvd){
                 io.print(currentDvd.getTitle() + " " + currentDvd.getDirectorName() + " "
                + currentDvd.getMpaaRating() + " " + currentDvd.getStudio() + " " +
                        currentDvd.getUserRating() + " " + currentDvd.getReleaseDate());
            }// end of for each loop
        }else{
            io.print("EMPTY LIST COLLECTION");
        }
        
    }// end of method call listalldvds
    
    public void displayErrorMessage(String message){
        io.print("=== ERROR ===");
        io.print(message);
    }
}
