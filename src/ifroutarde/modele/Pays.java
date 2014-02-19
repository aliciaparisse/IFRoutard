/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author alicia
 */
@Entity
public class Pays {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idPays;
    private String nom;
    private String capitale;
    private int nbHab;
    private int superficie; //La superficie est en km²
    
    public Pays()
    {
        
    }
    
    public Pays(Long unId, String unNom, String uneCapitale, int unNbHab, int uneSuperficie)
    {
        idPays = unId;
        nom = unNom;
        capitale = uneCapitale; 
        nbHab = unNbHab;
        superficie = uneSuperficie; 
    }

    public Long getIdPays() {
        return idPays;
    }

    public String getNom() {
        return nom;
    }

    public String getCapitale() {
        return capitale;
    }

    public int getNbHab() {
        return nbHab;
    }

    public int getSuperficie() {
        return superficie;
    }
    
        
}
