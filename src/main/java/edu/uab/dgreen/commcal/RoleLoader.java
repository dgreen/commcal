/*
 * File: RoleLoader.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 10/30/2019 dgg - initial coding
 */
package edu.uab.dgreen.commcal;

import java.io.IOException;

/**
 * Load the roles and including isA relationships
 * @author David G. Green dgreen@uab.edu
 */
public interface RoleLoader {
    
    public void LoadRoles() throws IOException;
}
