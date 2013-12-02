package mps;

/**
 * User: Loki
 * Date: 02.12.13
 * Time: 18:50
 */
public interface Repository<T> {

    void save(T elem);
    void delete(T elem);

}
