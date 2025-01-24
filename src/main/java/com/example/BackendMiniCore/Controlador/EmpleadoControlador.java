package com.example.BackendMiniCore.Controlador;

import com.example.BackendMiniCore.Modelos.Empleado;
import com.example.BackendMiniCore.Servicios.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoControlador {
    @Autowired
    private final EmpleadoServicio empleadoService;

    public EmpleadoControlador(EmpleadoServicio empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/info")
    public String index(){
        return "Conectado a la tabla de Empleados";
    }

    @GetMapping()
    public List<Empleado> getAllEmpleado(){
        return empleadoService.findAll();
    }

    @PostMapping()
    public ResponseEntity<String> registrarEmpleado(@RequestBody Empleado empleado){
        empleadoService.crearEmpleado(empleado);
        return ResponseEntity.ok("Registro de empleado exitoso");
    }
}
