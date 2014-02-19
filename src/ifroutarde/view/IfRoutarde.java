/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.view;

import ifroutarde.modele.Client;
import ifroutarde.modele.Pays;
import ifroutarde.service.ServiceClient;
import ifroutarde.service.ServicePays;
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
        Client alicia = new Client ( 1L, "Mlle", "Parisse", "Alicia", date , "au paradis", "lololo@yahoo.com", "0123456789");
        date.set(1991, 8, 14);
        Client jean = new Client ( 7L, "Saint", "Marchal", "Jean", date , "dans ton cul", "jesuisuncon@orange.fr", "9876543210");
        
        Pays aliciaLand = new Pays (1L, "aliciaLand", "aliciaVille", 2,2);
        Pays geraldineCountry = new Pays (2L, "geraldineCountry", "geraldineCity", 4, 10);
            
        ServiceClient serviceTest = new ServiceClient();
        serviceTest.enregistrerClient(alicia);
        serviceTest.enregistrerClient(jean);
        
        afficherTousClients (serviceTest);
        afficherClientId (serviceTest,7L);
        
        ServicePays serviceTest2 = new ServicePays(); 
        serviceTest2.enregistrerPays(aliciaLand);
        serviceTest2.enregistrerPays(geraldineCountry);
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
    
    public static void afficher
}