package mps;

import mps.fertigung.FertigungFacade;
import mps.kunden.KundenFacade;
import mps.kunden.KundenForVerkauf;
import mps.materialwirtschaft.MaterialwirtschaftFacade;
import mps.verkauf.VerkaufFacade;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MPSInstance extends Remote,Serializable {

    public FertigungFacade getFertigungFacade() throws RemoteException;
    public KundenForVerkauf getKundenFacade()    throws RemoteException;
    public MaterialwirtschaftFacade getMaterialwirtschaftFacade()     throws RemoteException;
    public VerkaufFacade getVerkaufFacade()    throws RemoteException;


}
