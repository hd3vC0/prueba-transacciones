package com.trevnu.transacciones.repositories;

import com.trevnu.transacciones.entity.Cuenta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends CrudRepository<Cuenta, Integer> {
}
