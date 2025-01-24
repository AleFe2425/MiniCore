package com.example.BackendMiniCore.Repositorio;

import com.example.BackendMiniCore.Modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadoRepositorio extends JpaRepository<Empleado,Long> {
    Empleado findByIdEmpleado(Long id);
}
