package com.raquelfit.web;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PresencaRepository extends JpaRepository<Presenca, Integer> {
    List<Presenca> findByAluno(Aluno aluno);
}

