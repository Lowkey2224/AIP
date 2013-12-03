package mps;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MPSManager extends Remote, Serializable {

    public void start() throws RemoteException;
    public void stop() throws RemoteException;
    public MPSInstance getMPSInstance() throws RemoteException;

    public void setAliveBackReference(String s) throws RemoteException;
}
