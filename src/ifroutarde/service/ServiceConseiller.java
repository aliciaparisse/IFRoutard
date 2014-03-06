/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.service;

import ifroutarde.dao.ConseillerDao;
import ifroutarde.dao.ConseillerDaoJpa;
import ifroutarde.dao.JpaUtil;
import ifroutarde.modele.Conseiller;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marchal & Parisse
 */
public class ServiceConseiller {
    private ConseillerDao monsieurDao = new ConseillerDaoJpa();
    
    public void enregistrerConseiller (Conseiller conseiller)
    {
        JpaUtil.creerEntityManager();
        try{
            JpaUtil.ouvrirTransaction();
            monsieurDao.createConseiller(conseiller);
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
    
    public List<Conseiller> getBackConseillers ()
    {
        List<Conseiller> resultat = new ArrayList <Conseiller> ();
        JpaUtil.creerEntityManager();
        try
        {
            resultat = monsieurDao.findAllConseiller();
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
    
    public Conseiller getBackConseillerById (Long unId)
    {
        Conseiller client = null;
        JpaUtil.creerEntityManager();
        try
        {
            client = monsieurDao.findConseillerById(unId);
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
    
    public List<Conseiller> getBackConseillerByNom (String nomConseiller)
    {
        List<Conseiller> conseillers = new ArrayList <Conseiller> ();
        JpaUtil.creerEntityManager();
        try
        {
            conseillers = monsieurDao.findConseillerByNomConseiller(nomConseiller);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            JpaUtil.fermerEntityManager();
        }
        return conseillers;
    }
}
