/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

/**
 *
 * @author PC
 */
public class Regularan extends Decorator {

    @Override
    public void vrstaDekoracije() {
        System.out.println("Regularan- Regularni korisnici imaju mogucnost rezervacije karata i kupovine istih bez dodatnih pogodnosti.");
    }

}
