/*
 * File: CSVCalendarLoader.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 10/18/2019 dgg - initial coding
 *
 * Credits:  
 *   https://stackabuse.com/reading-and-writing-csvs-in-java-with-apache-commons-csv/
 */
package edu.uab.dgreen.commcal;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * A I/O object to load a calendar from a CSV file
 * @author David G. Green dgreen@uab.edu
 */
public class CSVCalendarLoader implements CalendarLoader {
    
    private String csvFileName;
    
    /**
     * Create Loader Object
     * 
     * @param fileName file name of the csv file
     */
    public CSVCalendarLoader(String fileName) {
        csvFileName = fileName;
    }

    /**
     * Create Calendar from a CSV File
     * 
     * If an unknown role is encountered, it is added to collection.
     * 
     * @param roles - list of known roles
     * @return calendar object
     * @throws java.io.IOException
     */
    @Override
    public Calendar getCalendar(ArrayList<Role> roles) throws IOException {
        
        Calendar calendar = new Calendar();
        
        Reader in = new FileReader(csvFileName);

        CSVParser csvParser = CSVFormat.DEFAULT.parse(in);

        for (CSVRecord record : csvParser) {
           String sYear = record.get(0);
           String sMonth = record.get(1);
           String sRole = record.get(2);
           String description = record.get(3);
           CDate cdate = new CDate(YearType.valueOf(sYear.toUpperCase()), sMonth);
           Role role = Role.find(sRole);
           Activity activity = new Activity(cdate, description, role);
           calendar.add(activity);
        }
        return calendar;
    }    
}
