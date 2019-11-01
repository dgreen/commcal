/*
 * File: TestCSVRoleLoader.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 10/30/2019 dgg - initial coding
 */
package edu.uab.dgreen.commcal;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Test CSVRoleLoader
 *
 * @author David G. Green dgreen@uab.edu
 */
public class TestCSVRoleLoader {
    
    /**
     * Run a simple test of CSVRoleLoader against testCSVRole.csv file
     * @param args 
     */

    public static void main(String[] args) {

        RoleLoader rl = new CSVRoleLoader("testCSVRole.csv");

        try {
            rl.LoadRoles();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        Role all = Role.getAllRoles();
        
        ArrayList<Role> allRoles = all.getContainedRoles();
        
        if (allRoles.size() != 5) {
            System.out.println("Wrong numbe of roles");
        }

        printContainedRoles(all);
        printContainedRoles(Role.find("Director"));
        printContainedRoles(Role.find("Secretary"));
        printContainedRoles(Role.find("Treasurer"));
        printContainedRoles(Role.find("ExCom"));
        printContainedRoles(Role.find("Member"));  
    }

    private static void printContainedRoles(Role role) {
        System.out.println("Roles directly in " + role.getName() + ":");
        for (Role r : role.getContainedRoles()) {
            System.out.println(r.getName());
        }
        System.out.println("===========================");
    }
}
