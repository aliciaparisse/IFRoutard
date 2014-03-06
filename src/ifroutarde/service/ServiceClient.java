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
import java.util.List;

/**
 *
 * @author Marchal & Parisse
 */
public class ServiceClient 
{
    
    private ClientDao monsieurDao = new ClientDaoJpa();    
    
    public void enregistrerClient (Client client)
    {
        JpaUtil.creerEntityManager();
        try
        {            
            JpaUtil.ouvrirTransaction();
            monsieurDao.createClient(client);
            JpaUtil.validerTransaction();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            JpaUtil.annulerTransaction();
        }
        finally 
        {
            JpaUtil.fermerEntityManager();
        }
    }
    
    public List<Client> getBackClients ()
    {
        List<Client> resultat = new ArrayList <Client> ();
        JpaUtil.creerEntityManager();
        try
        {
            resultat = monsieurDao.findAllClient();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            JpaUtil.fermerEntityManager();
        }
        return resultat;
    }
    
    public Client getBackClientById (Long unId)
    {
        Client client = null;
        JpaUtil.creerEntityManager();
        try
        {
            client = monsieurDao.findClientById(unId);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            JpaUtil.fermerEntityManager();
        }
        return client;
    }
    
    public List<Client> getBackClientByNom (String nomClient)
    {
        List<Client> clients = new ArrayList <Client> ();
        JpaUtil.creerEntityManager();
        try
        {
            clients = monsieurDao.findClientByNomClient(nomClient);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            JpaUtil.fermerEntityManager();
        }
        return clients;
    }
}