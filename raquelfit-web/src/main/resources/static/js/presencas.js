const tabela = document.getElementById("tabelaPresencas");

function carregarPresencas() {
    fetch("/alunos")
        .then(res => res.json())
        .then(alunos => {
            tabela.innerHTML = "";
            alunos.forEach(aluno => {
                fetch(`/presencas/${aluno.id}`)
                    .then(res => res.json())
                    .then(presencas => {
                        const qtd = presencas.length;
                        tabela.innerHTML += `
                            <tr>
                                <td>${aluno.nome}</td>
                                <td>${aluno.cpf}</td>
                                <td>${qtd}</td>
                                <td><button onclick="registrar(${aluno.id})" class="btn">Marcar Presença</button></td>
                            </tr>
                        `;
                    });
            });
        });
}

function registrar(idAluno) {
    fetch(`/presencas/${idAluno}`, { method: "POST" })
        .then(res => res.json())
        .then(() => {
            alert("Presença registrada!");
            carregarPresencas();
        });
}

carregarPresencas();