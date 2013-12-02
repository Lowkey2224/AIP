package mps.fertigung.repositories;

import mps.repositories.Repository;
import mps.fertigung.entities.Fertigungsplan;
import mps.repositories.RepositoryImplementation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 13.11.13
 * Time: 10:30
 * To change this template use File | Settings | File Templates.
 */
public class FertigungsplanRepository extends RepositoryImplementation<Fertigungsplan> {

    SessionFactory sf;

    public FertigungsplanRepository(SessionFactory sf)
    {
        this.sf = sf;
    }

    @Override
    public SessionFactory getSessionFactory()
    {
        return sf;
    }

    public Fertigungsplan findOneByNr(int nr)
    {
        Session session = sf.getCurrentSession();

        List<Fertigungsplan> result = session.createCriteria(Fertigungsplan.class).add( Restrictions.eq("nr", nr) ).list();

        if (result.isEmpty())
            return null;

        return result.get(0);
    }

    public Fertigungsplan findOneByAuftragNr(int nr)
    {
        Session session = sf.getCurrentSession();

        List<Fertigungsplan> result = session.createCriteria(Fertigungsplan.class).add( Restrictions.eq("auftragNr", nr) ).list();

        if (result.isEmpty())
            return null;

        return result.get(0);
    }

       
}
