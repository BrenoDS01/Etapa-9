const tabelaPag = document.getElementById("tabelaPagamentos");

function carregarPagamentos() {
    fetch("/alunos")
        .then(res => res.json())
        .then(alunos => {
            tabelaPag.innerHTML = "";
            alunos.forEach(aluno => {
                fetch(`/pagamentos/${aluno.id}`)
                    .then(res => res.json())
                    .then(pag => {
                        const status = pag.pago ? "🟢 Em dia" : "🔴 Pendente";
                        tabelaPag.innerHTML += `
                            <tr>
                                <td>${aluno.nome}</td>
                                <td>${aluno.cpf}</td>
                                <td>${status}</td>
                                <td><button class="btn" onclick="pagar(${aluno.id})">Marcar Pago</button></td>
                            </tr>
                        `;
                    });
            });
        });
}

function pagar(idAluno) {
    fetch(`/pagamentos/${idAluno}`, { method: "POST" })
        .then(res => res.json())
        .then(() => {
            alert("Pagamento atualizado!");
            carregarPagamentos();
        });
}

carregarPagamentos();
