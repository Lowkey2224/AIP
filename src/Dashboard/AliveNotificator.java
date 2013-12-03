package Dashboard;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface AliveNotificator extends Remote, Serializable {

    public void iamAlive(String mpsId) throws RemoteException;

}
