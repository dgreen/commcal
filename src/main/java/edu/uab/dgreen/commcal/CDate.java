/*
 * File: CDate.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.1 11/02/2019 dgg - initial coding
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

    /**
     * Compare two cdates
     * @param cdate second cDate
     * 
     * Note the sort is non-intuitive.  Since at most one year will be output and
     * we want all a month's items together regardless whether it is each/even or each/odd
     * we need to look at month first and the sort less importantly the years.
     * 
     * @return -1 if base object comes earlier, 0 if same, +1 if base object comes later
     */
    @Override
    public int compareTo(CDate cdate) {
        int result = monthRange.compareTo(cdate.getMonth());
        if (result == 0) {
            result = year.compareTo(cdate.getYear());
        }
        return result;
    }
}