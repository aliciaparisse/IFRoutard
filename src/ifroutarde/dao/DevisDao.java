/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.dao;

import ifroutarde.modele.Client;
import ifroutarde.modele.Conseiller;
import ifroutarde.modele.Devis;
import ifroutarde.modele.Voyage;
import java.util.List;

/**
 * @author alicia
 */
public interface DevisDao {
    public void createDevis (Devis devis);
    public List <Devis> findAllDevis ();
    public Devis findDevisById (Long numDevis);
    public List <Devis> findDevisByClient (Client client);
    public List <Devis> findDevisByConseiller (Conseiller conseiller);
    public List <Devis> findDevisByVoyage (Voyage voyage);
    
    
}
