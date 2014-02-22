/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.modele;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Marchal & Parisse
 */
@Entity
public class Conseiller {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idConseiller;
    
    private List<Client> clientsAttribues;
    //private List<Pays> paysSpecialises;
    private String nom;
    private String prenom;
    private String adrMail;
    
    public Conseiller(){
    }
    
    public Conseiller (List<Client> ListeClient, /*List<Pays> listPaysSpecialises, */String unNom, String unPrenom, String uneAdrMail){
        clientsAttribues = ListeClient;
        //paysSpecialises = listPaysSpecialises;
        nom = unNom;
        prenom = unPrenom;
        adrMail = uneAdrMail;
    }

    public Long getIdConseiller() {
        return idConseiller;
    }

    public List<Client> getClientsAttribues() {
        return clientsAttribues;
    }
/*
    public List<Pays> getPaysSpecialises() {
        return paysSpecialises;
    }
*/
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdrMail() {
        return adrMail;
    }
}