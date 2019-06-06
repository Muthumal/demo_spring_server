package lk.lmuthumal.demo.service;

import java.util.List;

public interface Service<T> {
    List<T> findAll();

    T getById(int id);

    void update(T t);

    void delete(int id);

    void insert(T t);
}
