package entiteti;

/**
 * *********************************************************************
 * Module: Korisnik.java Author: user Purpose: Defines the Class Korisnik
 * *********************************************************************
 */
import java.util.*;

/**
 * @pdOid b94ecc1b-ac55-4500-8027-e3325e28e6ef
 */
public class Korisnik {

    /**
     * @pdOid e8766e0b-c13d-4b4b-a1d0-232b6e3ae703
     */
    private String username;
    /**
     * @pdOid 48de228c-40e2-4f29-a1a2-cb366f7c8b90
     */
    private String password;
    /**
     * @pdOid c2219442-2f40-458d-a891-017689184e48
     */
    private String bankovniRacun;
    /**
     * @pdOid 26a65fde-6fd1-4ffe-aed1-728cd2c31cf8
     */
    private String adresa;

    private int id;
    private int tip_korisnika;

    /**
     * @pdRoleInfo migr=no name=Rezervacija assc=association4
     * coll=java.util.Collection impl=java.util.HashSet mult=0..*
     */
    public java.util.Collection<Rezervacija> rezervacija;

    /**
     * @pdOid 36fcf1ef-831b-4a72-b12b-436063b6fa74
     */
    public Korisnik() {
        // TODO: implement
    }

    public Korisnik(String username, String password, String bankovniRacun, String adresa, Collection<Rezervacija> rezervacija) {
        this.username = username;
        this.password = password;
        this.bankovniRacun = bankovniRacun;
        this.adresa = adresa;
        this.rezervacija = rezervacija;
    }

    public Korisnik(int id, String username, String password, String bankovniRacun, String adresa) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.bankovniRacun = bankovniRacun;
        this.adresa = adresa;

    }

    public Korisnik(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Korisnik(String username, String password, String bankovniRacun, String adresa) {
        this.username = username;
        this.password = password;
        this.bankovniRacun = bankovniRacun;
        this.adresa = adresa;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @pdOid 6862f1a8-1bd4-4487-abbe-5e3f58231e55
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param newUsername
     * @pdOid f2f0f6ad-f80f-4738-a745-a20e8ea1503b
     */
    public void setUsername(String newUsername) {
        username = newUsername;
    }

    public int getTip_korisnika() {
        return tip_korisnika;
    }

    public void setTip_korisnika(int tip_korisnika) {
        this.tip_korisnika = tip_korisnika;
    }

    /**
     * @pdOid 94b38a10-bff9-4bc0-acd7-852d452ab6cf
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param newPassword
     * @pdOid e290f4b7-d41a-441a-bc15-0c8563702510
     */
    public void setPassword(String newPassword) {
        password = newPassword;
    }

    /**
     * @pdOid 28871aab-f2d3-479f-8f58-fd22091695ce
     */
    public String getBankovniRacun() {
        return bankovniRacun;
    }

    /**
     * @param newBankovniRacun
     * @pdOid 349514c1-5a70-4eb5-851b-5d9cdca95838
     */
    public void setBankovniRacun(String newBankovniRacun) {
        bankovniRacun = newBankovniRacun;
    }

    /**
     * @pdOid bf785f81-8ac3-4f65-bd73-a10545d22525
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * @param newAdresa
     * @pdOid 46044603-680d-4dd7-b486-99d6c0155d79
     */
    public void setAdresa(String newAdresa) {
        adresa = newAdresa;
    }

    /**
     * @pdGenerated default getter
     */
    public java.util.Collection<Rezervacija> getRezervacija() {
        if (rezervacija == null) {
            rezervacija = new java.util.HashSet<Rezervacija>();
        }
        return rezervacija;
    }

    /**
     * @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorRezervacija() {
        if (rezervacija == null) {
            rezervacija = new java.util.HashSet<Rezervacija>();
        }
        return rezervacija.iterator();
    }

    /**
     * @pdGenerated default setter
     * @param newRezervacija
     */
    public void setRezervacija(java.util.Collection<Rezervacija> newRezervacija) {
        removeAllRezervacija();
        for (java.util.Iterator iter = newRezervacija.iterator(); iter.hasNext();) {
            addRezervacija((Rezervacija) iter.next());
        }
    }

    /**
     * @pdGenerated default add
     * @param newRezervacija
     */
    public void addRezervacija(Rezervacija newRezervacija) {
        if (newRezervacija == null) {
            return;
        }
        if (this.rezervacija == null) {
            this.rezervacija = new java.util.HashSet<Rezervacija>();
        }
        if (!this.rezervacija.contains(newRezervacija)) {
            this.rezervacija.add(newRezervacija);
        }
    }

    /**
     * @pdGenerated default remove
     * @param oldRezervacija
     */
    public void removeRezervacija(Rezervacija oldRezervacija) {
        if (oldRezervacija == null) {
            return;
        }
        if (this.rezervacija != null) {
            if (this.rezervacija.contains(oldRezervacija)) {
                this.rezervacija.remove(oldRezervacija);
            }
        }
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllRezervacija() {
        if (rezervacija != null) {
            rezervacija.clear();
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "username=" + username + ", password=" + password + ", bankovniRacun=" + bankovniRacun + ", adresa=" + adresa + ", id=" + id + ", tip_korisnika=" + tip_korisnika + '}';
    }

}
