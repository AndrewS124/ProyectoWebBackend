package com.example.musiclist2.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String nombre;
    private String email;
    private String password;
    private String autenticacion;
    private String tipo;
}
