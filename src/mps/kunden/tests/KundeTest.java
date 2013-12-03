package mps.kunden.tests;


import junit.framework.Assert;
import mps.kunden.dtos.KundeDTO;
import mps.kunden.dtos.KundeDTOImpl;
import mps.kunden.entities.Kunde;
import org.junit.Before;
import org.junit.Test;

import java.rmi.RemoteException;

/**
 * User: Loki
 * Date: 03.12.13
 * Time: 11:41
 */
public class KundeTest {

    Kunde kunde1;
    KundeDTO kundeDTO1, kundeDTO2;

    @Before
    public void setup()
    {
        kunde1 = new Kunde();
        kunde1.setAddress("Adresse");
        kunde1.setName("name");
        kunde1.setNr(23);

        try {
            kundeDTO1 = new KundeDTOImpl("name", "Adresse", 23);
            kundeDTO2 = new KundeDTOImpl("name2", "Adresse2", 42);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Test
    public void testToDTO() throws Exception {
        KundeDTO test1 = kunde1.toDTO();
        assert(!test1.equals(kundeDTO2));
    }

    @Test
    public void testFromDTO() throws Exception {
        Kunde k = Kunde.fromDTO(kundeDTO1);
        assert (k.equals(kunde1));
    }
}
