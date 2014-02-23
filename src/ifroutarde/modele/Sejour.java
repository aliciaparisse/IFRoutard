/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.modele;

import java.util.ArrayList;
import javax.persistence.Entity;

/**
 *
 * @author Marchal & Parisse
 */
@Entity
public class Sejour extends Voyage {

    private String descResidence;
    
    public Sejour() 
    {
    }
    
    public Sejour (String unNom, String uneDescription, Pays unPays, int uneDurée, ArrayList <periodeTarif> desTarifs, String nomResidence)
    {
        super (unNom, uneDescription, unPays, uneDurée, desTarifs);
        descResidence = nomResidence;
    }
}
