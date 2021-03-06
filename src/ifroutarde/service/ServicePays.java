/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.service;

import ifroutarde.dao.JpaUtil;
import ifroutarde.dao.PaysDao;
import ifroutarde.dao.PaysDaoJpa;
import ifroutarde.modele.Pays;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marchal & Parisse
 */
public class ServicePays {
    
    private PaysDao paysDao = new PaysDaoJpa();
    
    public void enregistrerPays (Pays pays)
    {
        JpaUtil.creerEntityManager();
        try
        {
            JpaUtil.ouvrirTransaction();
            paysDao.createPays(pays);
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
    
    public List<Pays> getBackPays ()
    {
        List<Pays> resultat = new ArrayList <Pays> ();
        JpaUtil.creerEntityManager();
        try
        {
            resultat = paysDao.findAllPays();
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
    
    public Pays getBackPaysById (Long unId)
    {
        Pays pays = null;
        JpaUtil.creerEntityManager();
        try
        {
           pays = paysDao.findPaysById(unId);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            JpaUtil.fermerEntityManager();
        }
        return pays;
    }
    
    
}
