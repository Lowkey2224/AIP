package mps.fertigung;
import mps.fertigung.dtos.FertigungsplanDTO;
import mps.verkauf.dtos.AuftragDTO;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 12.11.13
 * Time: 22:10
 * To change this template use File | Settings | File Templates.
 */
public class FertigungFacade {

    private FertigungBusinesslogic bl;

    public FertigungFacade() {
        this.bl = new FertigungBusinesslogic();
    }

    public FertigungsplanDTO createFertigungsplan( AuftragDTO auftragDTO )
    {
        return this.bl.createFertigungsplan(auftragDTO);
    }

}
