package org.example;

import java.util.List;

public interface DAO <T>{
    T get(Long id);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
    public void deleteById(Long id);
    public void updateImage(T t, String f );
    public void updateImageById(Long id, String f );
    void deleteAll();

}
