/*
 * File: CDate.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 10/19/2019 dgg - initial coding
 */
package edu.uab.dgreen.commcal;

import java.util.Objects;

/**
 * Model a calendar date consisting of a year type (each, even, odd) and
 * a month which can either be a single month or a list of contiguous months 
 * separated by "/"s
 * @author David G. Green dgreen@uab.edu
 */
public class CDate implements Comparable<CDate> {

    private Year year;
    private MonthRange monthRange;
    
    /**
     * Create a CDate
     * @param yearCode EACH, EVEN, ODD year
     * @param monthCode 
     */
    CDate(YearType yearCode, String monthCode) {
        this.year = new Year(yearCode);
        this.monthRange = new MonthRange(monthCode);
    }

    /**
     * Return the year object associated with a CDate
     * @return
     */
    public Year getYear() {
        return year;
    }
    
    /**
     * Return the month range of the CDate
     * @return
     */
    public MonthRange getMonth() {
        return monthRange;
    }

    @Override
    public int compareTo(CDate cdate) {
        int result = monthRange.compareTo(cdate.getMonth());
        if (result == 0) {
            result = year.compareTo(cdate.getYear());
        }
        return result;
    }
    
    /**
     * Determine if object equals this CDate
     *   1. Must be a CDate
     *   2. Must be equal on year and month (by their rules)
     * @param o
     * @return 
     */
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        } else if (! (o instanceof CDate) ) {
//            return false;
//        } else {
//            CDate cd = (CDate) o;
//            return year.equals(cd.getYear()) && monthRange.equals(cd.getMonth());
//        }
//    }
//
//    /** 
//     * Generate hashCode for CDates
//     * 
//     * This is an NetBeans auto-generated code
//     * 
//     * @return hash code
//     */
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 71 * hash + Objects.hashCode(this.year);
//        hash = 71 * hash + Objects.hashCode(this.monthRange);
//        return hash;
//    }
}
