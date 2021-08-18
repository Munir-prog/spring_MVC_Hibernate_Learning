package com.mprog.spring.dao;

import java.util.List;

public interface Dao<T> {

    List<T> getAll();

    void save(T e);

    T findByID(int id);

    void deleteById(int id);
}
