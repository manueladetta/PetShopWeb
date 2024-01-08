package it.betacom.model;

import java.time.LocalDate;

public class User {
	private int id;
    private String nome;
    private String cognome;
    private String username;
    private String email;
    private LocalDate dataDiNascita;
    private String cellulare;
    private String password;
    private String ruolo;
    private String stato;
    private int loginRimanenti;
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String nome, String cognome, String username, String email, LocalDate dataDiNascita,
			String cellulare, String password, String ruolo, String stato, int loginRimanenti) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.email = email;
		this.dataDiNascita = dataDiNascita;
		this.cellulare = cellulare;
		this.password = password;
		this.ruolo = ruolo;
		this.stato = stato;
		this.loginRimanenti = loginRimanenti;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public int getLoginRimanenti() {
		return loginRimanenti;
	}

	public void setLoginRimanenti(int loginRimanenti) {
		this.loginRimanenti = loginRimanenti;
	}

	@Override
	public String toString() {
		return "User: id = " + id + ", nome = " + nome + ", cognome = " + cognome + ", username = " + username + ", email = "
				+ email + ", dataDiNascita = " + dataDiNascita + ", cellulare = " + cellulare + ", password = " + password
				+ ", ruolo = " + ruolo + ", stato = " + stato + ", loginRimanenti = " + loginRimanenti;
	}
	
}
