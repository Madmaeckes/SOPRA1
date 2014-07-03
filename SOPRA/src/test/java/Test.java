import java.util.Iterator;

import extern.Datenbank;
import projektelemente.Anforderung;
import projektelemente.Projekt;
import benutzer.Analyst;
import benutzer.Kunde;


public class Test {

	public static void main(String[] args) {

//		Analyst a = Datenbank.getAnalysten().get(0);
//		Projekt p = a.projektErstellen("P1");
//		Kunde k = Datenbank.getKunden().get(0);
//		a.kundeHinzufügen(k, p);
//		p.anforderungHinzufuegen("anforderung1");
//		
//		//Projekt-Abfrage
//		Iterator<Projekt> i = Datenbank.getAnalysten().get(0).getProjekte().iterator();
//		System.out.println(i.next().getBezeichnung());
		
	//	System.out.println(Datenbank.getProjekte().get(0).getAnalyst().getBenutzername());
		
		Datenbank.getProjekte().get(0).anforderungHinzufuegen("Anforderung1");
		Iterator<Anforderung> i = Datenbank.getProjekte().get(0).getAnforderungen().iterator();
	}

}
