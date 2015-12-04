package com.dataart.rbublyk.dao;

import com.dataart.rbublyk.exception.NotFoundException;

import java.io.Serializable;

public interface CrudDao<T, ID extends Serializable> {
    public T findOne(ID id) throws NotFoundException;
    public Iterable<T> findAll();
    public void delete(ID id);
    public void save(T entity);
    public void update(T entity);
}
