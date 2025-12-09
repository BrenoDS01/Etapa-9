package com.raquelfit.web;

import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final String USER = "breno";
    private final String PASS = "1010";

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO login) {
        if (USER.equals(login.getUsuario()) && PASS.equals(login.getSenha())) {
            return "OK";
        }
        return "ERRO";
    }
}

class LoginDTO {
    private String usuario;
    private String senha;

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}

