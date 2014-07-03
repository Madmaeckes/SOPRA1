package benutzer;

import java.lang.reflect.Array;

import javax.faces.bean.*;
import javax.persistence.Entity;

/**
 * 
 */
@Entity
@ManagedBean
@ApplicationScoped
public class Administrator extends Benutzer {
	
	private static final long serialVersionUID = -1767103015919421707L;
	
	public Administrator() {
		this.accountart = "Administrator";
	}
	/**
	 * Diese Methode erzeugt einen neuen Benutzer.
	 * Hierfür werden der gewünschte Benutzertyp (Analyst, Kunde oder
	 * Administrator) sowie die Benutzerdaten als Array übergeben. Dann wird
	 * sichergestellt, dass mindestens Benutzername, Passwort, E-Mail und
	 * Benutzertyp übergeben wurden und der Benutzername noch nicht vergeben
	 * ist. Die übrigen Benutzerdaten sind optional. Je nachdem welcher
	 * Benutzertyp angelegt werden soll, ruft die Methode nun den jeweiligen
	 * Konstruktor in einer der Klassen Analyst, Kunde und Administrator auf.
	 * Daraufhin werden die Pflichtattribute und alle zusätzlich gewählten
	 * jeweils per Setter-Methode gesetzt.
	 * 
	 * @param benutzerdaten
	 */
	public void benutzerAnlegen(Array benutzerdaten) {
		
	}
	
}
