/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.modele;

import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Marchal & Parisse
 */
public class periodeTarif
{
        public String villeDepart;
        
        @Temporal(TemporalType.DATE)
        public Calendar dateDepart;
        public int tarif;
        public String transportAerien;
        
        public periodeTarif (String uneVille, Calendar uneDate, int unTarif, String unTransport) {
            villeDepart = uneVille;
            dateDepart = uneDate;
            tarif = unTarif;
            transportAerien = unTransport;            
        }
}