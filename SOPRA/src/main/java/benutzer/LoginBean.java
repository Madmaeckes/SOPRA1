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

    /**
     * Prüft eingegebene Login-Daten auf Gültigkeit und Accountart.
     * @return
     */
    public String login() {
    	
    	List<Benutzer> benutzer = Datenbank.getBenutzer();
    	System.out.println("(" + benutzer.size() + " Benutzer in DB)");
    	for (Benutzer b : benutzer){
    		if(benutzername.compareTo(b.getBenutzername()) == 0) {
    			System.out.println("Benutzer gefunden: " + benutzername);
    			if(passwort.compareTo(b.getPasswort()) == 0) {
    				System.out.println("eingeloggt als " + b.accountart);
    				return b.accountart;
    			}
    			System.out.println("falsches Passwort");
    			return "ungueltig";
    		}
    	}
    	
    	System.out.println("Benutzer nicht gefunden: " + benutzername);
    	return "ungueltig";
//    	if ((benutzername.compareTo("Manuel") == 0) && (passwort.compareTo("lol") == 0)){
//    		
//    		return "login";
//    	} else {
//    		System.out.println("ungueltig: " + benutzername );
//    		return "ungueltig";
//    	}
    }
    
    public String getBenutzername ()
    {
        return benutzername;
    }


    public void setBenutzername (final String benutzername)
    {
        this.benutzername = benutzername;
    }


    public String getPasswort ()
    {
        return passwort;
    }


    public void setPasswort (final String passwort)
    {
        this.passwort = passwort;
    }
}