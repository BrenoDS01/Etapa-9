// Buscar alunos e exibir na tabela
async function carregarAlunos() {
    const response = await fetch("/alunos");
    const alunos = await response.json();

    const tabela = document.getElementById("tabelaAlunos");
    tabela.innerHTML = "";

    alunos.forEach(aluno => {
        tabela.innerHTML += `
            <tr>
                <td>${aluno.nome}</td>
                <td>${aluno.cpf}</td>
                <td>${aluno.endereco}</td>
                <td>${aluno.telefone}</td>
                <td>${aluno.peso}</td>
                <td>
                    <button onclick="excluirAluno(${aluno.id})" class="btn-delete">🗑️</button>
                </td>
            </tr>
        `;
    });
}

// Salvar aluno
document.getElementById("formAluno").addEventListener("submit", async (event) => {
    event.preventDefault();

    const aluno = {
        nome: document.getElementById("nome").value,
        cpf: document.getElementById("cpf").value,
        endereco: document.getElementById("endereco").value,
        telefone: document.getElementById("telefone").value,
        peso: document.getElementById("peso").value
    };

    await fetch("/alunos", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(aluno)
    });

    event.target.reset();
    carregarAlunos();
});

// Excluir aluno (extra)
async function excluirAluno(id) {
    if (!confirm("Tem certeza que deseja excluir?")) return;

    await fetch(`/alunos/${id}`, { method: "DELETE" });
    carregarAlunos();
}

window.onload = carregarAlunos;