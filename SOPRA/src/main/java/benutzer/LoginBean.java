package benutzer;

import java.util.List;

import javax.faces.bean.*;

import extern.Datenbank;

/**
 * LoginBean.java
 * 
 */
@ManagedBean
@SessionScoped
public class LoginBean {

	private String benutzername;
	private String passwort;
	private Benutzer benutzer;

	/**
	 * Prüft eingegebene Login-Daten auf Gültigkeit und Accountart.
	 * 
	 * @return "ungueltig" falls die Login-Daten ungültig sind / die Benutzerart
	 *         ("Analyst", "Kunde" oder "Administrator") im Falle eines
	 *         erfolgreichen Logins
	 */
	public String login() {

		List<Benutzer> benutzerliste = Datenbank.getBenutzer();
		System.out.println("(" + benutzerliste.size() + " Benutzer in DB)");
		for (Benutzer b : benutzerliste) {
			if (benutzername.compareTo(b.getBenutzername()) == 0) {
				System.out.println("Benutzer gefunden: " + benutzername);
				if (passwort.compareTo(b.getPasswort()) == 0) {
					System.out.println("eingeloggt als " + b.accountart);
					benutzer = b;
					return b.accountart;
				}
				System.out.println("falsches Passwort");
				return "ungueltig";
			}
		}

		System.out.println("Benutzer nicht gefunden: " + benutzername);
		return "ungueltig";
	}

	/* Getter- und Setter-Methoden */

	public String getBenutzername()
	{
		return benutzername;
	}

	public void setBenutzername(final String benutzername)
	{
		this.benutzername = benutzername;
	}

	public String getPasswort()
	{
		return passwort;
	}

	public void setPasswort(final String passwort)
	{
		this.passwort = passwort;
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

}