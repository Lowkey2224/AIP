package mps.materialwirtschaft.repositories;

import mps.repositories.Repository;
import mps.materialwirtschaft.entities.StuecklistenPosition;
import mps.repositories.RepositoryImplementation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 13.11.13
 * Time: 10:53
 * To change this template use File | Settings | File Templates.
 */
public class StuecklistenPositionRepository extends RepositoryImplementation<StuecklistenPosition> {

    SessionFactory sf;

    public StuecklistenPositionRepository(SessionFactory sf)
    {
        this.sf = sf;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return sf;
    }


    public StuecklistenPosition findOneById(int id)
    {
        Session session = sf.getCurrentSession();

        List<StuecklistenPosition> result = session.createCriteria(StuecklistenPosition.class).add( Restrictions.eq("id", id) ).list();

        if (result.isEmpty())
            return null;

        return result.get(0);
    }

}
