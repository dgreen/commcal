/*
 * File: CalendarPrinter.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 10/19/2019 dgg - initial coding
 */
package edu.uab.dgreen.commcal;

import java.util.ArrayList;

/**
 * Take a sorted ArrayList of Activities and display it
 *
 * @author David G. Green dgreen@uab.edu
 */
public interface CalendarPrinter {

  /**
   * print the list of activities
   *
   * @param activities collection of activities in sorted order
   * @param role text describing role for this calendar
   * @param year year to print for the calendar
   */
  void print(ArrayList<Activity> activities, String role, int year);
}
