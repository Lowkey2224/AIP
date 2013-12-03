package mps.fertigung;
import mps.Persistence;
import mps.TransactionManager;
import mps.fertigung.dtos.FertigungsplanDTO;
import mps.fertigung.entities.Fertigungsplan;
import mps.fertigung.repositories.FertigungsplanRepository;
import mps.verkauf.dtos.AuftragDTO;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 12.11.13
 * Time: 22:10
 * To change this template use File | Settings | File Templates.
 */
public class FertigungFacade implements FertigungForVerkauf {

    private FertigungBusinesslogic bl;
    private TransactionManager tm;
    private FertigungsplanRepository fertigungsplanRepository;

    public FertigungFacade() {
        this.bl = new FertigungBusinesslogic();
        tm = new TransactionManager( Persistence.getSessionFactory() );
        fertigungsplanRepository = new FertigungsplanRepository(Persistence.getSessionFactory());

    }

    public FertigungsplanDTO createFertigungsplan( AuftragDTO auftragDTO )
    {
        tm.beginTransaction();
        Fertigungsplan fp = fertigungsplanRepository.save(this.bl.createFertigungsplan(auftragDTO));
        tm.commit();

        return fp.toDTO();
    }

}
