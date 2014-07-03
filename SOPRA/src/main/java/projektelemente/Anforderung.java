package projektelemente;

import java.util.ArrayList;
import java.util.Set;

import javax.faces.bean.*;
import javax.persistence.*;

import extern.Datenbank;

/**
 * 
 * 
 */
@Entity
@ManagedBean
@ApplicationScoped
public class Anforderung {

	@Id
	private String bezeichnung;

	@ManyToOne
	private Projekt projekt;

	private Prioritaet prioritaet;
	private String beschreibungsentwurf;
	private Abnahmestatus abnahmestatus;
	@OneToMany(mappedBy = "anforderung")
	private Set<Beschreibung> beschreibungen;
	@OneToMany(mappedBy = "alternativeZu")
	private Set<Anforderung> alternativen;
	@ManyToOne
	private Anforderung alternativeZu;

	/**
	 * Der Methode wird ein String übergeben. Sie erzeugt daraufhin ein neues
	 * Objekt vom Typ Beschreibung, das der Anforderung zugeordnet ist und den
	 * übergebenen String als Beschreibungstext annimmt. Daraufhin wird dem
	 * betroffenen Kunden eine Mitteilung per E-Mail gesendet. Hierfür wird auf
	 * die Klasse Benachrichtigung zurückgegriffen.
	 * 
	 * @param beschreibung
	 * 
	 * @throws IllegalArgumentException
	 *             wenn kein Beschreibungstext übergeben wird
	 * @throws Exception
	 *             wenn der Abnahmestatus der Anforderun nicht "offen" ist
	 */
	public void beschreiben(String beschreibungstext) throws Exception {
		if (beschreibungstext == null)
			throw new IllegalArgumentException("kein Beschreibungstext uebergeben");
		if (abnahmestatus != Abnahmestatus.offen)
			throw new Exception("Einer nicht-offenen Anforderung kann "
					+ "keine Beschreibung hinzugefuegt werden");
		Beschreibung b = new Beschreibung();
		b.setText(beschreibungstext);
		b.setAnforderung(this);
		b.setBewertung(0);
		beschreibungen.add(b);
		Datenbank.save(this);
		Datenbank.save(b);
		System.out.println("Beschreibung hinzugefügt");
	}

	/**
	 * Der Methode wird ein Boolean übergeben, ob die Anforderung akzeptiert
	 * oder abgelehnt wurde, woraufhin der Abnahmestatus der Anforderung
	 * entsprechend geändert wird.
	 * 
	 * @param abgenommen
	 */
	public void abnehmen(boolean abgenommen) {

	}

	/**
	 * Vergleicht die Zeitstempel aller, der Anforderung zugeordneten,
	 * Beschreibungen und gibt die Aktuellste zurück.
	 * 
	 * @return Beschreibung
	 */
	public Beschreibung getAktuelleBeschreibung() {

		return null;

	}

	/* Getter- und Setter-Methoden */


	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public Projekt getProjekt() {
		return projekt;
	}

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}

	public Prioritaet getPrioritaet() {
		return prioritaet;
	}

	public void setPrioritaet(Prioritaet prioritaet) {
		this.prioritaet = prioritaet;
	}

	public String getBeschreibungsentwurf() {
		return beschreibungsentwurf;
	}

	public void setBeschreibungsentwurf(String beschreibungsentwurf) {
		this.beschreibungsentwurf = beschreibungsentwurf;
	}

	public Abnahmestatus getAbnahmestatus() {
		return abnahmestatus;
	}

	public void setAbnahmestatus(Abnahmestatus abnahmestatus) {
		this.abnahmestatus = abnahmestatus;
	}

	public Set<Anforderung> getAlternativen() {
		return alternativen;
	}

	public void setAlternativen(Set<Anforderung> alternativen) {
		this.alternativen = alternativen;
	}

	public Anforderung getAlternativeZu() {
		return alternativeZu;
	}

	public void setAlternativeZu(Anforderung alternativeZu) {
		this.alternativeZu = alternativeZu;
	}

	public Set<Beschreibung> getBeschreibungen() {
		return beschreibungen;
	}

	public void setBeschreibungen(Set<Beschreibung> beschreibungen) {
		this.beschreibungen = beschreibungen;
	}

}