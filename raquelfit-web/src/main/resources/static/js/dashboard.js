const totalAlunos = document.getElementById("totalAlunos");
const pagos = document.getElementById("pagos");
const pendentes = document.getElementById("pendentes");
const presencasHoje = document.getElementById("presencasHoje");

fetch("/dashboard/resumo")
    .then(res => res.json())
    .then(r => {
        totalAlunos.innerText = r.totalAlunos;
        pagos.innerText = r.pagos;
        pendentes.innerText = r.pendentes;
        presencasHoje.innerText = r.presencasHoje;
    });
