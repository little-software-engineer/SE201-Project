/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guimeni;

import baza.DBKontroler;
import builder.RezervacijaBuilder;
import entiteti.Korisnik;
import entiteti.Objekat;
import java.sql.SQLException;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class RezervacijaGUI {

    public RezervacijaGUI(Korisnik prijvaljeniKor, Objekat o) throws ClassNotFoundException, SQLException {
        Stage primaryStage = new Stage();

        HBox main = new HBox(20);//glavni box u kojem su sa leve strane opcije a sa desne tabela

        VBox left = new VBox(35);//box sa leve strane u kojem su polja i opcije
        left.setAlignment(Pos.CENTER);

        DBKontroler tblRez = new DBKontroler();
        //kreiramo box u koji smestamo polja i tekstove
        HBox leftUp = new HBox(5);
        leftUp.setAlignment(Pos.CENTER);

        Label tekst1 = new Label("Vreme dolaska: ");
        TextField vreme = new TextField();
        Pattern pattern = Pattern.compile("\\d{0,2}|\\d+\\:\\d{0,2}")/*("\\d{0,2}")*/;
        TextFormatter formatter = new TextFormatter((UnaryOperator<TextFormatter.Change>) change -> {
            return pattern.matcher(change.getControlNewText()).matches() ? change : null;
        });
        vreme.setTextFormatter(formatter);

        Label tekst2 = new Label("Broj sedista:");
        TextField brojsedista = new TextField();
        Pattern pattern2 = Pattern.compile("\\d{0,2}|\\d{2}");
        TextFormatter formatter2 = new TextFormatter((UnaryOperator<TextFormatter.Change>) change -> {
            return pattern2.matcher(change.getControlNewText()).matches() ? change : null;
        });
        brojsedista.setTextFormatter(formatter2);

        Label tekst3 = new Label("Metod placanja:");
        TextField placanje = new TextField();

        //pravimo 2 box kako bi u jedan smestili tekstove a u drugi polja
        VBox tekst = new VBox(15);
        tekst.getChildren().addAll(tekst1, tekst2, tekst3);
        VBox polja = new VBox(6.5);
        polja.getChildren().addAll(vreme, brojsedista, placanje);

        leftUp.getChildren().addAll(tekst, polja);

        //box u koji smestamo opcije
        HBox leftMiddle = new HBox(20);
        Button rezervisi = new Button("Rezervisi");
        leftMiddle.getChildren().addAll(rezervisi);
        leftMiddle.setAlignment(Pos.CENTER);

        left.getChildren().addAll(leftUp, leftMiddle);

        //pravimo tabelu u kojoj cemo ispisivati podatke iz baze
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
        alert.setTitle("Program!");

        rezervisi.setOnAction(e -> {
            alert.setContentText("Da li zelite da rezervisete?");
            alert.showAndWait();
            try {
                if (alert.getResult() == ButtonType.YES && !vreme.getText().isEmpty() && !brojsedista.getText().isEmpty() && !placanje.getText().isEmpty()) {
                    if (tblRez.raspolozivoStanje(o, Integer.parseInt(brojsedista.getText())) == true) {
                        try {
                            tblRez.dodajRezervaciju(
                                    new RezervacijaBuilder()
                                            .Korisnik(prijvaljeniKor)
                                            .Objekat(o)
                                            .vreme(vreme.getText())
                                            .brojSediste(Integer.parseInt(brojsedista.getText()))
                                            .metodPlacanja(placanje.getText())
                                            .build());
                            PrikazRezervacija prikazRez = new PrikazRezervacija(prijvaljeniKor);
                            primaryStage.close();
                        } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(RezervacijaGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        alert1.setTitle("Program!");
                        alert1.setContentText("Rezervacija nije uspela.Objekat nema trazeni broj sedista.");
                        alert1.showAndWait();
                    }
                } else {
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Program!");
                    alert1.setContentText("Niste uneli trazene podatke.");
                    alert1.showAndWait();
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(RezervacijaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        main.getChildren().addAll(left);
        main.setAlignment(Pos.CENTER);

        Scene scene = new Scene(main, 700, 500);

        primaryStage.setTitle("Rezervacija");
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }
}
