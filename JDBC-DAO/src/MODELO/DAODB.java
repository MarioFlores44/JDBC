package MODELO;

import java.util.List;

public interface DAODB<T> {
    // CRUD
    boolean create(T t);
    T read(int id);
    boolean update(T t, int id);
    boolean delete(int id);
    // ALTRES
    boolean exists(int id);
    int count();
    List<T> all();
}