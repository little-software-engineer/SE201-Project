package entiteti;

/**
 * *********************************************************************
 * Module: Zaposleni.java Author: user Purpose: Defines the Class Zaposleni
 * *********************************************************************
 */
import entiteti.Korisnik;
import java.util.*;

/**
 * @pdOid be44b9f9-a40a-4587-bf21-2515ddcd0dc1
 */
public class Zaposleni extends Korisnik {

    /**
     * @pdOid 7301f9f6-5f0f-41c2-b944-9c71192f4979
     */
    private String ime;
    /**
     * @pdOid 3f40dc7f-93e7-4421-9b1e-db0c8a27969b
     */
    private String prezime;
    /**
     * @pdOid 2af5a9af-597e-44d3-a69c-e63c08346bed
     */
    private int plata;

    /**
     * @pdOid 664f9a61-43b0-44cd-8c08-554cfcf88d24
     */
    public Zaposleni() {
        // TODO: implement
    }

    public Zaposleni(String ime, String prezime, int plata) {
        this.ime = ime;
        this.prezime = prezime;
        this.plata = plata;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getPlata() {
        return plata;
    }

    public void setPlata(int plata) {
        this.plata = plata;
    }

    @Override
    public String toString() {
        return "Zaposleni{" + "ime=" + ime + ", prezime=" + prezime + ", plata=" + plata + '}';
    }

}
