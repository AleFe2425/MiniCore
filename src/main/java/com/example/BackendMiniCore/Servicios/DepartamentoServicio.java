package com.example.BackendMiniCore.Servicios;

import com.example.BackendMiniCore.Modelos.Departamento;
import com.example.BackendMiniCore.Repositorio.IDepartamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServicio {
    @Autowired
    private final IDepartamentoRepositorio departamentoRepository;

    public DepartamentoServicio(IDepartamentoRepositorio departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public List<Departamento> findAll(){
        return departamentoRepository.findAll();
    }

    public Departamento crearDepartamento(Departamento departamento){
        departamentoRepository.save(departamento);
        return departamento;
    }

    public Departamento findById(Long idDepartamento){
        return departamentoRepository.findByIdDepartamento(idDepartamento);
    }
}
