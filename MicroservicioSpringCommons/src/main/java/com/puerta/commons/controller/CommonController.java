package com.puerta.commons.controller;


import lombok.AllArgsConstructor;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.puerta.commons.service.CommonService;

import java.util.Map;

import java.util.Optional;


@AllArgsConstructor
public class CommonController <E, S extends CommonService<E>> {
	
	@Autowired
	protected S service;
    
    @Value("${config.balanaceador.test}")    
    private String balanceadorTest;
    
    @GetMapping("/balanceador-test")
    public ResponseEntity<?> balanceadorTest() {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("balanceador", balanceadorTest); 
        response.put("alumno", service.findAll());

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarAlumnos() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<?> buscarAlumnoPorId(@PathVariable Long id) {
        Optional<E> entity = service.findById(id);

        if (entity.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(entity.get());
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearAlumno(@RequestBody E entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable Long id) {
    	service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
