/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.service;

import ifroutarde.dao.JpaUtil;
import ifroutarde.dao.PeriodeTarifDao;
import ifroutarde.dao.PeriodeTarifDaoJpa;
import ifroutarde.modele.PeriodeTarif;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alicia
 */
public class ServicePeriodeTarif {
    private PeriodeTarifDao periodeTarifDao = new PeriodeTarifDaoJpa();
    
    public void enregistrerPeriodeTarif (PeriodeTarif periodeTarif)
    {
        JpaUtil.creerEntityManager();
        try
        {
            JpaUtil.ouvrirTransaction();
            periodeTarifDao.createPeriodeTarif(periodeTarif);
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
    
    public List<PeriodeTarif> getBackPeriodeTarif ()
    {
        List<PeriodeTarif> resultat = new ArrayList <PeriodeTarif> ();
        JpaUtil.creerEntityManager();
        try
        {   
            resultat = periodeTarifDao.findAllPeriodeTarif();
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
    
    public PeriodeTarif getBackPeriodeTarifByPrix (int unPrix)
    {
        PeriodeTarif periodeTarif = null;
        JpaUtil.creerEntityManager();
        try
        {
            periodeTarif = (PeriodeTarif) periodeTarifDao.findPeriodeTarifByPrix(unPrix);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            JpaUtil.fermerEntityManager();
        }
        return periodeTarif;
    }
}
