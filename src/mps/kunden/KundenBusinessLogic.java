package mps.kunden;

import mps.kunden.entities.Kunde;

/**
 * User: Loki
 * Date: 02.12.13
 * Time: 17:52
 */
public class KundenBusinessLogic {

    public Kunde createKunde(String name, String addresse) {
        Kunde k = new Kunde();
        k.setName(name);
        k.setAddress(addresse);
        return k;
    }

}
