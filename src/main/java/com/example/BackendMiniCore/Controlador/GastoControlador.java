package com.example.BackendMiniCore.Controlador;

import com.example.BackendMiniCore.Modelos.Gasto;
import com.example.BackendMiniCore.Servicios.GastoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/gasto")
public class GastoControlador {
    @Autowired
    private final GastoServicio gastoService;

    public GastoControlador(GastoServicio gastoService) {
        this.gastoService = gastoService;
    }

    @GetMapping("/info")
    public String index(){
        return "Conectado a la tabla de Gastos";
    }

    @GetMapping()
    public List<Gasto> getAllGasto(){
        return gastoService.findAll();
    }

    @PostMapping()
    public ResponseEntity<String> registrarGasto(@RequestBody Gasto gasto){
        gastoService.crearGasto(gasto);
        return ResponseEntity.ok("Registro de gasto exitoso");
    }

    @PutMapping("/{idGasto}")
    public ResponseEntity<Gasto> actualizarGasto(@PathVariable Long id, @RequestBody Gasto gasto){
        Gasto actualizado = gastoService.actualizarGasto(id,gasto);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idGasto}")
    public ResponseEntity<Void> eliminarGasto (@PathVariable Long id){
        return gastoService.eliminarGasto(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/filtrar")
    public Map<String, List<Gasto>> filtrarPorFechas(
            @RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {

        // Filtrar los gastos dentro del rango de fechas
        List<Gasto> gastosEnRango = gastoService.findAll().stream()
                .filter(gasto -> isFechaEnRango(gasto.getFecha(), fechaInicio, fechaFin))
                .collect(Collectors.toList());

        // Agrupar los gastos por departamento
        return gastosEnRango.stream()
                .filter(gasto -> gasto.getDepartamento() != null) // Filtrar gastos sin departamento
                .collect(Collectors.groupingBy(gasto -> gasto.getDepartamento().getNombre()));
    }

    // Método auxiliar para verificar si una fecha está en el rango
    private boolean isFechaEnRango(Date fecha, Date fechaInicio, Date fechaFin) {
        return fecha.compareTo(fechaInicio) >= 0 && fecha.compareTo(fechaFin) <= 0;
    }

}
