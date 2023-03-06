package com.app;

import models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    @Query("select a from Alumno a where a.di < 5.0")
    List<Alumno> findByModDiSuspenso();
    @Query("select a from Alumno a where a.ad < 5.0")
    List<Alumno> findByModAdSuspenso();

}
