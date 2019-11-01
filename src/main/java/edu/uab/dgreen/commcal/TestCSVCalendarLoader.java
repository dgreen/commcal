/*
 * File: TestCSVCalendarLoader.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 10/29/2019 dgg - initial coding
 */
package edu.uab.dgreen.commcal;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Test CSVCalendarLoader
 * @author David G. Green dgreen@uab.edu
 */
public class TestCSVCalendarLoader {

    
    public static void main(String[] args) {
        
        Calendar calendar = null;
        
        // create the loader giving it a file name
        CSVCalendarLoader csvLoader = new CSVCalendarLoader("testCSVfile.csv");
        
        // create a couple roles matching the file
        Role director = new Role("Director");
        Role excom    = new Role("ExCom");

        // A director is a member of the excom
        director.add(excom);
        
        // Create a list of known roles
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(director);
        roles.add(excom);
        roles.add(Role.getAllRoles());
                
        // read in the calendar
        try {
           calendar = csvLoader.getCalendar(roles);
        } catch (IOException ex) {
            System.out.println("IO Exception.");
            System.exit(1);
        }        
        
        CalendarPrinter cp = new TextCalendarPrinter();
        
        ArrayList<Activity> dir2019 = calendar.extract(2019, director);
        
        cp.print(dir2019, 2019);
        
        ArrayList<Activity> dir2020 = calendar.extract(2020, director);
        cp.print(dir2020, 2020);
        
        ArrayList<Activity> all2020 = calendar.extract(2020, Role.getAllRoles());
        cp.print(all2020, 2020);       
    }
}
