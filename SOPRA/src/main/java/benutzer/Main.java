package benutzer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import extern.Datenbank;


public class Main {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SOPRA");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		
		Kunde a = new Kunde();
		a.setBenutzername("Gandalf");
		a.setAdresse("Auenland");
		a.setName("Gandalf");
		a.setPasswort("pw1");
		
		Datenbank.save(a);
		
		System.out.println(a.benutzername);

	}

	public static void test(String s) {
		System.out.println(s);
	}
}
