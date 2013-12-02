package mps.materialwirtschaft.repositories;

import mps.Repository;
import mps.materialwirtschaft.entities.Stueckliste;
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
public class StuecklisteRepository implements Repository<Stueckliste>{
    SessionFactory sf;

	public StuecklisteRepository(SessionFactory sf)
	{
        this.sf = sf;
    }

    public void delete(Stueckliste elem)
    {
        Session session = sf.getCurrentSession();
        session.delete(elem);
    }

    public void save(Stueckliste elem)
    {
        Session session = sf.getCurrentSession();
        session.saveOrUpdate(elem);
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
