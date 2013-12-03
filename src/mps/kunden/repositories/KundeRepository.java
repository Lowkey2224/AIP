package mps.kunden.repositories;

import mps.fertigung.entities.Fertigungsplan;
import mps.repositories.Repository;
import mps.kunden.entities.Kunde;
import mps.repositories.RepositoryImplementation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * User: Loki
 * Date: 02.12.13
 * Time: 17:53
 */
public class KundeRepository extends RepositoryImplementation<Kunde> {

    private SessionFactory sf;

    public KundeRepository(SessionFactory sf)
    {
        this.sf = sf;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return sf;
    }

    public Kunde findOneByNr(int nr)
    {
        Session session = sf.getCurrentSession();

        return (Kunde)session.createCriteria(Kunde.class).add( Restrictions.eq("nr", nr) ).uniqueResult();
    }

    public List<Kunde> findByName(String name)
    {
        Session session = sf.getCurrentSession();

        return (List<Kunde>)session.createCriteria(Kunde.class).add( Restrictions.eq("name", name) ).list();
    }
}
