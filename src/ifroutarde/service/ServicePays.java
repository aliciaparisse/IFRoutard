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
 * @author alicia
 */
public class ServicePays {
    
    private PaysDao madameDao = new PaysDaoJpa();
    
    public void enregistrerPays (Pays pays)
    {
        try{
            JpaUtil.creerEntityManager();
            JpaUtil.ouvrirTransaction();
            madameDao.createPays(pays);
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
    
    public List<Pays> getBackPays ()
    {
        List<Pays> resultat = new ArrayList <Pays> ();
        try{
            JpaUtil.creerEntityManager();
            resultat = madameDao.findAllPays();
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
    
    public Pays getBackPaysById (Long unId)
    {
        Pays pays = null;
        try{
            JpaUtil.creerEntityManager();
            pays = madameDao.findPaysById(unId);
        }
        catch (Exception e) {
            e.printStackTrace();
            JpaUtil.annulerTransaction();
        }
        finally {
            JpaUtil.fermerEntityManager();
        }
        return pays;
    }
    
    
}
