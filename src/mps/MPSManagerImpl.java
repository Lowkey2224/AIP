package mps;

import Dashboard.AliveNotificator;
import Dashboard.AliveNotificatorImpl;

import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import static java.lang.Thread.sleep;


public class MPSManagerImpl extends UnicastRemoteObject implements MPSManager {

    private final Integer port;
    private MPSInstance mpsInstance;
    private String rmiObjectName;

    private AliveNotificator aliveNotificator;
    private Thread aliveThread;

    private Thread createAliveThread()
    {
        return new Thread()
        {
            public void run()
            {
                while(true)
                {
                    try{
                        if (aliveNotificator != null) {
                            aliveNotificator.iamAlive(rmiObjectName);
                            System.out.println("Sende alive");
                        }
                        sleep(2000);
                    }
                    catch (ConnectException e)
                    {
                        System.out.println("Monitor nicht erreicht");
                    }
                    catch(InterruptedException e)
                    {
                        System.out.println("AliveThread stoppt");
                        break;
                    } catch (RemoteException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            }
        };
    }

    public void start()
    {
        System.out.println("Starte MPSInstance");

        try {

            // Erzeuge MPSInstance
            this.mpsInstance = new MPSInstanceImpl();

            // RMI Object Rebind
            Naming.rebind("//localhost:" + port + "/" + this.rmiObjectName, (MPSManager) this);
            System.out.println("Server registriert unter " + this.rmiObjectName);

            aliveThread = createAliveThread();
            aliveThread.start();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void stop()
    {
        System.out.println("Stoppe MPSInstance");
        mpsInstance = null;
        aliveThread.interrupt();
        aliveThread = null;
    }

    public MPSInstance getMPSInstance()
    {
       return this.mpsInstance;
    }


    public void setAliveBackReference(String s) throws RemoteException {

        try {
            System.out.println(" alive backrefernce wird gesetzt: " + s);
            aliveNotificator = (AliveNotificator) Naming.lookup(s);
        } catch (NotBoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

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
