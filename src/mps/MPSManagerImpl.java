package mps;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;


public class MPSManagerImpl extends UnicastRemoteObject implements MPSManager {

    private final Integer port;
    private MPSInstance mpsInstance;
    private String rmiObjectName;

    public void start()
    {
        System.out.println("Starte MPSInstance");

        try {

            // Erzeuge MPSInstance
            this.mpsInstance = new MPSInstanceImpl();

            // RMI Object Rebind
            Naming.rebind("//localhost:" + port + "/" + this.rmiObjectName, (MPSManager) this);
            System.out.println("Server registriert unter " + this.rmiObjectName);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void stop()
    {
        System.out.println("Stoppe MPSInstance");
        mpsInstance = null;
    }

    public MPSInstance getMPSInstance()
    {
       return this.mpsInstance;
    }

    public MPSManagerImpl(String rmiObjectName, Integer port) throws RemoteException{

        LocateRegistry.createRegistry(port);
        this.rmiObjectName = rmiObjectName;
        this.port = port;
        this.start();

    }

    public static void main(String args[]) throws RemoteException{

        // Name
        String rmiObjectName = (args[0] == null) ? "mps" : args[0];

        // Port
        Integer port = (args[1] == null) ? 2030 : new Integer(args[1]);

        MPSManager mps = new MPSManagerImpl(rmiObjectName, port);

        //while(true) {}
    }
}
