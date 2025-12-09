package com.raquelfit.web;

import javax.persistence.*;

@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    private boolean pago;
    private String dataPagamento;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }

    public boolean getPago() { return pago; }
    public void setPago(boolean pago) { this.pago = pago; }

    public String getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(String dataPagamento) { this.dataPagamento = dataPagamento; }
}
