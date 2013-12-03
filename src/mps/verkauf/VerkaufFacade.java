package mps.verkauf;

import mps.Persistence;
import mps.TransactionManager;
import mps.fertigung.FertigungForVerkauf;
import mps.kunden.KundenForVerkauf;
import mps.kunden.dtos.KundeDTO;
import mps.materialwirtschaft.MaterialwirtschaftForVerkauf;
import mps.materialwirtschaft.dtos.BauteilDTO;
import mps.materialwirtschaft.entities.Bauteil;
import mps.verkauf.dtos.AngebotDTO;
import mps.verkauf.dtos.AuftragDTO;
import mps.verkauf.entities.Angebot;
import mps.verkauf.entities.Auftrag;
import mps.verkauf.repositories.AngebotRepository;
import mps.verkauf.repositories.AuftragRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 12.11.13
 * Time: 18:07
 * To change this template use File | Settings | File Templates.
 */
public class VerkaufFacade implements VerkaufForGUI{
    private final KundenForVerkauf kund;
    private TransactionManager tm;
    private AuftragRepository auftragRepository;
    private AngebotRepository angebotRepository;
    private VerkaufBusinesslogic bl;
    private MaterialwirtschaftForVerkauf materialwirtschaftForVerkauf;
    private FertigungForVerkauf fertigungForVerkauf;


    public VerkaufFacade(MaterialwirtschaftForVerkauf materialwirtschaftForVerkauf, FertigungForVerkauf fert, KundenForVerkauf kund) {
        this.materialwirtschaftForVerkauf = materialwirtschaftForVerkauf;
        this.kund = kund;
        this.fertigungForVerkauf = fert;
        this.bl = new VerkaufBusinesslogic(materialwirtschaftForVerkauf, fert);
        TransactionManager transactionManager = new TransactionManager( Persistence.getSessionFactory() );
        angebotRepository = new AngebotRepository( Persistence.getSessionFactory() );
        auftragRepository = new AuftragRepository( Persistence.getSessionFactory() );

    }

    @Override
    public List<KundeDTO> findKundenByName(String name) {
        return kund.findKundenByName(name);
    }

    @Override
    public KundeDTO findOneKundeByNr(int nr) {
        return kund.findOneKundeByNr(nr);
    }

    @Override
    public AngebotDTO createAngebot(KundeDTO kundeDTO)
    {
        Angebot a = this.bl.createAngebot(kundeDTO);
        tm.beginTransaction();
        a = angebotRepository.save(a);
        tm.commit();
        return a.toDTO();
    }

    @Override
    public AngebotDTO addBauteil(AngebotDTO angebotDTO, BauteilDTO bauteilDTO)
    {
        Angebot angebot = Angebot.fromDTO(angebotDTO);
        bl.addBauteil(angebot, bauteilDTO);
        tm.beginTransaction();
        angebot = angebotRepository.save(angebot);
        tm.commit();
        return angebot.toDTO();
    }

    @Override
    public List<BauteilDTO> showBauteile()
    {
        return materialwirtschaftForVerkauf.getAllBauteile();
    }

    @Override
    public AuftragDTO createAuftrag( AngebotDTO angebotDTO )
    {
        Angebot angebot = Angebot.fromDTO(angebotDTO);
        tm.beginTransaction();
        Auftrag a = auftragRepository.save(this.bl.createAuftrag(angebot));
        tm.commit();
        return a.toDTO();
    }

}
