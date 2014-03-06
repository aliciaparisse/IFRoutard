/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.dao;

import ifroutarde.modele.Circuit;
import ifroutarde.modele.Pays;
import ifroutarde.modele.Sejour;
import ifroutarde.modele.Voyage;
import java.util.List;

/**
 *
 * @author Marchal & Parisse
 */
public interface VoyageDao {
    
    public void createVoyage (Voyage voyage);
    //Pas de delete et update, juste création car on a pas besoin des services qui s'appuient dessus pour l'interface web du client
    public List <Voyage> findAllVoyage ();
    public List <Sejour> findAllSejour ();
    public List <Circuit> findAllCircuit();
    public Voyage findVoyageById (Long numVoyage);
    public List <Voyage> findVoyageByPays (Pays pays);
    public List <Voyage> findVoyageByNomVoyage (String nomVoyage);
    
}
