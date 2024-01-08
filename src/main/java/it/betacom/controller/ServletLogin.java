package it.betacom.controller;

import java.io.IOException;

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
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private static final int MAX_LOGIN_ATTEMPTS = 3; // Numero massimo di tentativi di login
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
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
		// Prelevo i parametri
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username != null && username != null) { // Parametri ricevuti correttamente
        	User user = null;
        	
        	// Controllo con che parametro ha effettuato l'accesso
        	boolean accessWithEmail = MyUtilities.isEmailAddress(username);
        	
        	if(accessWithEmail) { // Accesso mediante indirizzo email
        		user = UserDAO.getUserByEmail(username);
        	} else { // Accesso mediante username
        		user = UserDAO.getUserByUsername(username);
        	}
        	
        	if(user != null) { // Utente presente nel db
        		// Controllo che la password inserita sia corretta
        		boolean isPasswordCorrect = password.equals(user.getPassword());
        		if(isPasswordCorrect) { // Credenziali corrette
        			if(user.getStato().equals("A")) { // L'utente può effettuare l'accesso
        				HttpSession session = request.getSession();
        				session.setAttribute("user", user);
    					response.sendRedirect("dashboard.jsp");        					
        			} else { // L'utente risulta essere disabilitato
        				String errorMessage = "L'account risulta essere disabilitato. Contattare l'amministratore.";
                        request.setAttribute("errorMessage", errorMessage);
                        request.getRequestDispatcher("login.jsp").forward(request, response);
        			}
        		} else { // Password errata
                    int loginAttemptsLeft = user.getLoginRimanenti();
                    if (loginAttemptsLeft > 1) { // L'utente ha ancora dei tentativi rimanenti
                    	loginAttemptsLeft--;
                        user.setLoginRimanenti(loginAttemptsLeft);
//                        UserDAO.updateUserLoginAttempts(username, loginAttemptsLeft);
                        UserDAO.update(user);

                        String errorMessage = "Credenziali non valide. Tentativi rimanenti: " + loginAttemptsLeft;
                        request.setAttribute("errorMessage", errorMessage);
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else { // L'utente non ha più tentativi a sua disposizione
                    	 UserDAO.disableUser(username);

                         String errorMessage = "Account disabilitato. Contattare l'amministratore.";
                         request.setAttribute("errorMessage", errorMessage);
                         request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
        		}
        	} else { // Utente non presente nel db
        		// Reindirizzo verso la pagina di registrazione
        		String errorMessage = "Account inesistente. Registrati.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("registrazione.jsp").forward(request, response);        	}
        	
        } else { // Problema durante la ricezione dei dati
        	String errorMessage = "Errore durante la ricezione dei dati.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

	}

}
