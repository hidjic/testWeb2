package fr.gtm.demoweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.gtm.demoweb.domaine.Client;

public class ClientDao {
	
	private String url = "jdbc:mysql://localhost/bdd_test_client";
	private String login = "root";
	private String psw = "";
	private Connection cn = null;
	private Statement st = null;
	private ResultSet rs = null;
	
	public Client getClient(Client c) {
		this.connect();
		String sql = "Select * from client where idclient = "+c.getId();
		try {
			this.rs = this.st.executeQuery(sql);
			this.rs.first();	// je mets le curseur sur la première ligne
			c.setNom(this.rs.getString("nom"));
			c.setPrenom(this.rs.getString("prenom"));
			c.setEmail(this.rs.getString("email"));
			c.setPhoneNumber(this.rs.getString("phoneNumber"));
			c.setAdresse(this.rs.getString("adresse"));
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateClient(Client c) {
		this.connect();
		String sql = "update client set nom = '"+c.getNom()+
						"',prenom = '"+c.getPrenom()+
						"',email = '"+c.getEmail()+
						"', adresse = '"+c.getAdresse()+
						"',phoneNumber = '"+c.getPhoneNumber()+
					"' where idclient = "+c.getId();
		try {
			this.st.executeUpdate(sql);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean createClient(Client c) {
		this.connect();
		String sql = "insert into client (nom,prenom)"+
					"values ('"+c.getNom()+"','"+c.getPrenom()+"')";
		try {
			this.st.executeUpdate(sql);
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteClient(Client c) {
		this.connect();
		String sql = "delete from client where idclient = "+c.getId();
		try {
			this.st.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Client> listClient() {
		ArrayList<Client> listC = new ArrayList<Client>();
		Client c;
		this.connect();
		String sql = "select * from client";
		try {
			this.rs = this.st.executeQuery(sql);
			while(this.rs.next()) {
				c = new Client();
				c.setId(this.rs.getInt("idclient"));
				c.setNom(this.rs.getString("nom"));
				c.setPrenom(this.rs.getString("prenom"));
//				c.setAge(this.rs.getInt("age"));
//				c.setIdConseiller(this.rs.getInt("idconseiller"));
				listC.add(c);
			}
			return listC;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.cn = DriverManager.getConnection(url, login, psw);
			this.st = this.cn.createStatement();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
