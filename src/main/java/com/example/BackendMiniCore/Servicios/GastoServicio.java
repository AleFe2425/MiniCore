package com.example.BackendMiniCore.Servicios;

import com.example.BackendMiniCore.Modelos.Departamento;
import com.example.BackendMiniCore.Modelos.Empleado;
import com.example.BackendMiniCore.Modelos.Gasto;
import com.example.BackendMiniCore.Repositorio.IGastoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GastoServicio {
    @Autowired
    private final IGastoRepositorio gastoRepository;
    private final DepartamentoServicio departamentoService;
    private final EmpleadoServicio empleadoService;

    public GastoServicio(IGastoRepositorio gastoRepository, DepartamentoServicio departamentoService, EmpleadoServicio empleadoService) {
        this.gastoRepository = gastoRepository;
        this.departamentoService = departamentoService;
        this.empleadoService = empleadoService;
    }

    public List<Gasto> findAll(){
        return gastoRepository.findAll();
    }

    public Gasto crearGasto(Gasto gasto){
        Empleado empleado = empleadoService.findById(gasto.getEmpleado().getIdEmpleado());
        gasto.setEmpleado(empleado);
        Departamento departamento = departamentoService.findById(gasto.getDepartamento().getIdDepartamento());
        gasto.setDepartamento(departamento);
        gasto.setFecha(new Date());
        gastoRepository.save(gasto);
        return gasto;
    }

    public Gasto findById(Long id){
        return gastoRepository.findByIdGasto(id);
    }

    public Gasto actualizarGasto(Long id, Gasto gasto){
        Gasto existeGasto = findById(id);
        if (existeGasto != null){
            existeGasto.setDescripcion(gasto.getDescripcion());
            existeGasto.setMonto(gasto.getMonto());
            gastoRepository.save(existeGasto);
        }
        return existeGasto;
    }

    public Boolean eliminarGasto(Long id){
        Gasto existeGasto = findById(id);
        if (existeGasto != null){
            gastoRepository.deleteById(existeGasto.getIdGasto());
            return true;
        }
        return false;
    }
}
