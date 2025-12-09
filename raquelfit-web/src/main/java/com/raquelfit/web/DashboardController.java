package com.raquelfit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PresencaRepository presencaRepository;

    @GetMapping("/resumo")
    public DashboardResumo getResumo() {

        List<Aluno> alunos = alunoRepository.findAll();
        int totalAlunos = alunos.size();

        int pagos = 0;
        int pendentes = 0;
        int presencasHoje = 0;

        LocalDate hoje = LocalDate.now();

        for (Aluno aluno : alunos) {

            // Pagamento
            Pagamento pg = pagamentoRepository.findByAluno(aluno);
            if (pg != null && pg.getPago()) pagos++;
            else pendentes++;

            // Presenças do dia
            List<Presenca> presencas = presencaRepository.findByAluno(aluno);
            for (Presenca p : presencas) {
                if (p.getDataPresenca().startsWith(hoje.toString())) {
                    presencasHoje++;
                }
            }
        }

        return new DashboardResumo(totalAlunos, pagos, pendentes, presencasHoje);
    }

    static class DashboardResumo {
        public int totalAlunos;
        public int pagos;
        public int pendentes;
        public int presencasHoje;

        public DashboardResumo(int totalAlunos, int pagos, int pendentes, int presencasHoje) {
            this.totalAlunos = totalAlunos;
            this.pagos = pagos;
            this.pendentes = pendentes;
            this.presencasHoje = presencasHoje;
        }
    }
}

