/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.dao;

import ifroutarde.modele.Client;
import ifroutarde.modele.Pays;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author alicia
 */
public class PaysDaoJpa implements PaysDao{

    @Override
    public void createPays(Pays pays) {
        JpaUtil.obtenirEntityManager().persist(pays);
    }

    @Override
    public List<Pays> findAllPays() {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT p FROM Pays p");
        List<Pays> resultat = (List<Pays>) query.getResultList();
        return resultat; 
    }

    @Override
    public Pays findPaysById(Long numPays) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT p FROM Pays p WHERE p.idPays = :numPaysQ");
        query.setParameter("numPaysQ", numPays);
        
        Pays resultat = (Pays) query.getSingleResult();
        return resultat;
    }

    @Override
    public List<Pays> findPaysByNomPays(String nomPays) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT p FROM Pays p WHERE p.nom = :nomPaysQ");
        query.setParameter("nomPaysQ", nomPays);
        List<Pays> resultat = (List<Pays>) query.getResultList();
        return resultat;
    }
  
}
