package com.trevnu.transacciones.repositories;

import com.trevnu.transacciones.entity.Movimiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReporteRepository extends org.springframework.data.repository.Repository<Movimiento, Long> {
    @Query("SELECT mv FROM Movimiento mv JOIN mv.cuenta ct WHERE ct.numero=:numero AND mv.fecha BETWEEN :fecha1 AND :fecha2")
    List<Movimiento> findMovementRange(Long numero, Date fecha1, Date fecha2);
}
