package mps.fertigung;

import mps.fertigung.dtos.*;
import mps.Persistence;
import mps.TransactionManager;
import mps.fertigung.entities.Fertigungsplan;
import mps.fertigung.repositories.FertigungsplanRepository;
import mps.materialwirtschaft.MaterialwirtschaftFacade;
import mps.materialwirtschaft.dtos.StuecklisteDTO;
import mps.materialwirtschaft.dtos.StuecklistenPositionDTO;
import mps.verkauf.dtos.AuftragDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 12.11.13
 * Time: 22:13
 * To change this template use File | Settings | File Templates.
 */
public class FertigungBusinesslogic {




    public Fertigungsplan createFertigungsplan(AuftragDTO auftragDTO) {

        Fertigungsplan fp  = new Fertigungsplan();
        fp.setAuftragNr(auftragDTO.getNr());
        fp.setBauteilNr(auftragDTO.getAngebot().getBauteilNr());
        return fp;




    }
        /*
    public List<Arbeitsplan> getArbeitsplan(BauteilDTO bauteil)
    {
        TransactionManager transactionManager = new TransactionManager( Persistence.getSessionFactory() );
        List<Arbeitsplan> ret = new ArrayList();
        Arbeitsplan ap  = new Arbeitsplan();
        // Begin Transaction
        transactionManager.beginTransaction();

        ArbeitsplansplanRepository fertigungsplanRepository = new FertigungsplanRepository(Persistence.getSessionFactory());
        fertigungsplanRepository.save(fp);

        transactionManager.commit();

        return fp.toDTO();        
    }      */

}
