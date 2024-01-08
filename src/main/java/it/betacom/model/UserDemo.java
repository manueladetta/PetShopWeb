package it.betacom.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import it.betacom.utilities.MyUtilities;

public class UserDemo {
    private String nome;
    private String cognome;
    private String email;
    private String dataDiNascitaString;
    private LocalDate dataDiNascita;
//    private String giorno, mese, anno;
    private String cellulare;
    private String password;
    private String ruolo;
    private String stato;
    
	public UserDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public UserDemo(String nome, String cognome, String email, String giorno, String mese, String anno, String cellulare,
//			String password, String ruolo, String stato) {
	public UserDemo(String nome, String cognome, String email, Date dataDiNascita, String cellulare,
			String password, String ruolo, String stato) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
//		this.giorno = giorno;
//		this.mese = mese;
//		this.anno = anno;
//		this.dataDiNascita = LocalDate.of(Integer.valueOf(anno), Integer.valueOf(mese), Integer.valueOf(giorno));
		this.dataDiNascitaString = dataDiNascita.toString();
		this.dataDiNascita = MyUtilities.convertToLocalDate(dataDiNascita);
		this.cellulare = cellulare;
		this.password = password;
		this.ruolo = ruolo;
		this.stato = stato;
	}
	
	public UserDemo(String nome, String cognome, String email, String dataDiNascitaString, String cellulare,
			String password, String ruolo, String stato) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
//		this.giorno = giorno;
//		this.mese = mese;
//		this.anno = anno;
//		this.dataDiNascita = LocalDate.of(Integer.valueOf(anno), Integer.valueOf(mese), Integer.valueOf(giorno));
		this.dataDiNascitaString = dataDiNascitaString;
		this.dataDiNascita = LocalDate.parse(dataDiNascitaString);
		this.cellulare = cellulare;
		this.password = password;
		this.ruolo = ruolo;
		this.stato = stato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}
    
	@Override
	public String toString() {
		return "UserDemo: nome = " + nome + ", cognome = " + cognome + ", email = "
				+ email + ", dataDiNascita = " + dataDiNascita + ", cellulare = " + cellulare + ", password = " + password
				+ ", ruolo = " + ruolo + ", stato = " + stato;
	}
}
