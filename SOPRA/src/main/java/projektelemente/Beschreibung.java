package projektelemente;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.faces.bean.*;

import benutzer.Benutzer;

/**
 * Einer Beschreibung können mehrere Instanzen der Klasse Kommentar zugeordnet
 * sein. Instanzen der Klasse Beschreibung sind wiederrum genau einer
 * Anforderung zugeordnet. Beschreibungen besitzen einen Text, der in Form eines
 * Strings gespeichert ist, eine Bewertung als Integer-Wert und einen
 * Zeitstempel. Über die Methoden kommentieren() und bewerten(), können
 * Kommentare hinzugefügt, bzw. eine Bewertung festgelegt werden.
 * 
 * @author Manuel Weber
 * 
 */
@Entity
@ManagedBean
@ApplicationScoped
public class Beschreibung implements Serializable{

	private static final long serialVersionUID = 4145272280677827149L;

	@Id
	@Temporal(TemporalType.DATE)
	private Date zeitstempel;
	
	private String text;
	private int bewertung;
	
	@ManyToOne
	private Anforderung anforderung;
	@OneToMany(mappedBy = "beschreibung")
	private Set<Kommentar> kommentare;

	public Beschreibung() {
		this.zeitstempel = new Date();
	}
	
	/**
	 * Erzeugt einen neuen Kommentar. Hierfür wird ein String (Kommentartext)
	 * übergeben, sowie der Verfasser als Benutzer-Objekt, sodass ein Objekt der
	 * Klasse Kommentar erzeugt werden kann. Beim Erzeugen eines Kommentars wird
	 * dem betroffenen Gegenpart eine Benachrichtigung mittels E-Mail zugesandt.
	 * Hierfür wird auf die Klasse Benachrichtigung zurückgegriffen.
	 * 
	 * @param text
	 * @param autor
	 */
	public void kommentieren(String text, Benutzer autor) {

	}

	/**
	 * Die Methode erlaubt es Beschreibungen zu bewerten. Dabei wird ihr ein
	 * Integer-Wert übergeben, der sich auf einer Skala von 1-10 befindet.
	 * 
	 * @param bewertung
	 * @throws IllegalArgumentException
	 *             wenn der übergebene Wert nicht zwischen 1 und 10 liegt
	 */
	public void bewerten(int bewertung) {
		if (bewertung < 1 || bewertung > 10)
			throw new IllegalArgumentException("Bewertung liegt "
					+ "ausserhalb des gueltigen Wertebereichs [1,10]");
		this.bewertung = bewertung; 
	}

	/* Getter- und Setter-Methoden */

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getBewertung() {
		return bewertung;
	}

	public void setBewertung(int bewertung) {
		this.bewertung = bewertung;
	}

	public Date getZeitstempel() {
		return zeitstempel;
	}

	public void setZeitstempel(Date zeitstempel) {
		this.zeitstempel = zeitstempel;
	}

	public Anforderung getAnforderung() {
		return anforderung;
	}

	public void setAnforderung(Anforderung anforderung) {
		this.anforderung = anforderung;
	}

	public Set<Kommentar> getKommentare() {
		return kommentare;
	}

	public void setKommentare(Set<Kommentar> kommentare) {
		this.kommentare = kommentare;
	}

}
