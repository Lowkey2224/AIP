package mps.kunden.dtos;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * User: Loki
 * Date: 02.12.13
 * Time: 17:53
 */
public class KundeDTOImpl extends UnicastRemoteObject implements KundeDTO, Serializable {
    private String name;
    private String address;
    private int nr;

    public KundeDTOImpl(String name, String address, int nr)  throws RemoteException
    {
        this.name = name;
        this.address = address;
        this.nr = nr;
    }

    public String getName()   throws RemoteException{
        return name;
    }

    public String getAddress()   throws RemoteException {
        return address;
    }

    public int getNr()   throws RemoteException {
        return nr;
    }
}
