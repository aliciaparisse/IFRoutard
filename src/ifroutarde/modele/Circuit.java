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
public class Circuit extends Voyage 
{

    private ArrayList <String> moyensTransp; //Liste contenant les différents moyens de transports utilisés
    private int distance; //Nombre de kilomètres parcourus au cours du circuit

    public Circuit()
    {   
    }
    
    public Circuit (String unNom, String uneDescription, Pays unPays, int uneDurée, ArrayList<PeriodeTarif> desTarifs, ArrayList <String> desMoyens, int uneDistance)
    {
        super (unNom, uneDescription, unPays, uneDurée, desTarifs);
        moyensTransp = desMoyens;
        distance = uneDistance;
    }
    
}
