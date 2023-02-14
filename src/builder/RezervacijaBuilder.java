/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import entiteti.Korisnik;
import entiteti.Objekat;
import entiteti.Rezervacija;

/**
 *
 * @author PC
 */
public class RezervacijaBuilder {

    private Rezervacija rezervacija;

    public RezervacijaBuilder() {
        this.rezervacija = new Rezervacija();
    }

    public RezervacijaBuilder rezervacija_id(int rezervacija_id) {
        this.rezervacija.setRezervacija_id(rezervacija_id);
        return this;
    }

    public RezervacijaBuilder vreme(String vreme) {
        this.rezervacija.setVreme(vreme);
        return this;
    }

    public RezervacijaBuilder brojSediste(int brojSedista) {
        this.rezervacija.setBrojSediste(brojSedista);
        return this;
    }

    public RezervacijaBuilder metodPlacanja(String placanje) {
        this.rezervacija.setMetodPlacanja(placanje);
        return this;
    }

    public RezervacijaBuilder Korisnik(Korisnik korisnik) {
        this.rezervacija.setKorisnik(korisnik);
        return this;
    }

    public RezervacijaBuilder Objekat(Objekat objekat) {
        this.rezervacija.setObjekat(objekat);
        return this;
    }

    public Rezervacija build() {
        return this.rezervacija;
    }
}
