/*
 * File: Role.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.1 10/31/2019 dgg - initial coding
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.dgreen.commcal;

import java.util.ArrayList;

/**
 * Model a role.  A role may contain other roles
 * @author David G. Green dgreen@uab.edu
 */
public class Role {
    
    private static Role all = new Role("All");
    private static Role allRoles = new Role("AllRoles");
    private ArrayList<Role> containedRoles = new ArrayList<Role>();
    private String name;

    /**
     * Create a Role
     * 
     * Add every new role to AllRoles (except itself)
     * Add All to every role (except itself)
     * 
     * 
     * @param name
     */
    public Role(String name){
        /*
         * Note that we want AllRoles to contain All (and everything else) but we 
         * can not carry this out until both AllRoles and Roles have been constructed.
         * We want everything else except All to contain All.  We are asking for
         * them to be done in the order All then AllRoles, this is challenging.  
         * We will postpone the addition until AllRoles is created.
         */
        this.name = name;
        if (name.equals("All")) {
            // postpone actions
        } else if ( name.equals("AllRoles")) {
            containedRoles.add(all);
        } else {
            addToAllRoles();
            containedRoles.add(all);
        }
    }
    
    private void addToAllRoles() {
        if (! name.equals("AllRoles")) {
            allRoles.add(this);
        }
    }
    
    /**
     * Get the name of the role
     * @return String role name
     */
    public String getName() {
        return name;
    }
    
    
    /**
     *
     * @return the alAllRoles Role
     */
    public static Role getAllRoles() {
        return allRoles;
    }

    /**
     * Add a sub-role to this role
     * @param subrole the role to add as a sub-role to the present role
     */
    public void add(Role subrole) {
        containedRoles.add(subrole);
    }

    /**
     * Determine if the specific role is contained within this role
     * @param role
     * @return
     */
    public boolean includes(Role role) {
        if (this == role) {
            return true;
        } else {
            for (Role r : containedRoles) {
                if (r == role) {
                    return true;
                } else if (r.includes(role)) {  // recursion
                    return true;
                }
            }
            return false;
        }
    }
    
    /**
     * Get the roles directly contained by this class
     * @return roles
     */
    public ArrayList<Role> getContainedRoles() {
        return containedRoles;
    }

    /**
     * Find (or create) the Role object that has the supplied name
     * @param sRole
     * @return Role object
     */
    public static Role find(String sRole) {
        
        if ("AllRoles".equals(sRole)) {
            return Role.getAllRoles();
        }        
        
        ArrayList<Role> alAllRoles = getAllRoles().getContainedRoles();
        for (Role role : alAllRoles) {
            if (role.getName().equals(sRole)) {
                return role;
            }
        }
        return new Role(sRole);
    }
}
