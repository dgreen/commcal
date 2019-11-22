/*
 * File: Activity.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.1.0 11/22/2019 dgg - add sequence number to assist user in controlling
 *                              order of items so that entry order provides
 *                              guidance (beyond date, before role, for sorting)
 * Vers: 1.0.0 10/18/2019 dgg - initial coding
 */
package edu.uab.dgreen.commcal;

/**
 * Model an activity consisting of a CDate, Role, Description
 * @author David G. Green dgreen@uab.edu
 */
public class Activity implements Comparable<Activity> {
    
    private CDate date;
    private String description;
    private Role role;
    private int sequence;
    private static int numberActivities = 0;
    
    /**
     * Create an activity
     * @param date CDate representation of date of activity
     * @param description text description of object
     * @param role the role which owns the activity
     */
    public Activity(CDate date, String description, Role role) {
        this.date = date;
        this.description = description;
        this.role = role; 
        this.sequence = ++numberActivities;
    }

    /**
     * Extract the date
     * @return the CDate version of the date of the activity
     */
    public CDate getDate() {
        return date;
    }

    /**
     * Extract the description
     * @return  String description of the activity
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Extract the role
     * @return Role representation of the role of the activity
     */
    public Role getRole() {
        return role;
    }
    
    /**
     * See if the activity matches supplied year, month, role
     * 
     * Note that 2019 matches ODD and EACH
     * Note that March and April match March/April.
     * 
     * @param year an actual year (like 2019)
     * @param month an actual month (like February)
     * @param aRole a Role object
     * @return true for a match or false otherwise
     */
    public boolean matches(int year, String month, Role aRole) {
        // TBD: push date matching down to CDate
        return ( date.getYear().matches(year)
                && date.getMonth().contains(month) 
                && aRole.includes(role)
                );
    }
    
    /**
     * See if the activity matches supplied year, role
     * 
     * Note that 2019 matches ODD and EACH
     * 
     * @param year an actual year (like 2019)
     * @param aRole a Role object
     * @return true for a match or false otherwise
     */
    public boolean matches(int year, Role aRole) {
        return ( date.getYear().matches(year) 
                && aRole.includes(role) 
                );
    }

    /**
     * Implement compareTo for sorting, priority is date, then order added to calendar,
     * then role then description
     * 
     * @param activity to compare against
     * @return negative if present sorts earlier than argument activity, 0 if equal, 
     * positive if sorts later 
     */
    @Override
    public int compareTo(Activity activity) {
        int result = date.compareTo(activity.getDate());
        if (result == 0) {
            result = sequence - activity.sequence;
            if ( result == 0 ) {
                result = role.getName().compareTo(activity.getRole().getName());
                if (result == 0) {
                    result = description.compareTo(activity.getDescription());
                }
            }
        }
        return result;        
    }
}
