package it.betacom.utilities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Pattern;

import it.betacom.DAO.UserDAO;
import it.betacom.model.User;

public class MyUtilities {

	// Metodo utilizzato per verificare se la stringa passata come parametro è nel formato di un indirizzo email
	public static boolean isEmailAddress(String emailAddress)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (emailAddress == null)
            return false;
        return pat.matcher(emailAddress).matches();
    }
	
	public static LocalDate convertToLocalDate(Date data) {
		return data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static Date convertToDate(LocalDate data) {
		return Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public static LocalDate convertToLocalDate(java.sql.Date data) {
		return data.toLocalDate();
	}
	
	public static String generateUsername(String nome, String cognome, int annoDiNascita) {
		String firstTwoCharsNome = nome.substring(0, Math.min(nome.length(), 2)).toUpperCase();
	    String firstTwoCharsCognome = cognome.substring(0, Math.min(cognome.length(), 2)).toUpperCase();
	    String usernameBase = firstTwoCharsNome + firstTwoCharsCognome + annoDiNascita;
	    
	    User user = UserDAO.getUserByUsername(usernameBase);

	    if (user == null) {
	        // Lo username non esiste, quindi lo restituisco direttamente
	        return usernameBase;
	    } else {
	        // Se lo username esiste, genero uno username alternativo aggiungendo un progressivo
	        int counter = 1;
	        String newUsername = usernameBase + "_" + counter;
	        
	        user = UserDAO.getUserByUsername(newUsername);

	        // Controllo se il nuovo username esiste nel database
	        while (user != null) {
	            counter++;
	            newUsername = usernameBase + "_" + counter;
	            user = UserDAO.getUserByUsername(newUsername);
	        }

	        return newUsername;
	    }
	}
}
