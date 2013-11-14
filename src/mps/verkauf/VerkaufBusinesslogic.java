package mps.verkauf;

import mps.Persistence;
import mps.TransactionManager;
import mps.fertigung.FertigungFacade;
import mps.verkauf.dtos.*;
import mps.verkauf.entities.*;
import mps.verkauf.repositories.AngebotRepository;
import mps.verkauf.repositories.AuftragRepository;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 12.11.13
 * Time: 18:08
 * To change this template use File | Settings | File Templates.
 */
public class VerkaufBusinesslogic {


    public AuftragDTO createAuftrag( Angebot angebot )
    {
        TransactionManager transactionManager = new TransactionManager( Persistence.getSessionFactory() );

        // Begin Transaction
        transactionManager.beginTransaction();

        // Repositories
        AngebotRepository angebotRepository = new AngebotRepository( Persistence.getSessionFactory() );
        AuftragRepository auftragRepository = new AuftragRepository( Persistence.getSessionFactory() );

        Auftrag auftrag = new Auftrag();
        auftrag.setAngebot(angebot);

        // Save
        angebotRepository.save( angebot );
        auftragRepository.save( auftrag );

        // Commit Transaction
        transactionManager.commit();

        // createFertigungsplan(AuftragsDTO)
        FertigungFacade fertigungFacade = new FertigungFacade();
        fertigungFacade.createFertigungsplan( auftrag.toDTO() );

        return auftrag.toDTO();
    }

}
