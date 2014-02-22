/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.dao;

import ifroutarde.modele.Conseiller;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Marchal & Parisse
 */
public class ConseillerDaoJpa implements ConseillerDao{

    @Override
    public void createConseiller(Conseiller conseiller) {
        JpaUtil.obtenirEntityManager().persist(conseiller);
    }

    @Override
    public void deleteConseiller(Conseiller conseiller) {
        JpaUtil.obtenirEntityManager().remove(conseiller);
    }

    @Override
    public List<Conseiller> findAllConseiller() {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT c FROM Conseiller c");
        List<Conseiller> resultat = (List<Conseiller>) query.getResultList();
        return resultat;
    }

    @Override
    public Conseiller findConseillerById(Long numConseiller) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT c FROM Conseiller c WHERE c.idConseiller = :numConseillerQ");
        query.setParameter("numConseillerQ", numConseiller);
        
        Conseiller resultat = (Conseiller) query.getSingleResult();
        return resultat;
    }

    @Override
    public List<Conseiller> findConseillerByNomConseiller(String nomConseiller) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT c FROM Conseiller c WHERE c.nom = :nomConseillerQ");
        query.setParameter("nomConseillerQ", nomConseiller);
        List<Conseiller> resultat = (List<Conseiller>) query.getResultList();
        return resultat;
    }
    
}
