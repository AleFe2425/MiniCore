package com.example.BackendMiniCore.Repositorio;

import com.example.BackendMiniCore.Modelos.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGastoRepositorio extends JpaRepository<Gasto,Long> {
    Gasto findByIdGasto(Long id);
}
