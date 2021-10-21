/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDateTime;

/**
 *
 * @author David
 */
public class Mensaje 
{
//Constantes
    
    
//Atributos
    
private LocalDateTime hora;
private boolean esta_leido;
private String contenido;
private Usuario usuarioQueEnvia;

public Mensaje(Usuario pUsuarioQueEnvia, LocalDateTime pHora, String pContenido)
{
    usuarioQueEnvia = pUsuarioQueEnvia;
    hora = pHora;
    esta_leido = false;
    contenido = pContenido;
}

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public boolean isEsta_leido() {
        return esta_leido;
    }

    public void setEsta_leido(boolean esta_leido) {
        this.esta_leido = esta_leido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Usuario getUsuarioQueEnvia() {
        return usuarioQueEnvia;
    }

    public void setUsuarioQueEnvia(Usuario usuarioQueEnvia) {
        this.usuarioQueEnvia = usuarioQueEnvia;
    }

    

}
