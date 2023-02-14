package entiteti;

/**
 * *********************************************************************
 * Module: Rezervacija.java Author: user Purpose: Defines the Class Rezervacija
 * *********************************************************************
 */
import builder.RezervacijaBuilder;
import java.util.*;

/**
 * @pdOid b8b429ba-c74b-4b5c-bec2-79bd82928fb3
 */
public class Rezervacija {

    /**
     * @pdOid 363c3acf-d83d-4f90-b8c1-5134a827a6f3
     */
    private int rezervacija_id;
    private String vreme;
    private Objekat objekat;
    /**
     * @pdOid 7a72335d-1465-42ae-9ed7-adf3b89245c2
     */
    private int brojSediste;
    /**
     * @pdOid 07277bcd-f87a-47c2-9786-8df79da7187e
     */
    private String metodPlacanja;
    /**
     * @pdOid f1d146be-c4be-47b2-8230-9f441ee17e1e
     */

    private Korisnik korisnik;

    public Rezervacija(int rezervacija_id, String vreme, Objekat objekat, int brojSediste, String metodPlacanja, Korisnik korisnik) {
        this.rezervacija_id = rezervacija_id;
        this.vreme = vreme;
        this.objekat = objekat;
        this.brojSediste = brojSediste;
        this.metodPlacanja = metodPlacanja;

        this.korisnik = korisnik;
    }

    /**
     * @pdRoleInfo migr=no name=RezervacijaBuilder assc=rezervacija
     * coll=java.util.Collection impl=java.util.HashSet mult=0..*
     */
    public java.util.Collection<RezervacijaBuilder> rezervacijaBuilder;

    /**
     * @pdOid 14a5eaf3-2191-4d40-a368-21d3e77af676
     */
    public Rezervacija() {
        // TODO: implement
    }

    public int getRezervacija_id() {
        return rezervacija_id;
    }

    public void setRezervacija_id(int rezervacija_id) {
        this.rezervacija_id = rezervacija_id;
    }

    /**
     * @pdGenerated default getter
     */
    public java.util.Collection<RezervacijaBuilder> getRezervacijaBuilder() {
        if (rezervacijaBuilder == null) {
            rezervacijaBuilder = new java.util.HashSet<RezervacijaBuilder>();
        }
        return rezervacijaBuilder;
    }

    public Objekat getObjekat() {
        return objekat;
    }

    public void setObjekat(Objekat objekat) {
        this.objekat = objekat;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    /**
     * @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorRezervacijaBuilder() {
        if (rezervacijaBuilder == null) {
            rezervacijaBuilder = new java.util.HashSet<RezervacijaBuilder>();
        }
        return rezervacijaBuilder.iterator();
    }

    /**
     * @pdGenerated default setter
     * @param newRezervacijaBuilder
     */
    public void setRezervacijaBuilder(java.util.Collection<RezervacijaBuilder> newRezervacijaBuilder) {
        removeAllRezervacijaBuilder();
        for (java.util.Iterator iter = newRezervacijaBuilder.iterator(); iter.hasNext();) {
            addRezervacijaBuilder((RezervacijaBuilder) iter.next());
        }
    }

    /**
     * @pdGenerated default add
     * @param newRezervacijaBuilder
     */
    public void addRezervacijaBuilder(RezervacijaBuilder newRezervacijaBuilder) {
        if (newRezervacijaBuilder == null) {
            return;
        }
        if (this.rezervacijaBuilder == null) {
            this.rezervacijaBuilder = new java.util.HashSet<RezervacijaBuilder>();
        }
        if (!this.rezervacijaBuilder.contains(newRezervacijaBuilder)) {
            this.rezervacijaBuilder.add(newRezervacijaBuilder);
        }
    }

    /**
     * @pdGenerated default remove
     * @param oldRezervacijaBuilder
     */
    public void removeRezervacijaBuilder(RezervacijaBuilder oldRezervacijaBuilder) {
        if (oldRezervacijaBuilder == null) {
            return;
        }
        if (this.rezervacijaBuilder != null) {
            if (this.rezervacijaBuilder.contains(oldRezervacijaBuilder)) {
                this.rezervacijaBuilder.remove(oldRezervacijaBuilder);
            }
        }
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllRezervacijaBuilder() {
        if (rezervacijaBuilder != null) {
            rezervacijaBuilder.clear();
        }
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public int getBrojSediste() {
        return brojSediste;
    }

    public void setBrojSediste(int brojSediste) {
        this.brojSediste = brojSediste;
    }

    public String getMetodPlacanja() {
        return metodPlacanja;
    }

    public void setMetodPlacanja(String metodPlacanja) {
        this.metodPlacanja = metodPlacanja;
    }

}
