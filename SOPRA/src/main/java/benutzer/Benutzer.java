package benutzer;

import java.io.Serializable;
import java.util.Set;

import javax.faces.bean.*;
import javax.persistence.*;

import projektelemente.Projekt;

/**
 * Die Klasse Benutzer stellt die Attribute benutzername, passwort, name, adresse, firmenname,
 * eMail, telefon und telefonMobil für die Unterklassen Analyst, Kunde und
 * Administrator bereit.
 * 
 * @author Manuel Weber
 */
@MappedSuperclass
@ManagedBean
@ApplicationScoped
public class Benutzer implements Serializable {

	private static final long serialVersionUID = 6766128247027122668L;
	protected String accountart;

	@Id 
	protected   String benutzername;
	
	protected String passwort;
	protected String name;
	protected String adresse;
	protected String firmenname;
	protected String eMail;
	protected String telefon;
	protected String telefonMobil;
	protected Set<Projekt> projekte;
	
	/* Getter-Methoden */
	
	public String getBenutzername() {
		return benutzername;
	}
	public String getPasswort() {
		return passwort;
	}
	public String getName() {
		return name;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getFirmenname() {
		return firmenname;
	}
	public String geteMail() {
		return eMail;
	}
	public String getTelefon() {
		return telefon;
	}
	public String getTelefonMobil() {
		return telefonMobil;
	}

	public Set<Projekt> getProjekte() {
		return projekte;
	}

	public void setProjekte(Set<Projekt> projekte) {
		this.projekte = projekte;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setFirmenname(String firmenname) {
		this.firmenname = firmenname;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public void setTelefonMobil(String telefonMobil) {
		this.telefonMobil = telefonMobil;
	}

	public String getAccountart() {
		return accountart;
	}

	public void setAccountart(String accountart) {
		this.accountart = accountart;
	}
	
}
