package com.raquelfit.web;

import javax.persistence.*;

@Entity
@Table(name = "presencas")
public class Presenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    private String dataPresenca;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }

    public String getDataPresenca() { return dataPresenca; }
    public void setDataPresenca(String dataPresenca) { this.dataPresenca = dataPresenca; }
}
