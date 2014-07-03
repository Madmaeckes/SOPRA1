import projektelemente.Anforderung;
import projektelemente.Projekt;
import extern.Datenbank;
import benutzer.Analyst;


public class ProjektErstellen {

	public static void main(String[] args) throws Exception {

		Analyst a = Datenbank.getAnalysten().get(0);
		Projekt p = a.projektErstellen("Döner Projekt");
		p.anforderungHinzufuegen("Brot");
		System.out.println(p.getBezeichnung());
		Anforderung a1 = p.anforderungHinzufuegen("Der Gerät");
		a1.beschreiben("schneidet das Dönerfleisch schweißfrei");
		
	}

}
