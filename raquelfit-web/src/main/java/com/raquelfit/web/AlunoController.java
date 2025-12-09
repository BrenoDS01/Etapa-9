package com.raquelfit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @GetMapping("/{id}")
    public Aluno buscarPorId(@PathVariable Integer id) {
        return alunoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        alunoRepository.deleteById(id);
    }
}
