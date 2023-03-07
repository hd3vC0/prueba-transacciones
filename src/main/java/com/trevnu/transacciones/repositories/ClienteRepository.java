package com.trevnu.transacciones.repositories;

import com.trevnu.transacciones.entity.Cliente;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    @Query(value = "SELECT * FROM clientes WHERE estado=?1", nativeQuery = true)
    public List<Cliente> getClienteByEstado(Boolean estado);

}
