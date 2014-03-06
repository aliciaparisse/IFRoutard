/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.service;

import ifroutarde.dao.JpaUtil;
import ifroutarde.dao.VoyageDao;
import ifroutarde.dao.VoyageDaoJpa;
import ifroutarde.modele.Circuit;
import ifroutarde.modele.Pays;
import ifroutarde.modele.Sejour;
import ifroutarde.modele.Voyage;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alicia
 */
public class ServiceVoyage {
    
    VoyageDao leVoyageDao = new VoyageDaoJpa();
    
    public void enregistrerVoyage (Voyage voyage)
    {
        JpaUtil.creerEntityManager();
        try
        {
            JpaUtil.ouvrirTransaction();
            leVoyageDao.createVoyage(voyage);
            JpaUtil.validerTransaction();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            JpaUtil.fermerEntityManager();
        }
    }
    
    public List<Voyage> getBackVoyages ()
    {
        List <Voyage> resultat = new ArrayList<Voyage>();
        JpaUtil.creerEntityManager();
        try
        {
            resultat = leVoyageDao.findAllVoyage();
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
    
    public Voyage getBackVoyagesById (Long unId)
    {
        Voyage resultat = null;
        JpaUtil.creerEntityManager();
        try
        {
            resultat = leVoyageDao.findVoyageById(unId);
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
    
    public List<Voyage> getBackVoyagesByPays (Pays unPays)
    {
        List <Voyage> resultat = new ArrayList<Voyage>();
        JpaUtil.creerEntityManager();
        try
        {
            resultat = leVoyageDao.findVoyageByPays(unPays);
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
    
    public List<Voyage> getBackVoyagesByName (String unNom)
    {
        List <Voyage> resultat = new ArrayList<Voyage>();
        JpaUtil.creerEntityManager();
        try
        {
            resultat = leVoyageDao.findVoyageByNomVoyage(unNom);
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
    
    public List<Sejour> getBackAllSejours ()
    {
        List <Sejour> resultat = new ArrayList<Sejour>();
        JpaUtil.creerEntityManager();
        try
        {
            resultat = leVoyageDao.findAllSejour();
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
    
    
    public List<Circuit> getBackAllCircuits ()
    {
        List <Circuit> resultat = new ArrayList<Circuit>();
        JpaUtil.creerEntityManager();
        try
        {
            resultat = leVoyageDao.findAllCircuit();
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
}
