/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.dao;
import ifroutarde.modele.Pays;
import java.util.List;
/**
 *
 * @author alicia
 */
public interface PaysDao{

    public void createPays (Pays pays);
    //Pas de delete et update, juste création car on a pas besoin des services qui s'appuient dessus pour l'interface web du client
    public List <Pays> findAllPays ();
    public Pays findPaysById (Long numPays);
    public List <Pays> findPaysByNomPays (String nomPays);
}
