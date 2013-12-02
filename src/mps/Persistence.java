package mps;

import mps.fertigung.entities.Fertigungsplan;
import mps.kunden.entities.Kunde;
import mps.materialwirtschaft.entities.Bauteil;
import mps.materialwirtschaft.entities.Stueckliste;
import mps.materialwirtschaft.entities.StuecklistenPosition;
import mps.verkauf.entities.Angebot;
import mps.verkauf.entities.Auftrag;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 12.11.13
 * Time: 19:33
 * To change this template use File | Settings | File Templates.
 */
public class Persistence {

    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Kunde.class);
            configuration.addAnnotatedClass(Auftrag.class);
            configuration.addAnnotatedClass(Angebot.class);
            configuration.addAnnotatedClass(Fertigungsplan.class);
            configuration.addAnnotatedClass(Bauteil.class);
            configuration.addAnnotatedClass(Stueckliste.class);
            configuration.addAnnotatedClass(StuecklistenPosition.class);

            configuration.configure();
            SchemaExport schemaExport = new SchemaExport(configuration);
            schemaExport.execute( false, true, false, false );

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);


        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /*public mps.Persistence()
    {
        ThreadLocalSessionContext.bind( getSession() );
    }  */

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static SessionFactory getSessionFactory() throws HibernateException {
        return ourSessionFactory;
    }


}
