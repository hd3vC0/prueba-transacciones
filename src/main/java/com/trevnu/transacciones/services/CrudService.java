package com.trevnu.transacciones.services;

import java.util.List;

public interface CrudService<D> {
    public void create(D dto);
    public List<D> getAll();
    public void update(Integer id, D dto);
    public void delete(Integer id);
    public D get(Integer id);
}
