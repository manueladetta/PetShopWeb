package it.betacom.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.DAO.UserDAO;
import it.betacom.model.User;
import it.betacom.utilities.MyUtilities;

/**
 * Servlet implementation class ServletRegistrazione
 */
@WebServlet("/ServletRegistrazione")
public class ServletRegistrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private static final int MAX_LOGIN_ATTEMPTS = 3; // Numero massimo di tentativi di login
    private static final String USER_ROLE = "G", USER_STATUS = "A";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String email = request.getParameter("email");
        String cellulare = request.getParameter("cellulare");
        String password = request.getParameter("password");
        String dataDiNascitaString = request.getParameter("data_nascita");
        LocalDate dataDiNascita =LocalDate.parse(dataDiNascitaString);

        User newUser = new User();
        newUser.setNome(nome);
        newUser.setCognome(cognome);
        newUser.setEmail(email);
        newUser.setCellulare(cellulare);
        newUser.setDataDiNascita(dataDiNascita);
        newUser.setPassword(password);
        newUser.setRuolo(USER_ROLE);
        newUser.setStato(USER_STATUS);
        newUser.setLoginRimanenti(MAX_LOGIN_ATTEMPTS);
        newUser.setUsername(MyUtilities.generateUsername(nome, cognome, dataDiNascita.getYear()));
        
        int result = UserDAO.save(newUser);

        if (result > 0) {
            // In caso di registrazione riuscita, reindirizzamento a dashboard
//        	HttpSession session = request.getSession();
//			session.setAttribute("user", newUser);
//            response.sendRedirect("dashboard.jsp");
            response.sendRedirect("login.jsp");
        } else {
        	String errorMessage = "Errore durante la registrazione. Riprovare";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("registrazione.jsp").forward(request, response);
        }
	}


}
