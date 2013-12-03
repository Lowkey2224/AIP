package mps.materialwirtschaft.repositories;

import mps.materialwirtschaft.entities.Bauteil;
import mps.repositories.RepositoryImplementation;
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
public class BauteilRepository extends RepositoryImplementation<Bauteil> {
    SessionFactory sf;

    public BauteilRepository(SessionFactory sf)
	{
        this.sf = sf;
    }

    public List<Bauteil> findAll() {
        Session session = getSessionFactory().getCurrentSession();
        return session.createCriteria(Bauteil.class).list();
    }

    public Bauteil findOneByNr(int nr)
    {
        Session session = sf.getCurrentSession();

        List<Bauteil> result = session.createCriteria(Bauteil.class).add( Restrictions.eq("nr", nr) ).list();

        if (result.isEmpty())
            return null;

        return result.get(0);
    }


    @Override
    public SessionFactory getSessionFactory() {
        return sf;
    }

    public int getMaxNr()
    {
        Session session = sf.getCurrentSession();
        Criteria criteria = session
                .createCriteria(Bauteil.class)
                .setProjection(Projections.max("nr"));
        return  (Integer)criteria.uniqueResult();
    }
}
