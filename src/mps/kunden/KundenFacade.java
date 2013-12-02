package mps.kunden;

import mps.Persistence;
import mps.TransactionManager;
import mps.kunden.dtos.KundeDTO;
import mps.kunden.entities.Kunde;
import mps.kunden.repositories.KundeRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Loki
 * Date: 02.12.13
 * Time: 17:52
 */
public class KundenFacade implements KundenForVerkauf{

    private KundenBusinessLogic bl;
    private KundeRepository kundenRepository;
    private TransactionManager tm;

    public KundenFacade()
    {
        tm = new TransactionManager( Persistence.getSessionFactory() );
        bl = new KundenBusinessLogic();
        kundenRepository = new KundeRepository(Persistence.getSessionFactory());
    }

    @Override
    public List<KundeDTO> findKundenByName(String name) {
        tm.beginTransaction();
        List<Kunde> result = kundenRepository.findByName(name);
        List<KundeDTO> returnValue = new ArrayList<KundeDTO>(result.size());
        for(Kunde k : result)
        {
            returnValue.add(k.toDTO());
        }

        tm.commit();
        return returnValue;
    }

    @Override
    public KundeDTO findKundeByNr(int nr) {
        tm.beginTransaction();
        Kunde kunde = kundenRepository.findOneByNr(nr);
        tm.commit();
        return kunde.toDTO();
    }

    @Override
    public KundeDTO createKunde(String name, String addresse) {
        tm.beginTransaction();
        Kunde k = bl.createKunde(name,addresse);
        kundenRepository.save(k);
        return k.toDTO();
    }
}
