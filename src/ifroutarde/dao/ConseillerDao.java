/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.dao;

import ifroutarde.modele.Conseiller;
import java.util.List;

/**
 *
 * @author Marchal & Parisse
 */
public interface ConseillerDao {
    public void createConseiller (Conseiller conseiller);
    public void updateConseiller (Conseiller conseiller);
    public void deleteConseiller (Conseiller conseiller);
    public List<Conseiller> findAllConseiller ();
    public Conseiller findConseillerById (Long numConseiller);
    public List<Conseiller> findConseillerByNomConseiller (String nomConseiller);
    //public List<Conseiller> findConseillerByPays (Pays pays);
}
