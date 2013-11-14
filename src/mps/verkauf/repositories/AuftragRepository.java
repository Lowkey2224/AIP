package mps.verkauf.repositories;

import mps.verkauf.entities.Auftrag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Loki
 * Date: 22.10.13
 * Time: 16:03
 * To change this template use File | Settings | File Templates.
 */
public class AuftragRepository {
    SessionFactory sf;

    public AuftragRepository(SessionFactory sf)
    {
        this.sf = sf;
    }

    public void delete(Auftrag auftrag)
    {
        Session session = sf.getCurrentSession();
        session.delete(auftrag);
    }

    public void save(Auftrag auftrag)
    {
        Session session = sf.getCurrentSession();
        session.saveOrUpdate(auftrag);
    }

    public Auftrag findOneByNr(int nr)
    {
        Session session = sf.getCurrentSession();

        List<Auftrag> result = session.createCriteria(Auftrag.class).add( Restrictions.eq("nr", nr) ).list();

        if (result.isEmpty())
            return null;

        return result.get(0);
    }


}
