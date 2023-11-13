package com.example.musiclist2.DTO;



public class UsuarioVotanteDTO extends UsuariosDTO {

    private boolean activacion;
   

    // Puedes agregar más campos según sea necesario

   

    public UsuarioVotanteDTO() {
        super();
    }

    public boolean isActivacion() {
        return activacion;
    }

    public void setActivacion(boolean activacion) {
        this.activacion = activacion;
    }
}