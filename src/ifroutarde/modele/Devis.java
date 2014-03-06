/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author alicia
 */
@Entity
public class Devis {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idDevis;
    private int tarifD;
    private int nbpersonnesD;
    @ManyToOne
    private Client clientD;
    @ManyToOne
    private Conseiller conseillerD;
    @ManyToOne
    private Voyage voyageD;

    public Devis() 
    {
    }
    
    public Devis(int unTarifD, int unNbpersonnesD, Client unClientD, Conseiller unConseillerD, Voyage unVoyageD) {
        tarifD = unTarifD;
        nbpersonnesD = unNbpersonnesD;
        clientD = unClientD;
        conseillerD = unConseillerD;
        voyageD = unVoyageD;
        unConseillerD.ajouterUnDevis(this);
    }

    public int getTarifD() {
        return tarifD;
    }

    public Long getIdDevis() {
        return idDevis;
    }

    public int getNbpersonnesD() {
        return nbpersonnesD;
    }

    public Client getClientD() {
        return clientD;
    }

    public Conseiller getConseillerD() {
        return conseillerD;
    }

    public Voyage getVoyageD() {
        return voyageD;
    }
      
                            
}
