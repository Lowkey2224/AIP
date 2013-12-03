package mps.fertigung;

import mps.fertigung.dtos.*;
import mps.Persistence;
import mps.TransactionManager;
import mps.fertigung.entities.Fertigungsplan;
import mps.fertigung.repositories.FertigungsplanRepository;
import mps.materialwirtschaft.MaterialwirtschaftFacade;
import mps.materialwirtschaft.dtos.StuecklisteDTO;
import mps.materialwirtschaft.dtos.StuecklistenPositionDTO;
import mps.materialwirtschaft.entities.Bauteil;
import mps.materialwirtschaft.entities.Stueckliste;
import mps.materialwirtschaft.repositories.BauteilRepository;
import mps.verkauf.dtos.AuftragDTO;
import org.hibernate.SessionFactory;

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

//    private final SessionFactory sf;

    /*public FertigungBusinesslogic(SessionFactory sf)
    {
        this.sf = sf;
    }*/


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
