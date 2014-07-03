import java.util.Iterator;

import extern.Datenbank;
import projektelemente.Projekt;
import benutzer.Analyst;
import benutzer.Kunde;


public class Test {
	/**
	 * Testkommentar
	 * @param args
	 */

	public static void main(String[] args) {

		Analyst a = Datenbank.getAnalysten().get(0);
		Projekt p = a.projektErstellen("P1");
		Kunde k = Datenbank.getKunden().get(0);
		a.kundeHinzufügen(k, p);
		p.anforderungHinzufuegen("anforderung1");
		
		//Projekt-Abfrage
		Iterator<Projekt> i = Datenbank.getAnalysten().get(0).getProjekte().iterator();
		System.out.println(i.next().getBezeichnung());
	}

}
