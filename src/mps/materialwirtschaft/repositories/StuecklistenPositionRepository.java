package mps.materialwirtschaft.repositories;

import mps.Repository;
import mps.materialwirtschaft.entities.Bauteil;
import mps.materialwirtschaft.entities.StuecklistenPosition;
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
public class StuecklistenPositionRepository implements Repository<StuecklistenPosition>{

    SessionFactory sf;

    public StuecklistenPositionRepository(SessionFactory sf)
    {
        this.sf = sf;
    }

    public void delete(StuecklistenPosition elem)
    {
        Session session = sf.getCurrentSession();
        session.delete(elem);
    }

    public void save(StuecklistenPosition elem)
    {
        Session session = sf.getCurrentSession();
        session.saveOrUpdate(elem);
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
