/*
 * File: Year.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 10/19/2019 dgg - initial coding
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.dgreen.commcal;

import java.util.Objects;

/**
 * Model a activity year (which has YearType for a value)
 *
 * @author David G. Green dgreen@uab.edu
 */
public class Year implements Comparable<Year> {

    private YearType yearType;

    /**
     * Create a year with a specific type YearType EACH, EVEN, ODD
     *
     * @param yt the type to be used
     */
    public Year(YearType yt) {
        yearType = yt;
    }

    /**
     * Get the year's type YearType EACH, EVEN, ODD
     *
     * @return one of the year types
     */
    public YearType getType() {
        return yearType;
    }

    /**
     * Compare years
     *
     * order Each, Even, Odd
     *
     * @param year the year to compare to
     * @return
     */
    @Override
    public int compareTo(Year year) {
        return yearType.compareTo(year.getType());
    }

    /**
     * Check for equality
     *
     * @param o Object to match to
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Year)) {
            return false;
        } else {
            Year year = (Year) o;
            return (yearType == year.getType());
        }
    }

    /**
     * Softer "equals" -- matches has EACH matching EACH, 
     * EVEN, ODD EVEN matching EACH, 
     * EVEN ODD matching EACH, ODD
     *
     * @param year
     * @return
     */
    public boolean matches(Year year) {
        if (yearType == YearType.EACH || year.getType() == YearType.EACH) {
            return true;
        } else {
            return (yearType == year.getType());
        } 
    }

    /**
     * Generate hashcode (this is auto-generated by NetBeans)
     * @return hashcode for this Year
     */
    @Override
        public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.yearType);
        return hash;
    }
    
    /**
     * See if the numeric year value matches this year with "EACH" matching always
     * @param year the numeric year
     * @return
     */
    public boolean matches(int year) {
        if (yearType == YearType.EACH) {
            return true;
        } else if ( ( (year % 2) == 0) && (yearType == YearType.EVEN)) {
            return true;
        } else {
            return ( ( (year % 2) == 1) && (yearType == YearType.ODD));
        }
    }
}
