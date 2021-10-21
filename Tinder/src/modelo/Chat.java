/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author David
 */
public class Chat 
{
//Constantes
    
    
//Atributos
    
private Usuario usuario1;
private Usuario usuario2;

private ArrayList<Mensaje> listaMensajes;
    
//Constructor
public Chat(Usuario pUsuario1, Usuario pUsuario2)
{
    usuario1 = pUsuario1;
    usuario2 = pUsuario2;
    listaMensajes = new ArrayList<>();
}

    

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }

    public ArrayList<Mensaje> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(ArrayList<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }


    
}
