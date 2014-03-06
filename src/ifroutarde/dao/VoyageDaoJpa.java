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
import javax.persistence.Query;

/**
 *
 * @author Marchal & Parisse
 */
public class VoyageDaoJpa implements VoyageDao{
    
    @Override
    public void createVoyage(Voyage voyage) {
        JpaUtil.obtenirEntityManager().persist(voyage);
    }

    @Override
    public List<Voyage> findAllVoyage() {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT v FROM Voyage v");
        List<Voyage> resultat = (List<Voyage>) query.getResultList();
        return resultat; 
    }

    @Override
    public Voyage findVoyageById(Long numVoyage) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT v FROM Voyage v WHERE v.idVoyage = :numVoyageQ");
        query.setParameter("numVoyageQ", numVoyage);        
        Voyage resultat = (Voyage) query.getSingleResult();
        return resultat;
    }

    @Override
    public List<Voyage> findVoyageByPays(Pays pays) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT v FROM Voyage v WHERE v.paysDest = :lePays");
        query.setParameter("lePays", pays);
        
        List<Voyage> resultat = (List<Voyage>) query.getResultList();
        return resultat;
    }

    
    @Override
    public List<Voyage> findVoyageByNomVoyage(String nomVoyage) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT v FROM Voyage v WHERE v.nom = :nomVoyageQ");
        query.setParameter("nomVoyageQ", nomVoyage);
        List<Voyage> resultat = (List<Voyage>) query.getResultList();
        return resultat;
    }

    @Override
    public List<Sejour> findAllSejour() {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT s FROM Sejour s");
        List<Sejour> resultat = (List<Sejour>) query.getResultList();
        return resultat;
    }

    @Override
    public List<Circuit> findAllCircuit() {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT c FROM Circuit c");
        List<Circuit> resultat = (List<Circuit>) query.getResultList();
        return resultat;
    }
    
}
