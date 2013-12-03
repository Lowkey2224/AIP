package mps;

import mps.fertigung.FertigungFacade;
import mps.fertigung.dtos.FertigungsplanDTO;
import mps.kunden.KundenFacade;
import mps.materialwirtschaft.MaterialwirtschaftFacade;
import mps.verkauf.VerkaufFacade;
import mps.verkauf.dtos.AuftragDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 02.12.13
 * Time: 20:55
 * To change this template use File | Settings | File Templates.
 */

public class MPSInstanceImpl extends UnicastRemoteObject implements MPSInstance {

    // Facaden
    private FertigungFacade             fertigungFacade;
    private KundenFacade                kundenFacade;
    private MaterialwirtschaftFacade    materialwirtschaftFacade;
    private VerkaufFacade               verkaufFacade;

    // Facade Getter
    public FertigungFacade          getFertigungFacade()            {return fertigungFacade;}
    public KundenFacade             getKundenFacade()               {return kundenFacade;}
    public MaterialwirtschaftFacade getMaterialwirtschaftFacade()   {return materialwirtschaftFacade;}
    public VerkaufFacade            getVerkaufFacade()              {return verkaufFacade;}


    public MPSInstanceImpl() throws RemoteException{

        // Facaden initialisieren
        this.fertigungFacade            = new FertigungFacade();
        this.kundenFacade               = new KundenFacade();
        this.materialwirtschaftFacade   = new MaterialwirtschaftFacade();
        this.verkaufFacade              = new VerkaufFacade(this.materialwirtschaftFacade, this.fertigungFacade, this.kundenFacade);

    }
}
