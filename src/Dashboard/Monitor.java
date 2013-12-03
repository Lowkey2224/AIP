package Dashboard;
import mps.MPSInstance;
import mps.MPSManager;
import mps.kunden.KundenForVerkauf;
import mps.kunden.dtos.KundeDTO;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


public class Monitor extends JFrame {

    private final String mpsAdress2;
    private final String mpsAdress1;
    private JPanel contentPane;
    private MPSManager mpsManager1;
    private MPSManager mpsManager2;

    private long lastMPS1Alive;
    private long lastMPS2Alive;
    private boolean flagMPS = false;
    private Integer countMPS1 = 0;
    private Integer countMPS2 = 0;

    private JLabel counterlabel1;
    private JLabel counterlabel2;

    JLabel lastMPS1AliveLabel;
    JLabel lastMPS2AliveLabel;

    private Dispatcher dispatcher;
    private AliveNotificator aliveNotificator;


    Thread refreshThread = new Thread()
    {
        public void run()
        {
            while(true)
            {
                try{
                    refreshView();
                    sleep(200);
                }catch(InterruptedException e)
                {
                    System.out.println("RefresThread stoppt");
                    break;
                }
            }
        }
    };

    /**
     * Create the frame.
     */
    public Monitor(String mps1, String mps2) {

        lastMPS1Alive = 0;
        lastMPS2Alive = 0;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 562, 480);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBorder(UIManager.getBorder("Button.border"));
        panel.setForeground(UIManager.getColor("Tree.hash"));
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblMpsMonitor = new JLabel("MPS Monitor");
        lblMpsMonitor.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        lblMpsMonitor.setBounds(6, 6, 116, 33);
        panel.add(lblMpsMonitor);

        Panel panel_1 = new Panel();
        panel_1.setForeground(UIManager.getColor("Tree.selectionBorderColor"));
        panel_1.setBackground(UIManager.getColor("Tree.background"));
        panel_1.setBounds(6, 45, 536, 177);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblZugriffe = new JLabel("Zugriffe");
        lblZugriffe.setBounds(396, 110, 50, 16);
        panel_1.add(lblZugriffe);

        JLabel lblMps = new JLabel("MPS 1");
        lblMps.setBounds(6, 6, 41, 17);
        lblMps.setFont(new Font("Lucida Grande", Font.ITALIC, 14));
        panel_1.add(lblMps);

        counterlabel1 = new JLabel("0");
        counterlabel1.setFont(new Font("Lucida Grande", Font.BOLD, 45));
        counterlabel1.setBounds(386, 48, 112, 51);
        panel_1.add(counterlabel1);

        Canvas canvas = new Canvas();
        canvas.setBackground(Color.RED);
        canvas.setBounds(43, 37, 50, 51);
        panel_1.add(canvas);

        Canvas canvas_1 = new Canvas();
        canvas_1.setBackground(new Color(50, 205, 50));
        canvas_1.setBounds(43, 100, 50, 51);
        panel_1.add(canvas_1);

        Canvas canvas_2 = new Canvas();
        canvas_2.setBackground(new Color(105, 105, 105));
        canvas_2.setBounds(386, 101, 100, 4);
        panel_1.add(canvas_2);

        Canvas canvas_3 = new Canvas();
        canvas_3.setBackground(new Color(105, 105, 105));
        canvas_3.setBounds(126, 101, 219, 4);
        panel_1.add(canvas_3);

        JLabel lblUpdowntime = new JLabel("Up-/Downtime");
        lblUpdowntime.setBounds(136, 110, 126, 16);
        panel_1.add(lblUpdowntime);

        Canvas canvas_4 = new Canvas();
        canvas_4.setBackground(new Color(24, 24, 24));
        canvas_4.setBounds(32, 29, 71, 135);
        panel_1.add(canvas_4);

        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // START Geklickt
                startMps1();
            }
        });
        btnStart.setBounds(126, 138, 117, 29);
        panel_1.add(btnStart);

        JButton button = new JButton("Stop");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // STOP Geklickt
                stopMps1();
            }
        });
        button.setBounds(238, 138, 117, 29);
        panel_1.add(button);

        JLabel lblZeitSeitLetzter = new JLabel("Zeit seit letzter Alive-Nachricht:");
        lblZeitSeitLetzter.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        lblZeitSeitLetzter.setBounds(301, 8, 196, 16);
        panel_1.add(lblZeitSeitLetzter);


        lastMPS1AliveLabel = new JLabel("110 ms");
        lastMPS1AliveLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lastMPS1AliveLabel.setBounds(444, 7, 86, 16);
        panel_1.add(lastMPS1AliveLabel);

        JLabel label_1 = new JLabel("00:00:23");
        label_1.setFont(new Font("Lucida Grande", Font.BOLD, 45));
        label_1.setBounds(131, 48, 214, 51);
        panel_1.add(label_1);

        Panel panel_2 = new Panel();
        panel_2.setLayout(null);
        panel_2.setForeground(SystemColor.controlHighlight);
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(6, 228, 536, 177);
        panel.add(panel_2);

        JLabel label_2 = new JLabel("Zugriffe");
        label_2.setBounds(396, 110, 50, 16);
        panel_2.add(label_2);

        JLabel lblMps_1 = new JLabel("MPS 2");
        lblMps_1.setFont(new Font("Lucida Grande", Font.ITALIC, 14));
        lblMps_1.setBounds(6, 6, 41, 17);
        panel_2.add(lblMps_1);


        counterlabel2 = new JLabel("0");
        counterlabel2.setFont(new Font("Lucida Grande", Font.BOLD, 45));
        counterlabel2.setBounds(386, 48, 112, 51);
        panel_2.add(counterlabel2);

        Canvas canvas_5 = new Canvas();
        canvas_5.setBackground(Color.RED);
        canvas_5.setBounds(43, 37, 50, 51);
        panel_2.add(canvas_5);

        Canvas canvas_6 = new Canvas();
        canvas_6.setBackground(new Color(50, 205, 50));
        canvas_6.setBounds(43, 100, 50, 51);
        panel_2.add(canvas_6);

        Canvas canvas_7 = new Canvas();
        canvas_7.setBackground(new Color(105, 105, 105));
        canvas_7.setBounds(386, 101, 100, 4);
        panel_2.add(canvas_7);

        Canvas canvas_8 = new Canvas();
        canvas_8.setBackground(new Color(105, 105, 105));
        canvas_8.setBounds(126, 101, 219, 4);
        panel_2.add(canvas_8);

        JLabel label_5 = new JLabel("Up-/Downtime");
        label_5.setBounds(136, 110, 126, 16);
        panel_2.add(label_5);

        Canvas canvas_9 = new Canvas();
        canvas_9.setBackground(new Color(24, 24, 24));
        canvas_9.setBounds(32, 29, 71, 135);
        panel_2.add(canvas_9);

        JButton button_1 = new JButton("Start");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startMps2();
            }
        });
        button_1.setBounds(126, 138, 117, 29);
        panel_2.add(button_1);

        JButton button_2 = new JButton("Stop");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopMps2();
            }
        });
        button_2.setBounds(238, 138, 117, 29);
        panel_2.add(button_2);

        JLabel label_6 = new JLabel("Zeit seit letzter Alive-Nachricht:");
        label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        label_6.setBounds(301, 8, 196, 16);
        panel_2.add(label_6);


        lastMPS2AliveLabel = new JLabel("110 ms");
        lastMPS2AliveLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lastMPS2AliveLabel.setBounds(444, 7, 86, 16);
        panel_2.add(lastMPS2AliveLabel);

        JLabel label_8 = new JLabel("00:00:23");
        label_8.setFont(new Font("Lucida Grande", Font.BOLD, 45));
        label_8.setBounds(131, 48, 214, 51);
        panel_2.add(label_8);

        JButton btnAnfrage = new JButton("Anfrage 1");
        btnAnfrage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                request1();
            }
        });
        btnAnfrage.setBounds(6, 413, 117, 29);
        panel.add(btnAnfrage);

        JButton btnAnfrage_1 = new JButton("Anfrage 2");
        btnAnfrage_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                request2();
            }
        });
        btnAnfrage_1.setBounds(129, 413, 117, 29);
        panel.add(btnAnfrage_1);

        JButton btnAnfrage_2 = new JButton("Anfrage 3");
        btnAnfrage_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                request3();
            }
        });
        btnAnfrage_2.setBounds(258, 413, 117, 29);
        panel.add(btnAnfrage_2);

        // Connect to MPSs
        this.mpsAdress1 = mps1;
        this.mpsAdress2 = mps2;
        connectMPS();

        refreshThread.start();

    }

    private void request1() {

        try {

            MPSManager remoteMPSManager = this.dispatcher.call();
            MPSInstance remoteMPSInstance = remoteMPSManager.getMPSInstance();
            KundenForVerkauf remoteKundenFacade = remoteMPSInstance.getKundenFacade();

            KundeDTO k = remoteKundenFacade.createKunde("Max Mustermann", "Adresse");

        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
    private void request2() {


    }
    private void request3() {


    }

    private void stopMps2() {
        try {
            System.out.println("Stoppe MPS2");
            mpsManager2.stop();
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void startMps2() {
        try {
            System.out.println("Starte MPS2");
            mpsManager2.start();
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void startMps1() {
        try {
            System.out.println("Starte MPS1");
            mpsManager1.start();
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void stopMps1() {
        try {
            System.out.println("Stoppe MPS1");
            mpsManager1.stop();
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }



    private void connectMPS() {

        String reference = "//localhost:2033/monitor";

        try {

            // === Alive Server vorbereiten
            LocateRegistry.createRegistry(2033);

            aliveNotificator = new AliveNotificatorImpl(this);
            // RMI Object Rebind
            Naming.rebind(reference, aliveNotificator);

            mpsManager1 = (MPSManager) Naming.lookup(mpsAdress1);
            mpsManager1.setAliveBackReference(reference);
        } catch(Exception ex) {
            System.out.println("MPS1 wurde nicht gefunden oder Fehler beim init");
            ex.printStackTrace();
        }

        try {
            mpsManager2 = (MPSManager) Naming.lookup(mpsAdress2);
            mpsManager2.setAliveBackReference(reference);
        } catch(Exception ex) {
            System.out.println("MPS2 wurde nicht gefunden oder Fehler beim init");
            ex.printStackTrace();
        }


    }



    public MPSManager getRunningMPS() {

        MPSManager theChoosenOne;

        if(!flagMPS)
        {
            countMPS1++;
            theChoosenOne = mpsManager1;
        } else
        {
            countMPS2++;
            theChoosenOne = mpsManager2;
        }
        flagMPS = !flagMPS;
        refreshView();

        return theChoosenOne;
    }

    private void refreshView() {

        Long timediff1 = System.currentTimeMillis() - lastMPS1Alive;
        lastMPS1AliveLabel.setText( timediff1.toString() + " ms");

        Long timediff2 = System.currentTimeMillis() - lastMPS2Alive;
        lastMPS2AliveLabel.setText( timediff2.toString() + " ms");

        counterlabel1.setText(countMPS1.toString());
        counterlabel2.setText(countMPS2.toString());

    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void mps1Alive() {

        refreshView();
        lastMPS1Alive = System.currentTimeMillis();
        System.out.println("MPS1 alive");
    }

    public void mps2Alive() {


        refreshView();
        lastMPS2Alive = System.currentTimeMillis();
        System.out.println("MPS2 alive");
    }
}
