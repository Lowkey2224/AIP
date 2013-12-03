package mps.verkauf;

import mps.Persistence;
import mps.TransactionManager;
import mps.fertigung.FertigungFacade;
import mps.fertigung.FertigungForVerkauf;
import mps.kunden.dtos.KundeDTO;
import mps.materialwirtschaft.MaterialwirtschaftForVerkauf;
import mps.materialwirtschaft.dtos.BauteilDTO;
import mps.verkauf.dtos.*;
import mps.verkauf.entities.*;
import mps.verkauf.repositories.AngebotRepository;
import mps.verkauf.repositories.AuftragRepository;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 12.11.13
 * Time: 18:08
 * To change this template use File | Settings | File Templates.
 */
public class VerkaufBusinesslogic {

    MaterialwirtschaftForVerkauf mat;
    FertigungForVerkauf fert;
    public  VerkaufBusinesslogic(MaterialwirtschaftForVerkauf mat, FertigungForVerkauf fert)
    {
        this.mat = mat;
        this.fert = fert;
    }

    public Auftrag createAuftrag( Angebot angebot )
    {
        Auftrag auftrag = new Auftrag();
        auftrag.setAngebot(angebot);

        // Save
//        angebotRepository.save( angebot );
//        auftragRepository.save( auftrag );

        // Commit Transaction
        angebot.setAuftrag(auftrag);
        fert.createFertigungsplan( auftrag.toDTO() );

        return auftrag;
    }

    public Angebot createAngebot(KundeDTO kundeDTO) {
        Angebot angebot = new Angebot();
        angebot.setGueltigAb(new Date());
        angebot.setKundeNr(kundeDTO.getNr());
        angebot.setNr(this.doSomeMagicForAngebotNummer());
        angebot.setGueltigBis(new Date(angebot.getGueltigAb().getTime() + this.daysInMillies(7)));
        return angebot;  //To change body of created methods use File | Settings | File Templates.
    }

    private long daysInMillies(int days) {
        //    s   m   h  d
        return  1000*60*60*24*days;
    }

    /**
     * Since we actually dont know how Angebot Numbers are created, its some magic for now
     * @return a new valid AngebotNummer
     */
    private int doSomeMagicForAngebotNummer() {
        AngebotRepository angRepo = new AngebotRepository(Persistence.getSessionFactory());
        return 1+angRepo.getMaxNr();

    }

    public Angebot addBauteil(Angebot angebot, BauteilDTO bauteilDTO) {
        angebot.setBauteilNr(bauteilDTO.getNr());
        angebot.setPreis(this.doSomeMagicForAngebotPreis());
        return angebot;
    }

    private int doSomeMagicForAngebotPreis() {
        return 0;  //TODO Switch Magic for Logic :-)
    }
}
