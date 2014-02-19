/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.dao;

import ifroutarde.modele.Client;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Marchal & Parisse
 */
public class ClientDaoJpa implements ClientDao{
    @Override
    public void createClient ( Client client )
    {
        JpaUtil.obtenirEntityManager().persist(client);
    }

    @Override
    public void updateClient(Client client) {
        JpaUtil.obtenirEntityManager().merge(client);
    }

    @Override
    public void deleteClient(Client client) {
        JpaUtil.obtenirEntityManager().remove(client);
    }

    @Override
    public List<Client> findAllClient() {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT c FROM Client c");
        List<Client> resultat = (List<Client>) query.getResultList();
        return resultat;
    }

    @Override
    public Client findClientById(Long numClient) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT c FROM Client c WHERE c.idClient = :numClientQ");
        query.setParameter("numClientQ", numClient);
        
        Client resultat = (Client) query.getSingleResult();
        return resultat;
    }

    @Override
    public List<Client> findClientByNomClient(String nomClient) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT c FROM Client c WHERE c.nom = :nomClientQ");
        query.setParameter("nomClientQ", nomClient);
        List<Client> resultat = (List<Client>) query.getResultList();
        return resultat;
    }
}
