/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.modele;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author alicia
 */
public abstract class Voyage 
{
    
    private String nom; 
    private String description;
    private int durée; //La durée est en jours
    private ArrayList <periodeTarif> tarifs;
    
    class periodeTarif
    {
        public String villeDepart;
        public Calendar dateDepart;
        public int tarif;
        public String transportAerien;
        
        public periodeTarif (String uneVille, Calendar uneDate, int unTarif, String unTransport) {
            
        }
    }
    
}
