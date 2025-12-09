package com.raquelfit.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/presencas")
public class PresencaController {

    @Autowired
    private PresencaRepository presencaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping("/{alunoId}")
    public Presenca registrarPresenca(@PathVariable Integer alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElse(null);

        if (aluno == null) {
            return null;
        }

        Presenca presenca = new Presenca();
        presenca.setAluno(aluno);
        presenca.setDataPresenca(java.time.LocalDateTime.now().toString());

        return presencaRepository.save(presenca);
    }

    @GetMapping
    public List<Presenca> listar() {
        return presencaRepository.findAll();
    }
    
    @GetMapping("/{alunoId}")
public List<Presenca> listar(@PathVariable Integer alunoId) {
    Aluno aluno = alunoRepository.findById(alunoId).orElse(null);
    if (aluno == null) return null;

    return presencaRepository.findByAluno(aluno);
}
}