package com.example.BackendMiniCore.Controlador;

import com.example.BackendMiniCore.Modelos.Departamento;
import com.example.BackendMiniCore.Servicios.DepartamentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoControlador {
    @Autowired
    private final DepartamentoServicio departamentoService;

    public DepartamentoControlador(DepartamentoServicio departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping("/info")
    public String index(){
        return "Conectado a la tabla de Departamentos";
    }

    @GetMapping()
    public List<Departamento> getAllDepartamentos(){
        return departamentoService.findAll();
    }

    @PostMapping()
    public ResponseEntity<String> registrarDepartamento(@RequestBody Departamento departamento){
        departamentoService.crearDepartamento(departamento);
        return ResponseEntity.ok("Registro de departamento exitoso");
    }
}
