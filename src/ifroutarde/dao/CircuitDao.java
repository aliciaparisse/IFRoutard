/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.dao;

import ifroutarde.modele.Circuit;

/**
 * @author Marchal & Parisse
 */
public interface CircuitDao extends VoyageDao{
    
    public void createCircuit (Circuit circuit);
    
    
}
