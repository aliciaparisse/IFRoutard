/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.modele;

import java.util.ArrayList;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author alicia
 */
@Entity
public abstract class Voyage 
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String nom; 
    private String description;
    private int duree; //La durée est en jours
    private ArrayList <periodeTarif> tarifs;
    
    public Voyage ()
    {
    }
    
    public Voyage (String unNom, String uneDescription, int uneDurée, ArrayList<periodeTarif> desTarifs)
    {
        nom = unNom;
        description = uneDescription;
        duree = uneDurée;
        tarifs = desTarifs;
    }
}
