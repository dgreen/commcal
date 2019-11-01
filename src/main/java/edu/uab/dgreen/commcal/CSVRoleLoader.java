/*
 * File: CSVRoleLoader.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 10/30/2019 dgg - initial coding
 */
package edu.uab.dgreen.commcal;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * Load Roles including relationships from a two column CSV file where
 * column 1 is a Role name, and column 2 is either blank or an IsA Role for the
 * role in column 1.
 * 
 * @author David G. Green dgreen@uab.edu
 */
public class CSVRoleLoader implements RoleLoader {

   private String csvFileName;
    
    /**
     * Create Loader Object
     * 
     * @param fileName file name of the csv file
     */
    public CSVRoleLoader(String fileName) {
        csvFileName = fileName;
    }
    
    /**
     * Load roles from the CSV file if it exists
     * 
     * Per line, discover
     * 
     * @throws IOException if file does not exist or other IO issues
     */
    @Override
    public void LoadRoles() throws IOException {
        
        Reader in = new FileReader(csvFileName);

        CSVParser csvParser = CSVFormat.DEFAULT.parse(in);

        for (CSVRecord record : csvParser) {
           String sRole = record.get(0).trim();
           String sIsARole = record.get(1);
           Role role = Role.find(sRole);
           if (sIsARole != null && !sIsARole.equals("") ) {
               sIsARole = sIsARole.trim();
               Role isARole = Role.find(sIsARole);
               role.add(isARole);
           }
        }
    }

}
