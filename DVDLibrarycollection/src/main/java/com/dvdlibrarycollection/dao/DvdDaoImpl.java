/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrarycollection.dao;

import com.dvdlibrarycollection.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author MANU-EBAY
 */
public class DvdDaoImpl implements DvdDao{
    
    public final String dvdFile = "dvd.txt";
    public final String delimited = "::";
    
    Map<String, Dvd>allDvds = new HashMap<>();
    
    
    @Override
    public boolean addDvd(String title, Dvd dvd)throws DvdDaoException{
        Dvd newDvd = allDvds.put(title, dvd);
        boolean sucess = false;
        if(allDvds.containsKey(title)){
            writeDvds();
            sucess = true;
        }
        return
               sucess;
    }

    @Override
    public boolean removeDvd(String title)throws DvdDaoException{
        //loaded the dvd first incase the user starts the program with this method call
        loadDvds();
        
        //checking to see if the dvd was actually removed to present
        // a message to the view that everything was sucessfull
        boolean dvdActaullyRemoved = false;
        if(allDvds.containsKey(title)){
            allDvds.remove(title);
            dvdActaullyRemoved = true;
            writeDvds();
        }
        return 
                dvdActaullyRemoved;
    }

    @Override
    public Dvd editInformation(String title, Dvd dvd)throws DvdDaoException{
        //loaded the dvd first incase the user starts the program with this method call
        loadDvds();
        Dvd replaceDvd = null;
        if(dvd!=null){
          replaceDvd = allDvds.put(title, dvd);
          writeDvds();
        }
        
        return
                replaceDvd;
        
    }
    

    @Override
    public List<Dvd> listDvds()throws DvdDaoException{
        List<Dvd>emptyOrNot;
        loadDvds();
        if(allDvds.isEmpty()){
            emptyOrNot = null;
        }else{
            emptyOrNot = new ArrayList<>(allDvds.values());
        }
        return
               emptyOrNot;
        
    }

    @Override
    public Dvd listInformation(String title)throws DvdDaoException{
        loadDvds();
        Dvd getInformation = allDvds.get(title);
        return 
                getInformation;
    }

    @Override
    public Dvd searchByTitle(String title)throws DvdDaoException{
        loadDvds();
        Dvd searchbyTitle = allDvds.get(title);
        return
                searchbyTitle;
    }

    @Override
    public void loadDvds() throws DvdDaoException{
        Scanner readFile = null;
        String lines;
        String[]tokens;
        try{
            readFile =  new Scanner(new BufferedReader(
                new FileReader(dvdFile)));
        }catch(FileNotFoundException e){
            throw new DvdDaoException("File not found", e);
        }
                    
         while(readFile.hasNextLine()){
              lines = readFile.nextLine();
              tokens = lines.split(delimited);
              Dvd dvd = new Dvd();
              dvd.setTitle(tokens[0]);
              dvd.setDirectorName(tokens[1]);
              dvd.setMpaaRating(tokens[2]);
              dvd.setStudio(tokens[3]);
              dvd.setUserRating(tokens[4]);
              dvd.setReleaseDate(tokens[5]);
              allDvds.put(dvd.getTitle(), dvd);
         }
         readFile.close();
    }

    @Override
    public void writeDvds()throws DvdDaoException{
        PrintWriter writer;
        
        try {
             writer = new PrintWriter(new FileWriter(dvdFile));
        } catch (IOException ex) {
             throw new DvdDaoException("Could not write to file",ex);
        }
        
        
        List<Dvd>AllValues = this.listDvds();
        if(AllValues!=null){
            for(Dvd values: AllValues){
                writer.println(values.getTitle() + "::" + values.getDirectorName() +
                        "::" + values.getMpaaRating() + "::" + values.getStudio() + 
                        "::" + values.getUserRating() + "::" + values.getReleaseDate());
                writer.flush();
            }
        } 
        writer.close();
        
        
    }
    
}
