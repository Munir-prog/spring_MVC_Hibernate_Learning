package com.mprog.spring.dao;

import com.mprog.spring.entity.Employee;

import java.util.List;

public interface Dao<T> {

    List<T> getAll();

    void save(T e);

    T findByID(int id);
}
