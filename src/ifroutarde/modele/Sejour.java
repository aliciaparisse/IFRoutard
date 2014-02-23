/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.modele;

import java.util.ArrayList;
import javax.persistence.Entity;

/**
 *
 * @author alicia
 */
@Entity
public class Sejour extends Voyage {

    private String descResidence;
    
    public Sejour() 
    {
    }
    
    public Sejour (String unNom, String uneDescription, int uneDurée, ArrayList <periodeTarif> desTarifs, String nomResidence)
    {
        super (unNom, uneDescription, uneDurée, desTarifs);
        descResidence = nomResidence;
    }
}
