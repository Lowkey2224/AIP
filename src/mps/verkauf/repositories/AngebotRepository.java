package mps.verkauf.repositories;

import mps.verkauf.entities.Angebot;
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
public class AngebotRepository {
    SessionFactory sf;

    public AngebotRepository(SessionFactory sf)
    {
        this.sf = sf;
    }

    public void delete(Angebot angebot)
    {
        Session session = sf.getCurrentSession();
        session.delete(angebot);
    }

    public void save(Angebot angebot)
    {
        Session session = sf.getCurrentSession();
        session.saveOrUpdate(angebot);
    }

    public Angebot findOneByNr(int nr)
    {
        Session session = sf.getCurrentSession();

        List<Angebot> result = session.createCriteria(Angebot.class).add( Restrictions.eq("nr", nr) ).list();

        if (result.isEmpty())
            return null;

        return result.get(0);
    }


}
