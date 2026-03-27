package za.ac.cput.repository;

/**
 * Author: Phumlani Mdlalo, 241093813
 * Date: March 2026
 */

public interface IRepository<T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
