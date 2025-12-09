package com.raquelfit.web;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
    Pagamento findByAluno(Aluno aluno);
}

