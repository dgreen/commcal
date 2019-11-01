/*
 * File: Calendar.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 10/19/2019 dgg - initial coding
 */
package edu.uab.dgreen.commcal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Represent a calendar with two year cycle of activities
 * 
 * The calendar will be kept in "order" by month, YearType, Role.
 * 
 * @author David G. Green dgreen@uab.edu
 */
public class Calendar {
    
    private TreeSet<Activity> activities;
    
    /**
     * Create the calendar
     */
    public Calendar() {
        activities = new TreeSet<>();
    }
    
    /**
     * Add an activity to the calendar
     * @param a the activity to add
     */
    public void add(Activity a) {
        activities.add(a);
    }
       
    /**
     * Extract qualifying activities filtered by year and role
     * 
     * @param year for the calendar
     * @param role for the calendar
     * @return ArrayList of activities in sorted order
     */
    public ArrayList<Activity> extract(int year, Role role) {
        Activity activity;
        ArrayList<Activity> result = new ArrayList<>();
        Iterator<Activity> itrActivities = activities.iterator();

        while( itrActivities.hasNext()) {
            activity = itrActivities.next();
            if (activity.matches(year, role)) {
                result.add(activity);
            }
        }
        return result;
    }
    
    /**
     * Extract activities from the calendar matching the required month, year, and role.
     * @param year of the calendar
     * @param month of the calendar
     * @param role of the calendar (may be Role.getAll()) to get all item for the month/year
     * @return ArrayList of activities in sorted order
     */
    public ArrayList<Activity> extract(int year, String month, Role role) {
        Activity activity;
        ArrayList<Activity> result = new ArrayList<>();
        Iterator<Activity> itrActivities = activities.iterator();

        while( itrActivities.hasNext()) {
            activity = itrActivities.next();
            if (activity.matches(year, month, role)) {
                result.add(activity);
            }
        }
        return result;
    }
}
