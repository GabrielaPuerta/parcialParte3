package com.puerta.curso.controller;

import com.puerta.commons.controller.*;
import com.puerta.curso.models.entity.Curso;
import com.puerta.curso.service.CursoService;
import com.puerta.common.usuario.models.entity.Alumno;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CursoController extends 
CommonController<Curso, CursoService>{

	@PutMapping("/{id}/asignar-alumno")
	public ResponseEntity<?> asignarAlumno(@PathVariable Long id, @RequestBody List<Alumno> alumno) {
        Optional<Curso> ob = service.findById(id);

        if (ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Curso cursoBd = ob.get();
        alumno.forEach(a -> {
        	cursoBd.addAlumnos(a);
        });
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoBd));
    }
	
	 @PutMapping("/{id}")
	    public ResponseEntity<?> actualizarAlumno(@PathVariable Long id, @RequestBody Curso curso) {
	        Optional<Curso> cursoGuardado = service.findById(id);

	        if (cursoGuardado.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        }

	        Curso cursoActualizado = cursoGuardado.get();
	        cursoActualizado.setNombre(curso.getNombre());
	        cursoActualizado.setApellido(curso.getApellido());
	        cursoActualizado.setEmail(curso.getEmail());

	        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoActualizado));
	    }
	 
	 @PutMapping("/{id}/eliminar-alumno")
	 public ResponseEntity<?> eliminarAlumno(@PathVariable Long id, @RequestBody List<Alumno> alumnos) {
	     Optional<Curso> optionalCurso = service.findById(id);
	     if (optionalCurso.isEmpty()) {
	         return ResponseEntity.notFound().build();
	     }
	     
	     Curso cursoBd = optionalCurso.get();
	     cursoBd.removeAlumnos(alumnos);
	     
	     // Guardar el curso actualizado en la base de datos
	     Curso cursoActualizado = service.save(cursoBd);

	     return ResponseEntity.status(HttpStatus.OK).body(cursoActualizado);
	 }


}
