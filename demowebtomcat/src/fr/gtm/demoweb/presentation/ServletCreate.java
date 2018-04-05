package fr.gtm.demoweb.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.demoweb.domaine.Client;
import fr.gtm.demoweb.service.ServiceClient;

/**
 * Servlet implementation class ServletCreate
 */
@WebServlet("/ServletCreate")
public class ServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("leNom");
		String prenom = request.getParameter("lePrenom");
		
		RequestDispatcher rd;
		
		if(nom != "" && prenom != "") {
			ServiceClient servC = new ServiceClient();
			Client leClient = new Client();
			boolean isCreate;
			
			leClient.setNom(nom);
			leClient.setPrenom(prenom);
			
			isCreate = servC.createNewClient(leClient);
			
			
			if(isCreate) {
				rd = request.getRequestDispatcher("allGood.html");
			}else {
				rd = request.getRequestDispatcher("error.html");
			}
		}else {
			rd = request.getRequestDispatcher("error.html");
		}
		rd.forward(request, response);
	}

}