/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.modele;

import java.util.ArrayList;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Marchal & Parisse
 */
@Entity
public abstract class Voyage 
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idVoyage;
    private String nom; 
    private String description;
    @OneToOne
    private Pays paysDest; // Faut-il que ce soit un pays ou un ID de pays ? Rien que pour les query, je sais pas trop... Est-ce que le OneToOne fait ça ? 
    private int duree; //La durée est en jours
    private ArrayList <periodeTarif> tarifs;
    
    public Voyage ()
    {
    }
    
    public Voyage (String unNom, String uneDescription, Pays unPays, int uneDurée, ArrayList<periodeTarif> desTarifs)
    {
        nom = unNom;
        description = uneDescription;
        paysDest = unPays;
        duree = uneDurée;
        tarifs = desTarifs;
    }
}
