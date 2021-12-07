/*
 * File: TestPrint.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 10/29/2019 dgg - initial coding
 */
package edu.uab.dgreen.commcal;

import java.util.ArrayList;

/**
 * Test the TextCalendarPrint methods
 *
 * @author David G. Green dgreen@uab.edu
 */
public class TestPrint {

  private static ArrayList<Activity> activities;

  /**
   * run the testing of TextCalendarPrint methods
   *
   * @param args
   */
  public static void main(String[] args) {
    activities = new ArrayList<>();

    Role role1 = new Role("Director");

    activities.add(new Activity(new CDate(YearType.EACH, "January"),
            "A description for activity one",
            role1));
    activities.add(new Activity(new CDate(YearType.EACH, "January"),
            "A description for activity two",
            role1));
    activities.add(new Activity(new CDate(YearType.EVEN, "January/February"),
            "A description for activity three",
            role1));
    activities.add(new Activity(new CDate(YearType.ODD, "March"),
            "A description for activity four",
            role1));
    activities.add(new Activity(new CDate(YearType.EACH, "April"),
            "A description for activity five",
            role1));

    CalendarPrinter cp = new TextCalendarPrinter();
    cp.print(activities, "Director", 2019);

  }
}
