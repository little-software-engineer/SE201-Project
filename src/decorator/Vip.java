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
public class Vip extends Decorator {

    @Override
    public void vrstaDekoracije() {
        System.out.println("Vip- Korisnici koji su vip imaju pogonosti, popuste i mogucnost early bird karata za dogadjaje u okviru odredjenih objekata.");
    }

}
