import projektelemente.Anforderung;
import projektelemente.Projekt;
import extern.Datenbank;
import benutzer.Analyst;


public class ProjektErstellen {
	/**
	 * test
	 * @param args
	 * @throws Exception
	 */

	public static void main(String[] args) throws Exception {

		Analyst a = Datenbank.getAnalysten().get(0);
		Projekt p = a.projektErstellen("D�ner Projekt");
		p.anforderungHinzufuegen("Brot");
		System.out.println(p.getBezeichnung());
		Anforderung a1 = p.anforderungHinzufuegen("Der Ger�t");
		a1.beschreiben("schneidet das D�nerfleisch schwei�frei");
		
	}

}
