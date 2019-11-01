/*
 * File: MonthRange.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 10/19/2019 dgg - initial coding
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.dgreen.commcal;

import java.time.Month;

/**
 * Model a range of months
 
 A month can be a single month range or a list of contiguous months separated by
 a "/".
 * 
 * @author David G. Green dgreen@uab.edu
 */

public class MonthRange implements Comparable<MonthRange> {
    private String range;
    
    /**
     * Create a month
     * @param aRange
     */
    public MonthRange(String aRange) {
        range = aRange;
    }
    
    @Override
    public String toString() {
        return range;
    }

    /**
     * Compare (for sorting purposes) the name of the supplied month's name.
     * 
     * January comes before February, etc.
     * January comes before January/February
     * January/February comes before February
     * 
     * @param mr range of months object
     * @return 
     */
    @Override
    public int compareTo(MonthRange mr) {
        
        // Compare first month names
        
        Month firstOrdinal = first(range);
        Month mrFirstOrdinal = first(mr.toString());
        
        if (firstOrdinal != mrFirstOrdinal) {
            return firstOrdinal.getValue() - mrFirstOrdinal.getValue();
        }
        
        // if they are equal, use string compare to resolve further
        
        return range.compareTo(mr.range);
    }

    /**
     * Determine Month of the first range in the string
     * @param name - string of form January or January/February or January/February/March
     * @return Month enum of the starting month
     */
    private Month first(String name) {

        String firstMonth = name;
        int endFirstMonth = name.indexOf("/");
        
        if (endFirstMonth >= 0 ) {
            firstMonth = name.substring(0, endFirstMonth);
        }
        
        return Month.valueOf(firstMonth.toUpperCase());
    }
    
    /**
     * Does present month range contain specified month
     * @param m String month range
     * @return 
     */
    boolean contains(String m) {
        return range.contains(m);
    }
    
}
