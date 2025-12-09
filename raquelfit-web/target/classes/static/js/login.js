function login() {
    const usuario = document.getElementById("usuario").value;
    const senha = document.getElementById("senha").value;
    const msg = document.getElementById("msg");

    fetch("/login", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({ usuario, senha })
    })
    .then(res => {
        if (res.status === 200) {
            window.location.href = "dashboard.html";
        } else {
            msg.innerText = "Usuário ou senha incorretos!";
        }
    });
}
