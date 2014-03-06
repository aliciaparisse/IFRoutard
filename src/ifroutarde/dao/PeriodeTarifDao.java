/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.dao;

import ifroutarde.modele.PeriodeTarif;
import java.util.List;

/**
 *
 * @author alicia
 */
public interface PeriodeTarifDao {
    public void createPeriodeTarif (PeriodeTarif periodeTarif);
    public List<PeriodeTarif> findAllPeriodeTarif();
    public List <PeriodeTarif> findPeriodeTarifByPrix (int prix);
    
}
