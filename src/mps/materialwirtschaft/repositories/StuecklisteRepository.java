package mps.materialwirtschaft.repositories;

import mps.repositories.Repository;
import mps.materialwirtschaft.entities.Stueckliste;
import mps.repositories.RepositoryImplementation;
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
public class StuecklisteRepository extends RepositoryImplementation<Stueckliste> {
    SessionFactory sf;

	public StuecklisteRepository(SessionFactory sf)
	{
        this.sf = sf;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return sf;
    }


    public Stueckliste findOneById(int id)
    {
        Session session = sf.getCurrentSession();

        List<Stueckliste> result = session.createCriteria(Stueckliste.class).add( Restrictions.eq("id", id) ).list();

        if (result.isEmpty())
            return null;

        return result.get(0);
    }


}
