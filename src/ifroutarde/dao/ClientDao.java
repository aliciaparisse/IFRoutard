/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutarde.dao;

import ifroutarde.modele.Client;
import java.util.List;

/**
 *
 * @author Marchal & Parisse
 */
public interface ClientDao {

    public void createClient (Client client);
    public void updateClient (Client client);
    public void deleteClient (Client client);
    public List <Client> findAllClient ();
    public Client findClientById (Long numClient);
    public List <Client> findClientByNomClient (String nomClient);
}
