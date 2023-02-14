package entiteti;

/**
 * *********************************************************************
 * Module: Lokal.java Author: user Purpose: Defines the Class Lokal
 * *********************************************************************
 */
import java.util.*;

/**
 * @pdOid 872f40b3-7e63-4d13-8dd7-089e8908098d
 */
public class Objekat {

    /**
     * @pdOid 5c61f7a4-d128-4f60-85e6-8b24cae567dd
     */
    private int id;
    private String naziv;
    /**
     * @pdOid 6a7d88a3-f726-4637-9df8-73525696f7c0
     */
    private String adresa;
    /**
     * @pdOid 498b5f00-d9fe-4453-addc-cd0800a42475
     */
    private String grad;
    /**
     * @pdOid 17f313e8-01ac-4e2f-91ca-440c46780ad7
     */
    private String tip;
    /**
     * @pdOid df2b8bcf-e80f-4c15-812c-2e8e4e4fdc22
     */
    private int kapacitet;

    /**
     * @pdRoleInfo migr=no name=Rezervacija assc=association8 mult=0..*
     * type=Composition side=A
     */
    public Rezervacija[] rezervacija;

    /**
     * @pdOid cb91ba33-8b8f-4d72-92d6-763b85e90ae1
     */
    public Objekat() {
        // TODO: implement
    }

    public Objekat(int id, String naziv, String adresa, String grad, String tip, int kapacitet) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.grad = grad;
        this.tip = tip;
        this.kapacitet = kapacitet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public Rezervacija[] getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija[] rezervacija) {
        this.rezervacija = rezervacija;
    }

    @Override
    public String toString() {
        return "Objekat{" + "id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + ", grad=" + grad + ", tip=" + tip + ", kapacitet=" + kapacitet + '}';
    }

}
