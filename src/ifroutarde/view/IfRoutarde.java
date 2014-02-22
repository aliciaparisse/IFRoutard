/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.view;

import ifroutarde.modele.Client;
import ifroutarde.modele.Conseiller;
import ifroutarde.service.ServiceClient;
import ifroutarde.service.ServiceConseiller;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class IfRoutarde {

    /**   {} []
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Client [] clients = new Client [10];
        Calendar date = Calendar.getInstance();
        date.set(1992, 9, 28);
        Client alicia = new Client ( "Mlle", "Parisse", "Alicia", date , "au paradis", "lololo@yahoo.com", "0123456789");
        date.set(1991, 8, 14);
        Client jean = new Client ( "Saint", "Marchal", "Jean", date , "dans ton cul", "jesuisuncon@orange.fr", "9876543210");
        

        Pays aliciaLand = new Pays ("aliciaLand", "aliciaVille", 2,2, "Anglais");
        Pays geraldineCountry = new Pays ("geraldineCountry", "geraldineCity", 4, 10, "Québecquois");
            
        ServiceClient serviceTest = new ServiceClient();
        serviceTest.enregistrerClient(alicia);
        serviceTest.enregistrerClient(jean);
        
        List<Client> listTemp = serviceTest.getBackClients();
        Conseiller paul = new Conseiller ( listTemp, "Lavalle", "Paul", "bouh@toto.fr" );
        Conseiller thomas = new Conseiller ( listTemp, "Cheval", "Thomas", "Bah@titi.fr" );
        
        ServiceConseiller serviceTestCons = new ServiceConseiller();
        serviceTestCons.enregistrerConseiller(paul);
        serviceTestCons.enregistrerConseiller(thomas);
        
        afficherTousClients (serviceTest);
        afficherClientsNom (serviceTest,"Parisse");
        
        ServicePays serviceTest2 = new ServicePays(); 
        serviceTest2.enregistrerPays(aliciaLand);
        serviceTest2.enregistrerPays(geraldineCountry);
        
        afficherTousPays(serviceTest2);
        afficherPaysId(serviceTest2, aliciaLand.getIdPays());
        
        afficherTousConseillers (serviceTestCons);
        afficherConseillersNom (serviceTestCons, "Paul");
    }
    
    public static void afficherTousClients (ServiceClient unService)
    {
        List<Client> resultat = unService.getBackClients();
        for (int i = 0; i<resultat.size(); i++)
        {
            Client client = resultat.get(i);
            
            String laCivi = client.getCivilite();
            String leNom = client.getNom();
            String lePrenom = client.getPrenom();
            Calendar laDateNaiss = client.getDateNaissance();
            String lAdresse = client.getAdresse();
            String lAdrMail = client.getAdrMail();
            String leNumTel = client.getNumTel();    
    
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println( laCivi + " " + leNom + " " + lePrenom + " " + dateFormatter.format(laDateNaiss.getTime()) );
            System.out.println( lAdresse);
            System.out.println( lAdrMail + "  " + leNumTel );
            System.out.println();
        }
    }
    
    public static void afficherClientId (ServiceClient unService, Long unId)
    {
        Client client = unService.getBackClientById(unId); 
        
        String laCivi = client.getCivilite();
        String leNom = client.getNom();
        String lePrenom = client.getPrenom();
        Calendar laDateNaiss = client.getDateNaissance();
        String lAdresse = client.getAdresse();
        String lAdrMail = client.getAdrMail();
        String leNumTel = client.getNumTel();    
    
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println( laCivi + " " + leNom + " " + lePrenom + " " + dateFormatter.format(laDateNaiss.getTime()) );
        System.out.println( lAdresse);
        System.out.println( lAdrMail + "  " + leNumTel );
        System.out.println();
    }
    

    public static void afficherTousPays(ServicePays unService)
    {
        List<Pays> resultat = unService.getBackPays();
        for (int i = 0; i<resultat.size(); i++)
        {
            Pays pays = resultat.get(i);
            String nom = pays.getNom();
            String capitale = pays.getCapitale();
            int nbHab = pays.getNbHab();
            int superf = pays.getSuperficie();
            String langue = pays.getLangue();
            
            System.out.println (nom + " dont la capitale est " + capitale + " ontenant  "+ nbHab + " habitants et d'une taille de " + superf +" km². La langue officielle de " + nom + " est : " + langue);
        }
    }
        
    public static void afficherPaysId(ServicePays unService, Long unId)
    {
        Pays pays = unService.getBackPaysById(unId);
        
        String nom = pays.getNom();
        String capitale = pays.getCapitale();
        int nbHab = pays.getNbHab();
        int superf = pays.getSuperficie();
        String langue = pays.getLangue();
            
        System.out.println (nom + " dont la capitale est " + capitale + " ontenant  "+ nbHab + " habitants et d'une taille de " + superf +" km². La langue officielle de " + nom + " est : " + langue);
    }
    

    public static void afficherClientsNom (ServiceClient unService, String unNom)
    {
        List<Client> resultat = unService.getBackClientByNom(unNom);
        for (int i = 0; i<resultat.size(); i++)
        {
            Client client = resultat.get(i);
            
            String laCivi = client.getCivilite();
            String leNom = client.getNom();
            String lePrenom = client.getPrenom();
            Calendar laDateNaiss = client.getDateNaissance();
            String lAdresse = client.getAdresse();
            String lAdrMail = client.getAdrMail();
            String leNumTel = client.getNumTel();    
    
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println( laCivi + " " + leNom + " " + lePrenom + " " + dateFormatter.format(laDateNaiss.getTime()) );
            System.out.println( lAdresse);
            System.out.println( lAdrMail + "  " + leNumTel );
            System.out.println();
        }
    }
    
    public static void afficherTousConseillers (ServiceConseiller unService)
    {
        List<Conseiller> resultat = unService.getBackConseillers();
        for (int i = 0; i<resultat.size(); i++)
        {
            Conseiller conseiller = resultat.get(i);
            
            String leNom = conseiller.getNom();
            String lePrenom = conseiller.getPrenom();
            String lAdrMail = conseiller.getAdrMail();
            List<Client> listClient = conseiller.getClientsAttribues();
            //List<Pays> listPays = conseiller.getPaysSpecialises();
    
            System.out.println( leNom + " " + lePrenom );
            System.out.println( lAdrMail );
            // Ajouter éléments de la liste des pays.            
            System.out.println();
        }
    }
    
    public static void afficherConseillerId (ServiceConseiller unService, Long unId)
    {
        Conseiller conseiller = unService.getBackConseillerById(unId); 
        
        String leNom = conseiller.getNom();
        String lePrenom = conseiller.getPrenom();
        String lAdrMail = conseiller.getAdrMail();   
    
        System.out.println( leNom + " " + lePrenom );
        System.out.println ( lAdrMail );
        // List Pays + Clients
        System.out.println();
    }
    
    public static void afficherConseillersNom (ServiceConseiller unService, String unNom)
    {
        List<Conseiller> resultat = unService.getBackConseillerByNom(unNom);
        for (int i = 0; i<resultat.size(); i++)
        {
            Conseiller conseiller = resultat.get(i);
            
            String leNom = conseiller.getNom();
            String lePrenom = conseiller.getPrenom();
            String lAdrMail = conseiller.getAdrMail();   
    
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println( leNom + " " + lePrenom );
            System.out.println( lAdrMail );
            // ListPays et Clients
            System.out.println();
        }
    }

}