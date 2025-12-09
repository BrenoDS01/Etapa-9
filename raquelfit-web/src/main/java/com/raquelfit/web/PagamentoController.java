package com.raquelfit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/{alunoId}")
    public Pagamento obterPagamento(@PathVariable Integer alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElse(null);
        if (aluno == null) return null;

        Pagamento pag = pagamentoRepository.findByAluno(aluno);
        if (pag == null) {
            pag = new Pagamento();
            pag.setAluno(aluno);
            pag.setPago(false);
            pagamentoRepository.save(pag);
        }

        return pag;
    }

    @PostMapping("/{alunoId}")
    public Pagamento marcarPago(@PathVariable Integer alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElse(null);
        if (aluno == null) return null;

        Pagamento pag = pagamentoRepository.findByAluno(aluno);
        if (pag == null) {
            pag = new Pagamento();
            pag.setAluno(aluno);
        }

        pag.setPago(true);
        pag.setDataPagamento(java.time.LocalDateTime.now().toString());

        return pagamentoRepository.save(pag);
    }
}