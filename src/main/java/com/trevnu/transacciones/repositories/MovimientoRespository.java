package com.trevnu.transacciones.repositories;

import com.trevnu.transacciones.entity.Movimiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRespository extends CrudRepository<Movimiento, Long> {
}
