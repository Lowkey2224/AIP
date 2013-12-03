package tests;

import mps.fertigung.FertigungFacade;
import mps.kunden.KundenFacade;
import mps.kunden.dtos.KundeDTO;
import mps.materialwirtschaft.MaterialwirtschaftFacade;
import mps.materialwirtschaft.dtos.BauteilDTO;
import mps.verkauf.VerkaufFacade;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * User: Loki
 * Date: 03.12.13
 * Time: 14:18
 */
public class NewIntegrationsTest {

    private VerkaufFacade verk;
    private MaterialwirtschaftFacade mat;
    private KundenFacade kund;
    private FertigungFacade fert;
    @Before
    public void setup()
    {
        mat = new MaterialwirtschaftFacade();
        kund = new KundenFacade();
        fert = new FertigungFacade();
        verk = new VerkaufFacade(mat, fert);
    }

    /**
     * Tests the creation of Bauteil, and checks if all of them can be retrieved correctly
     */
    @Test
    public void testCreateBauteil()
    {
        BauteilDTO d1 = mat.createBauteil(null, "Stuhlbein");
        BauteilDTO d2 = mat.createBauteil(null, "Sitzflaeche");
        BauteilDTO d3 = mat.createBauteil(null, "Reuckenlehne");
        BauteilDTO d4 = mat.createBauteil(null, "Schrauben");

        List<BauteilDTO> list = mat.getAllBauteile();
        assert(list.contains(d1));
        assert(list.contains(d2));
        assert(list.contains(d3));
        assert(list.contains(d4));

    }

    @Test
    public void testCreateKunde()
    {
        KundeDTO k = kund.createKunde("Patrick Bateman", " W. 81st Street");
        assert(kund.findOneKundeByNr(k.getNr()).getName().equals(k.getName()));
        assert(kund.findOneKundeByNr(k.getNr()).getAddress().equals(k.getAddress()));
        assert(kund.findKundenByName("Patrick Bateman").get(0).getAddress().equals(k.getAddress()));
    }


    @Test
    public void testCreateAngebot()
    {

    }
}
