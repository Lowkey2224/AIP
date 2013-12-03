package Dashboard;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AliveNotificatorImpl extends UnicastRemoteObject implements AliveNotificator {

    Monitor monitor;

    public AliveNotificatorImpl(Monitor monitor) throws RemoteException{
         this.monitor = monitor;
    }

    public void iamAlive(String mpsId) throws RemoteException
    {
        if(mpsId.equals("mps1"))
            monitor.mps1Alive();
        else
            monitor.mps2Alive();
    }
}
