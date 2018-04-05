package fr.gtm.demoweb.service;

import java.util.ArrayList;

import fr.gtm.demoweb.dao.ClientDao;
import fr.gtm.demoweb.domaine.Client;

public class ServiceClient {
	
	private ClientDao cDao = new ClientDao();
	
	public boolean createNewClient(Client c) {
		boolean insert = false;
		insert = this.cDao.createClient(c);
		return insert;
	}
	
	public Client getOneClient(Client c) {
		c = this.cDao.getClient(c);
		return c;
	}
	
//	public Client updateOneClient(Client c) {
//		c = this.cDao.updateClient(c);
//		return c;
//	}
	
	public boolean updateOneClient(Client c) {
		boolean update = false;
		update = this.cDao.updateClient(c);
		return update;
	}
	
	public String deleteOneClient(Client c) {
		boolean delete = false;
		String res = "";
		delete = this.cDao.deleteClient(c);
		res = delete ? "suppression ok" : "probleme lors de la suppression";
		return res;
	}
	
	public ArrayList<Client> recuperationListClient(){
		ArrayList<Client> listC = new ArrayList<Client>();
		listC = this.cDao.listClient();
		return listC;
	}
	
}
