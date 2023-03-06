/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import java.util.List;
import java.util.Optional;

import models.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    @Autowired 
    private AlumnoRepository repositorio;

    @GetMapping(value = "/alumnado")
    public ResponseEntity listado() {
        List<Alumno> alumno = repositorio.findAll();
        return new ResponseEntity<>(alumno, HttpStatus.OK);
    }


    @GetMapping(value = "/alumnado/{id}")
    public ResponseEntity getAlumno(@PathVariable Integer id) {
        Optional<Alumno> alumno = repositorio.findById(id);
        return new ResponseEntity<>(alumno, HttpStatus.OK);
    }

    @GetMapping(value = "/alumnado/suspensos/{modulo}")
    public ResponseEntity getAlumnosSuspensos(@PathVariable String modulo) {
        if(modulo.equalsIgnoreCase("di")) {
            return new ResponseEntity<>(repositorio.findByModDiSuspenso(), HttpStatus.OK);
        } else if(modulo.equalsIgnoreCase("ad")){
            return new ResponseEntity<>(repositorio.findByModAdSuspenso(), HttpStatus.OK);
        } else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
}
