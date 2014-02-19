/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.modele;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marchal & Parisse
 * 
 * 
 */
@Entity
public class Client {
    // Attributs de la classe Client
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idClient;
   
    private String civilite;
    private String nom;
    private String prenom;
    
    @Temporal(TemporalType.DATE)
    private Calendar dateNaissance;
    
    private String adresse;
    private String adrMail;
    private String numTel;

    public Client() {
    }
    
    public Client (Long unIdClient, String uneCivi, String unNom, String unPrenom, Calendar uneDateNaiss, String uneAdresse, String uneAdrMail, String unNumTel)           
    {   
        idClient = unIdClient;
        civilite = uneCivi;
        nom = unNom;
        prenom = unPrenom;
        dateNaissance = uneDateNaiss;
        adresse = uneAdresse ;
        adrMail = uneAdrMail;
        numTel = unNumTel;
    }
    
    public Long getIdClient() {
        return idClient;
    }

    public String getCivilite() {
        return civilite;
    }

    public String getPrenom() {
        return prenom;
    }

    public Calendar getDateNaissance() {
        return dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getAdrMail() {
        return adrMail;
    }

    public String getNumTel() {
        return numTel;
    }

    public String getNom() {
        return nom;
    }
}
