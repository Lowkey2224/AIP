package tests;

import mps.fertigung.FertigungFacade;
import mps.kunden.KundenFacade;
import mps.kunden.dtos.KundeDTO;
import mps.materialwirtschaft.MaterialwirtschaftFacade;
import mps.materialwirtschaft.dtos.BauteilDTO;
import mps.verkauf.VerkaufFacade;
import mps.verkauf.dtos.AngebotDTO;
import mps.verkauf.dtos.AuftragDTO;
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
        assert(kund.findOneKundeByNr(k.getNr()).equals(k));
        assert(kund.findKundenByName("Patrick Bateman").get(0).equals(k));
    }


    @Test
    public void testCreateAuftrag()
    {
        KundeDTO k = null;
        int i = 0;
        while (k == null)
        {
            k = kund.findOneKundeByNr(i++);
        }
        i=0;
        BauteilDTO bt = verk.showBauteile().get(0);
        AngebotDTO an = verk.createAngebot(k);
        an = verk.addBauteil(an, bt);
        AuftragDTO auf = verk.createAuftrag(an);
        assert(auf.getAngebot().equals(an));
        assert (!auf.getIstAbgeschlossen());
    }
}
