/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.service;

import ifroutarde.dao.ClientDao;
import ifroutarde.dao.ClientDaoJpa;
import ifroutarde.dao.JpaUtil;
import ifroutarde.modele.Client;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Administasoeur
 */
public class ServiceClient {
    
    private ClientDao mecDao = new ClientDaoJpa();    
    
    public void enregistrerClient (Client client)
    {
        try{
            JpaUtil.creerEntityManager();
            JpaUtil.ouvrirTransaction();
            mecDao.createClient(client);
            JpaUtil.validerTransaction();
        }
        catch (Exception e) {
            e.printStackTrace();
            JpaUtil.annulerTransaction();
        }
        finally {
            JpaUtil.fermerEntityManager();
        }
    }
    
    public List<Client> getBackClients ()
    {
        List<Client> resultat = new ArrayList <Client> ();
        try{
            JpaUtil.creerEntityManager();
            resultat = mecDao.findAllClient();
        }
        catch (Exception e) {
            e.printStackTrace();
            JpaUtil.annulerTransaction();
        }
        finally {
            JpaUtil.fermerEntityManager();
        }
        return resultat;
    }
    
    public Client getBackClientById (Long unId)
    {
        Client client = null;
        try{
            JpaUtil.creerEntityManager();
            client = mecDao.findClientById(unId);
        }
        catch (Exception e) {
            e.printStackTrace();
            JpaUtil.annulerTransaction();
        }
        finally {
            JpaUtil.fermerEntityManager();
        }
        return client;
    }
}
