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
import javax.persistence.Query;

/**
 * @author alicia
 */
public class DevisDaoJpa implements DevisDao {

    @Override
    public void createDevis(Devis devis) {
        JpaUtil.obtenirEntityManager().persist(devis);
    }

    @Override
    public List<Devis> findAllDevis() {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT d FROM Devis d");
        List<Devis> resultat = (List<Devis>) query.getResultList();
        return resultat; 
    }

    @Override
    public Devis findDevisById(Long numDevis) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT d FROM Devis d WHERE d.idDevis = :numDevisQ");
        query.setParameter("numDevisQ", numDevis);        
        Devis resultat = (Devis) query.getSingleResult();
        return resultat;
    }

    @Override
    public List<Devis> findDevisByClient(Client client) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT d FROM Devis d WHERE d.clientD = :leClient");
        query.setParameter("leClient", client);
        
        List<Devis> resultat = (List<Devis>) query.getResultList();
        return resultat;
    }

    @Override
    public List<Devis> findDevisByConseiller(Conseiller conseiller) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Devis> findDevisByVoyage(Voyage voyage) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT d FROM Devis d WHERE d.paysDest = :leVoyage");
        query.setParameter("leVoyage", voyage);
        
        List<Devis> resultat = (List<Devis>) query.getResultList();
        return resultat;
    }
    
}
