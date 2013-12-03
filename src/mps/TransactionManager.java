package mps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 22.10.13
 * Time: 20:09
 * To change this template use File | Settings | File Templates.
 */
public class TransactionManager {

    SessionFactory sf;

    public TransactionManager(SessionFactory sf)
    {
        this.sf = sf;
    }

    public void beginTransaction()
    {
        Session session = sf.getCurrentSession();
        if( !session.getTransaction().isActive() )
            session.beginTransaction();
    }

    public void commit()
    {
        Session session = sf.getCurrentSession();
        session.getTransaction().commit();
    }



}
