/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import entiteti.Korisnik;
import entiteti.Objekat;
import entiteti.Rezervacija;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import builder.RezervacijaBuilder;

/**
 *
 * @author PC
 */
public class DBKontroler {

    public DBKontroler() {

    }

    //Korisnik
    public ArrayList<Korisnik> listaKorisnika() throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();
        String upit = "SELECT * FROM `korisnik` ";
        PreparedStatement ps = kon.prepareStatement(upit);

        ResultSet rs = ps.executeQuery();
        ArrayList<Korisnik> lista = new ArrayList<>();
        while (rs.next()) {

            lista.add(new Korisnik(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }

        kon.close();
        return lista;
    }

    public void dodajKorisnika(Korisnik k) throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();

        String upit = "INSERT INTO korisnik (username, password, bankovni_racun, adresa) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = kon.prepareStatement(upit);

        ps.setString(1, k.getUsername());
        ps.setString(2, k.getPassword());
        ps.setString(3, k.getBankovniRacun());
        ps.setString(4, k.getAdresa());

        ps.executeUpdate();
        kon.close();

    }

    public void obrisiKorisnika(String username) throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();

        String upit = "Delete FROM korisnik where username = ? ";
        PreparedStatement ps = kon.prepareStatement(upit);
        ArrayList<Korisnik> lista = listaKorisnika();

        ps.setString(1, username);
        ps.executeUpdate();
        kon.close();

    }

    public void izmeniKorisnika(Korisnik k, String username) throws ClassNotFoundException, SQLException {

        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();

        String upit = "UPDATE korisnik SET username = ?, password = ?, bankovni_racun = ?, adresa = ? WHERE username = '" + username + "';";
        PreparedStatement ps = kon.prepareStatement(upit);

        ps.setString(1, k.getUsername());
        ps.setString(2, k.getPassword());
        ps.setString(3, k.getBankovniRacun());
        ps.setString(4, k.getAdresa());

        ps.executeUpdate();
        kon.close();

    }

    public ArrayList<Korisnik> prijavljeniKorisnik(String username, String password) throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();
        String upit = "SELECT * FROM `korisnik` WHERE username = '" + username + "' AND password = '" + password + "'";
        PreparedStatement ps = kon.prepareStatement(upit);

        ResultSet rs = ps.executeQuery();
        ArrayList<Korisnik> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Korisnik(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }

        kon.close();
        return lista;
    }

    public boolean usernameProvera(String username) throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();
        String upit = "SELECT username,password FROM `korisnik` WHERE username = '" + username + "'";
        PreparedStatement ps = kon.prepareStatement(upit);

        ResultSet rs = ps.executeQuery();
        ArrayList<Korisnik> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Korisnik(rs.getString(1), rs.getString(2)));
        }
        boolean provera = false;
        for (int i = 0; i < lista.size(); i++) {
            if (username.equals(lista.get(i).getUsername().replaceAll("\\s", ""))) {
                provera = true;
            }
        }

        kon.close();
        return provera;
    }

    public void KorisnikTabel(TableView tv) throws ClassNotFoundException, SQLException {

        //TableView tv = new TableView();
        //uzimanje vrednosti iz baze 
        ArrayList<Korisnik> p = listaKorisnika();
        //KOLONE

        TableColumn<Korisnik, String> column1 = new TableColumn("Username");
        column1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getUsername() + ""));

        TableColumn<Korisnik, String> column2 = new TableColumn("Password");
        column2.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getPassword() + ""));

        TableColumn<Korisnik, String> column3 = new TableColumn("Bankovni racun");
        column3.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getBankovniRacun() + ""));

        TableColumn<Korisnik, String> column4 = new TableColumn("Adresa");
        column4.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getAdresa() + ""));

        tv.getColumns().add(column1);
        tv.getColumns().add(column2);
        tv.getColumns().add(column3);
        tv.getColumns().add(column4);

        tv.getItems().addAll(p);
    }

    //Objekti
    public ArrayList<Objekat> listaObjekata() throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();
        String upit = "SELECT * FROM `objekat` ";
        PreparedStatement ps = kon.prepareStatement(upit);

        ResultSet rs = ps.executeQuery();
        ArrayList<Objekat> lista = new ArrayList<>();
        while (rs.next()) {

            lista.add(new Objekat(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
        }

        kon.close();
        return lista;
    }

    public void ObjekatTabel(TableView tv) throws ClassNotFoundException, SQLException {

        //TableView tv = new TableView();
        //uzimanje vrednosti iz baze 
        ArrayList<Objekat> p = listaObjekata();
        //KOLONE

        TableColumn<Objekat, String> column1 = new TableColumn("Naziv");
        column1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getNaziv() + ""));

        TableColumn<Objekat, String> column2 = new TableColumn("Adresa");
        column2.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getAdresa() + ""));

        TableColumn<Objekat, String> column3 = new TableColumn("Grad");
        column3.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getGrad() + ""));

        TableColumn<Objekat, String> column4 = new TableColumn("Tip");
        column4.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getTip() + ""));

        TableColumn<Objekat, String> column5 = new TableColumn("Kapacitet");
        column5.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getKapacitet() + ""));

        tv.getColumns().add(column1);
        tv.getColumns().add(column2);
        tv.getColumns().add(column3);
        tv.getColumns().add(column4);
        tv.getColumns().add(column5);

        tv.getItems().addAll(p);
    }

    public ArrayList<Objekat> filtriraj(String grad, String tip, int kapacitet) throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();
        String upit = "SELECT * FROM `objekat` WHERE grad LIKE '" + grad + "%' AND tip LIKE '" + tip + "%' and kapacitet >= '" + kapacitet + "'";
        PreparedStatement ps = kon.prepareStatement(upit);

        ResultSet rs = ps.executeQuery();
        ArrayList<Objekat> lista = new ArrayList<>();
        while (rs.next()) {

            lista.add(new Objekat(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
        }

        kon.close();
        return lista;
    }

    public boolean raspolozivoStanje(Objekat o, int brojSedista) throws ClassNotFoundException, SQLException {

        DBKontroler dbKontr = new DBKontroler();
        if (brojSedista <= (o.getKapacitet() - dbKontr.ukupnoRezervisano(o)) && brojSedista > 0) {
            System.out.println((o.getKapacitet() - dbKontr.ukupnoRezervisano(o)));
            return true;
        } else {
            return false;
        }
    }

    //REZERVACIJA
    public ArrayList<Rezervacija> listaRezervacija(Korisnik kor) throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();
        String upit = "SELECT * FROM rezervacija INNER JOIN korisnik ON rezervacija.id_korisnik = korisnik.id_korisnik INNER JOIN objekat ON rezervacija.id_objekat = objekat.id_objekat WHERE korisnik.id_korisnik = '" + kor.getId() + "' ORDER BY rezervacija.id ASC";
        PreparedStatement ps = kon.prepareStatement(upit);

        ResultSet rs = ps.executeQuery();
        ArrayList<Rezervacija> lista = new ArrayList<>();
        while (rs.next()) {
            Objekat o = new Objekat(rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getInt(17));
            Korisnik k = new Korisnik(rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));

            lista.add(new RezervacijaBuilder()
                    .rezervacija_id(rs.getInt(1))
                    .Korisnik(k)
                    .Objekat(o)
                    .vreme(rs.getString(4))
                    .brojSediste(rs.getInt(5))
                    .metodPlacanja(rs.getString(6))
                    .build());

        }

        kon.close();
        return lista;
    }

    public void dodajRezervaciju(Rezervacija r) throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();

        String upit = "INSERT INTO rezervacija (id_korisnik, id_objekat, vreme, brojSediste, metodPlacanja) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = kon.prepareStatement(upit);

        ps.setInt(1, r.getKorisnik().getId());
        ps.setInt(2, r.getObjekat().getId());
        ps.setString(3, r.getVreme());
        ps.setInt(4, r.getBrojSediste());
        ps.setString(5, r.getMetodPlacanja());

        ps.executeUpdate();
        kon.close();

    }

    public int ukupnoRezervisano(Objekat o) throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();
        String upit = "SELECT SUM(rezervacija.brojSediste) as ukupno FROM rezervacija INNER JOIN objekat ON rezervacija.id_objekat = objekat.id_objekat WHERE objekat.id_objekat = '" + o.getId() + "' ORDER BY rezervacija.id ASC";
        PreparedStatement ps = kon.prepareStatement(upit);

        ResultSet rs = ps.executeQuery();
        int ukupno = 0;
        while (rs.next()) {

            ukupno = rs.getInt(1);
        }

        kon.close();
        return ukupno;
    }

    public void RezervacijaTabel(TableView tv, Korisnik kor) throws ClassNotFoundException, SQLException {

        //TableView tv = new TableView();
        //uzimanje vrednosti iz baze 
        ArrayList<Rezervacija> p = listaRezervacija(kor);
        //KOLONE

        TableColumn<Rezervacija, String> column1 = new TableColumn("id");
        column1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getRezervacija_id() + ""));

        TableColumn<Rezervacija, String> column2 = new TableColumn("Korisnik");
        column2.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getKorisnik().getId() + ""));

        TableColumn<Rezervacija, String> column3 = new TableColumn("Objekat");
        column3.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getObjekat().getId() + ""));

        TableColumn<Rezervacija, String> column4 = new TableColumn("Vreme");
        column4.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getVreme() + ""));

        TableColumn<Rezervacija, String> column5 = new TableColumn("Broj sedista");
        column5.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getBrojSediste() + ""));

        TableColumn<Rezervacija, String> column6 = new TableColumn("Metod placanja");
        column6.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getMetodPlacanja() + ""));

        tv.getColumns().add(column1);
        tv.getColumns().add(column2);
        tv.getColumns().add(column3);
        tv.getColumns().add(column4);
        tv.getColumns().add(column5);
        tv.getColumns().add(column6);

        tv.getItems().addAll(p);
    }
}
