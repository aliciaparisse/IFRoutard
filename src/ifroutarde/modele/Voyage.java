/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.modele;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Marchal & Parisse
 */
@Entity
@Inheritance (strategy= InheritanceType.SINGLE_TABLE)
public abstract class Voyage implements Serializable 
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idVoyage;
    private String nom; 
    private String description;
    @ManyToOne
    private Pays paysDest; 
    private int duree; //La durée est en jours
    @OneToMany
    private List <PeriodeTarif> tarifs;
    
    public Voyage ()
    {
    }
    
    public Voyage (String unNom, String uneDescription, Pays unPays, int uneDurée, ArrayList<PeriodeTarif> desTarifs)
    {
        nom = unNom;
        description = uneDescription;
        paysDest = unPays;
        duree = uneDurée;
        tarifs = desTarifs;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public Pays getPaysDest() {
        return paysDest;
    }

    public int getDuree() {
        return duree;
    }

    public List<PeriodeTarif> getTarifs() {
        return tarifs;
    }
    
    
}
