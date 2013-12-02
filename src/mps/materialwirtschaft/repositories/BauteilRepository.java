package mps.materialwirtschaft.repositories;

import mps.Repository;
import mps.materialwirtschaft.entities.Bauteil;
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
public class BauteilRepository implements Repository<Bauteil>{
    SessionFactory sf;

	public BauteilRepository(SessionFactory sf)
	{
        this.sf = sf;
    }

    public void delete(Bauteil elem)
    {
        Session session = sf.getCurrentSession();
        session.delete(elem);
    }

    public void save(Bauteil elem)
    {
        Session session = sf.getCurrentSession();
        session.saveOrUpdate(elem);
    }

    public Bauteil findOneByNr(int nr)
    {
        Session session = sf.getCurrentSession();

        List<Bauteil> result = session.createCriteria(Bauteil.class).add( Restrictions.eq("nr", nr) ).list();

        if (result.isEmpty())
            return null;

        return result.get(0);
    }


}
