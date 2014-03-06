/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.dao;

import ifroutarde.modele.PeriodeTarif;
import ifroutarde.modele.PeriodeTarif;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author alicia
 */
public class PeriodeTarifDaoJpa implements PeriodeTarifDao {

     @Override
    public void createPeriodeTarif(PeriodeTarif voyage) {
        JpaUtil.obtenirEntityManager().persist(voyage);
    }

    @Override
    public List<PeriodeTarif> findAllPeriodeTarif() {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT v FROM PeriodeTarif v");
        List<PeriodeTarif> resultat = (List<PeriodeTarif>) query.getResultList();
        return resultat; 
    }

    @Override
    public List<PeriodeTarif> findPeriodeTarifByPrix(int prix) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("SELECT p FROM PeriodeTarif p WHERE p.tarif = :valPrix");
        query.setParameter("valPrix", prix);
        
        List<PeriodeTarif> resultat = (List<PeriodeTarif>) query.getResultList();
        return resultat;
    }

    
    
}
