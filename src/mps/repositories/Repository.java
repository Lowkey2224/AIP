package mps.repositories;

import org.hibernate.SessionFactory;

/**
 * User: Loki
 * Date: 02.12.13
 * Time: 18:50
 */
public interface Repository<T> {


    T save(T elem);
    void delete(T elem);

}
