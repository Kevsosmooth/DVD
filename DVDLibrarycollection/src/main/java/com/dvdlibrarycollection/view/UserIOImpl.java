/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrarycollection.view;

import java.util.Scanner;

/**
 *
 * @author MANU-EBAY
 */
public class UserIOImpl implements UserIO{
     Scanner s = new Scanner(System.in);
    @Override
    public void print(String message) {
        System.out.println(message.trim());
    }

    @Override
    public double readDouble(String prompt) {
           print(prompt.trim());
           return 
                s.nextDouble();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double d;
        print(prompt + " " + min + " " + max);
        d = s.nextDouble();
        while(d<min ||  d>max){
            print("Please enter a number between " + min + " " + max);
            d = s.nextDouble();

        }
        s.nextLine();
        return d;
                
                
                
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float readFloat(String prompt) {
        print(prompt);
        return
                s.nextFloat();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float d;
        print(prompt + " " + min + " " + max);
        d = s.nextFloat();
        while(d<min ||  d>max){
            print("Please enter a number between " + min + " " + max);
            d = s.nextFloat();

        }
        s.nextLine();
        return d;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int readInt(String prompt) {
        print(prompt);
        return
                s.nextInt();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int d;
        print(prompt + " " + min + " " + max);
        d = s.nextInt();
        while(d<min ||  d>max){
            print("Please enter a number between " + min + " " + max);
            d = s.nextInt();

        }
        s.nextLine();
        return d;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long readLong(String prompt) {
        print(prompt);
        return
                s.nextLong();
        
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long d;
        print(prompt + " " + min + " " + max);
        d = s.nextLong();
        while(d<min ||  d>max){
            print("Please enter a number between " + min + " " + max);
            d = s.nextLong();

        }
        s.nextLine();
        return d;
                
                  
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        return
                s.nextLine().trim();
                
    }
 
}
