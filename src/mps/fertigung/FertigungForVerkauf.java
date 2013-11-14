package mps.fertigung;

import mps.fertigung.dtos.FertigungsplanDTO;
import mps.verkauf.dtos.AuftragDTO;

/**
 * Created with IntelliJ IDEA.
 * User: Loki
 * Date: 14.11.13
 * Time: 19:01
 * To change this template use File | Settings | File Templates.
 */
public interface FertigungForVerkauf {

    public FertigungsplanDTO createFertigungsplan(AuftragDTO auftragDTO);
}
