package mps.kunden;

import mps.kunden.dtos.KundeDTO;

import java.util.List;

/**
 * User: Loki
 * Date: 02.12.13
 * Time: 17:52
 */
public class KundenFacade implements KundenForVerkauf{

    private KundenBusinessLogic bl;

    public KundenFacade()
    {
        bl = new KundenBusinessLogic();
    }

    @Override
    public List<KundeDTO> findKundenByName(String name) {
        return bl.findKundenByName(name);
    }

    @Override
    public KundeDTO findKundeByNr(int nr) {
        return bl.findKundeByNr(nr);
    }

    @Override
    public KundeDTO createKunde(String name, String addresse) {
        return bl.createKunde(name, addresse);
    }
}
