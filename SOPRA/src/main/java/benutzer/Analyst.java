package benutzer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.faces.bean.*;
import javax.persistence.*;

import extern.Datenbank;
import projektelemente.Abnahmestatus;
import projektelemente.Anforderung;
import projektelemente.Projekt;

/**
 * 
 * 
 */
@Entity
@ManagedBean
@ApplicationScoped
public class Analyst extends Benutzer {

	private static final long serialVersionUID = 3101351853678793162L;

	@OneToMany(mappedBy = "analyst")
	private Set<Projekt> projekte;

	public Analyst() {
		this.accountart = "Analyst";
		this.projekte = new HashSet<Projekt>();
	}

	/**
	 * Die Methode erlaubt es dem Analyst ein neues Projekt zu erstellen. Dabei
	 * wird der Methode ein Name f�r das Projekt �bergeben. Existiert der
	 * gew�hlte Projektname noch nicht, wird ein neues Objekt vom Typ Projekt
	 * mit dem �bergebenen Namen erzeugt.
	 * 
	 * @param bezeichnung
	 * @return
	 */
	public Projekt projektErstellen(String bezeichnung)
			throws IllegalArgumentException {
		if (bezeichnung == null)
			throw new IllegalArgumentException(
					"Die Bezeichnung des Projektes darf nicht null sein");

		Iterator<Projekt> i = Datenbank.getProjekte()
				.iterator();
		while (i.hasNext()) {
			if (i.next()
					.getBezeichnung() == bezeichnung)
				throw new IllegalArgumentException(
						"Es existiert bereits ein Projekt mit der"
								+ " uebergebenen Bezeichnung: "
								+ bezeichnung);
		}
		try {
			Projekt p = new Projekt();
			p.setBezeichnung(bezeichnung);
			p.setAnalyst(this);
			this.projekte.add(p);
			Datenbank.save(this);
			Datenbank.save(p);
			System.out.println("neues Projekt erstellt: " + bezeichnung);
			return p;
		} catch (Exception e) {
			System.out.println("Projekt konnte nicht erstellt werden: "
					+ e.getMessage());
			return null;
		}
	}

	/**
	 * Mit dieser Methode wird ein Kunde dem Projekt zugewiesen. Jedem Projekt
	 * kann maximal ein Kunde zugewiesen werden. Dabei wird jeweils ein Objekt
	 * der Klassen Kunde und Projekt der Methode �bergeben. Der Analyst ist
	 * allen Projekten, die er selbst erstellt hat, automatisch zugewiesen.
	 * 
	 * @param kunde
	 * @param projekt
	 * @throws IllegalArgumentException
	 *             wenn kein Kunde / kein Projekt �bergeben wird
	 */
	public void kundeHinzuf�gen(Kunde kunde, Projekt projekt)
			throws IllegalArgumentException {
		if (kunde == null)
			throw new IllegalArgumentException("Kein Kunde �bergeben");
		if (projekt == null)
			throw new IllegalArgumentException("Kein Projekt �bergeben");

		projekt.setKunde(kunde);
		System.out.println("Kunde " + kunde.getBenutzername()
				+ " wurde zum Projekt " + projekt.getBezeichnung()
				+ " hinzugefuegt");
	}

	/**
	 * Mit dieser Methode hat der Analyst die M�glichkeit, ein bereits
	 * abgeschlossenes Projekt zu kopieren, um es evtl. zu erweitern. Dabei wird
	 * eine neue Instanz der Klasse Projekt erzeugt. Die Methode ben�tigt als
	 * Parameter ein abgeschlossenes Projekt und eine Projektbezeichnung f�r die
	 * Kopie als String, welche noch nicht existieren darf.
	 * 
	 * @param projekt
	 *            welches kopiert werden soll
	 * @param bezeichnung
	 *            des erzugten Projektes
	 * 
	 * @throws IllegalArgumentException
	 *             wenn kein Projekt / keine Bezeichnung �bergeben wird oder die
	 *             gew�hlte Bezeichnung bereits vergeben ist
	 */
	public Projekt projektKopieren(Projekt projekt, String bezeichnung)
			throws IllegalArgumentException {
		if (projekt == null)
			throw new IllegalArgumentException("Kein Projekt �bergeben");

		Projekt p = projektErstellen(bezeichnung);
		p.setAnforderungen(projekt.getAnforderungen());
		p.setBegriffslexikon(projekt.getBegriffslexikon());
		for (Anforderung a : p.getAnforderungen()) {
			a.setAbnahmestatus(Abnahmestatus.offen);
		}
		return p;
	}

	/* Getter- Und Setter-Methoden */

	public Set<Projekt> getProjekte() {
		return projekte;
	}

	public void setProjekte(Set<Projekt> projekte) {
		this.projekte = projekte;
	}

}