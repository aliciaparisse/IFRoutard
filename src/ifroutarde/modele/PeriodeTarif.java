/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.modele;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Marchal & Parisse
 */
@Entity
public class PeriodeTarif
{
    
        @Id
        @GeneratedValue (strategy = GenerationType.AUTO)
        private Long idPeriodeTarif;
        private String villeDepart;
        
        @Temporal(TemporalType.DATE)
        private Calendar dateDepart;
        private int tarif;
        private String transportAerien;

    public PeriodeTarif() {
    }
        
        public PeriodeTarif (String uneVille, Calendar uneDate, int unTarif, String unTransport) {
            villeDepart = uneVille;
            dateDepart = uneDate;
            tarif = unTarif;
            transportAerien = unTransport;            
        }
}