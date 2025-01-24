package com.example.BackendMiniCore.Servicios;

import com.example.BackendMiniCore.Modelos.Empleado;
import com.example.BackendMiniCore.Repositorio.IEmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio {
    @Autowired
    private final IEmpleadoRepositorio empleadoRepository;

    public EmpleadoServicio(IEmpleadoRepositorio empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> findAll(){
        return empleadoRepository.findAll();
    }

    public Empleado crearEmpleado(Empleado empleado){
        empleadoRepository.save(empleado);
        return empleado;
    }

    public Empleado findById(Long idEmpleado){
        return empleadoRepository.findByIdEmpleado(idEmpleado);
    }
}
