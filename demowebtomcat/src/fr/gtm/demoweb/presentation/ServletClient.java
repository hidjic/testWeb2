package fr.gtm.demoweb.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.demoweb.domaine.Client;
import fr.gtm.demoweb.service.ServiceClient;

/**
 * Servlet implementation class ServletClient
 */
@WebServlet("/ServletClient")
public class ServletClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("idClient", request.getParameter("idClient"));
		HttpSession session = request.getSession();
		if(request.getParameter("idClient") != null || session.getAttribute("client") != null) {
			int idClient;
			Client c = new Client();
			if(request.getParameter("idClient") != null) {
				idClient = Integer.parseInt(request.getParameter("idClient"));
			}else {
				c = (Client)session.getAttribute("client");
				idClient = c.getId();
			}
			
			ServiceClient servC = new ServiceClient();
			c.setId(idClient);
			c = servC.getOneClient(c);
//			request.setAttribute("client", c);
			session.setAttribute( "client", c );
		}else {
			session.setAttribute("client", null);
		}
//		response.getWriter().append(request.getParameter("idClient")+"Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/client.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServiceClient servC = new ServiceClient();
		boolean update = false;
		String nom = request.getParameter("leNom") == "" ? "NULL" : request.getParameter("leNom");;
		String prenom = request.getParameter("lePrenom") == "" ? "NULL" : request.getParameter("lePrenom");;
		String email = request.getParameter("leMail") == "" ? "NULL" : request.getParameter("leMail");
		String phoneN = request.getParameter("lePhoneNumber") == "" ? "NULL" : request.getParameter("lePhoneNumber");
		String adresse = request.getParameter("lAdresse") == "" ? "NULL" : request.getParameter("lAdresse");
		Client cSession = (Client) session.getAttribute( "client" );
		Client c = new Client(cSession.getId(),nom,prenom,email,adresse,phoneN);
		update = servC.updateOneClient(c);
		if(update) {
			doGet(request,response);
		}
	}

}
