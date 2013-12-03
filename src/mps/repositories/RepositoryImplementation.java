package mps.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * User: Loki
 * Date: 02.12.13
 * Time: 18:59
 */
public abstract class RepositoryImplementation<T> implements Repository<T> {

    public abstract SessionFactory getSessionFactory();

    @Override
    public T save(T elem) {
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(elem);
        return elem;
    }

    @Override
    public void delete(T elem) {
        Session session = getSessionFactory().getCurrentSession();
        session.delete(elem);
    }
}
