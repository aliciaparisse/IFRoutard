/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.service;

import ifroutarde.dao.ConseillerDao;
import ifroutarde.dao.ConseillerDaoJpa;
import ifroutarde.dao.DevisDao;
import ifroutarde.dao.DevisDaoJpa;
import ifroutarde.dao.JpaUtil;
import ifroutarde.modele.Client;
import ifroutarde.modele.Devis;
import ifroutarde.modele.Voyage;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alicia
 */
public class ServiceDevis {
    private DevisDao devisDao = new DevisDaoJpa();
    private ConseillerDao conseillerDao = new ConseillerDaoJpa();
    
    public void enregistrerDevis (Devis devis)
    {
        JpaUtil.creerEntityManager();
        try
        {            
            JpaUtil.ouvrirTransaction();
            devisDao.createDevis(devis);
            conseillerDao.updateConseiller(devis.getConseillerD());
            JpaUtil.validerTransaction();
        }
        catch (Exception e) {
            e.printStackTrace();
            JpaUtil.annulerTransaction();
        }
        finally 
        {
            JpaUtil.fermerEntityManager();
        }
    }
    
    public List<Devis> getBackDevis ()
    {
        List<Devis> resultat = new ArrayList <Devis> ();
        JpaUtil.creerEntityManager();
        try
        {            
            resultat = devisDao.findAllDevis();
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
    
    public Devis getBackDevisById (Long unId)
    {
        Devis devis = null;
        JpaUtil.creerEntityManager();
        try
        {
            devis = devisDao.findDevisById(unId);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            JpaUtil.fermerEntityManager();
        }
        return devis;
    }
    
    public List<Devis> getBackDevisByClients (Client unClient)
    {
        List <Devis> resultat = new ArrayList<Devis>();
        JpaUtil.creerEntityManager();
        try
        {
            resultat = devisDao.findDevisByClient(unClient);
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
    
    public List<Devis> getBackDevissByVoyage (Voyage unVoyage)
    {
        List <Devis> resultat = new ArrayList<Devis>();
        JpaUtil.creerEntityManager();
        try
        {
            resultat = devisDao.findDevisByVoyage(unVoyage);
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
