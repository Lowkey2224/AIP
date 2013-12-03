package mps.verkauf.repositories;

import mps.repositories.RepositoryImplementation;
import mps.verkauf.entities.Angebot;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Loki
 * Date: 22.10.13
 * Time: 16:03
 * To change this template use File | Settings | File Templates.
 */
public class AngebotRepository extends RepositoryImplementation<Angebot>{
    SessionFactory sf;

    public AngebotRepository(SessionFactory sf)
    {
        this.sf = sf;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return sf;
    }

    public Angebot findOneByNr(int nr)
    {
        Session session = sf.getCurrentSession();

        List<Angebot> result = session.createCriteria(Angebot.class).add( Restrictions.eq("nr", nr) ).list();

        if (result.isEmpty())
            return null;

        return result.get(0);
    }

    public int getMaxNr()
    {
        Session session = sf.getCurrentSession();
        Criteria criteria = session
                .createCriteria(Angebot.class)
                .setProjection(Projections.max("nr"));
        return  (Integer)criteria.uniqueResult();
    }


}
