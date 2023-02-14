package entiteti;

/**
 * *********************************************************************
 * Module: Admin.java Author: user Purpose: Defines the Class Admin
 * *********************************************************************
 */
import entiteti.Korisnik;
import java.util.*;

/**
 * @pdOid 5779bb2e-4530-4402-9453-3993836d8236
 */
public class Admin extends Korisnik {

    /**
     * @pdOid e34c175b-7ea3-4bf4-bc75-60de122724fa
     */
    public Admin() {
        // TODO: implement
    }

    public Admin(String username, String password, String bankovniRacun, String adresa) {
        super(username, password, bankovniRacun, adresa);
    }

    @Override
    public String toString() {
        return "Admin{" + '}';
    }

}
