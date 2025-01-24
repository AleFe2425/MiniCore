package com.example.BackendMiniCore.Repositorio;

import com.example.BackendMiniCore.Modelos.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartamentoRepositorio extends JpaRepository<Departamento,Long> {
    Departamento findByIdDepartamento(Long id);
}
