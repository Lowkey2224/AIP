package mps.kunden.dtos;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface KundeDTO extends Remote,Serializable {

    public String getName()   throws RemoteException;
    public String getAddress()   throws RemoteException;
    public int getNr()   throws RemoteException ;

}
