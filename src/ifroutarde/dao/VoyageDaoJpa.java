/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.dao;

import ifroutarde.modele.Pays;
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
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT v FROM Voyage v, Pays p WHERE p.idPays = v.paysDest AND p.nom = :nomPays");
        query.setParameter("nomPays", pays);
        
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
    
}
