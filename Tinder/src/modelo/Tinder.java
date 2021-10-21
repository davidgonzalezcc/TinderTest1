/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author David
 */
public class Tinder 
{
    
private ObservableList<Usuario> usuarios; 
private ObservableList<String> nombreUsuarios;

private Usuario usuarioMiPerfil ;
private Usuario usuario;
private LocalDate fechaActual; 


public Tinder()
{
        usuarios = FXCollections.observableArrayList();
        nombreUsuarios = FXCollections.observableArrayList();
        fechaActual = LocalDate.now();
        crearUsuariosPorDefecto();
        llenarNombres();
        usuarioMiPerfil = usuarios.get(0);
        usuario = usuarios.get(1);
        
}

    public Usuario mostrarUsuario(String pNombre) 
    {
        Usuario usuarioAMostrar = buscarUsuario(pNombre);
        return usuarioAMostrar;
    }
    
    
    
    public Usuario buscarUsuario(String pNombre)
    {
        for (Usuario actual : usuarios) 
        {
            if(actual.getNombre().equalsIgnoreCase(pNombre))
            {
                return actual;
            }
        }
        return null;
    }
    
    public void crearUsuariosPorDefecto()
    {
    crearUsuario("Juan",
                               "Es un chico alto y robusto, con la cara ancha y unos ojos negros muy grandes.", 
                                12, 12, LocalDate.of(1999, 12, 12),formatearFoto(Foto.FOTOA),Sexo.Hombre);
    crearUsuario("Lorena",
                               "Lorena hace un cursillo de natación. Es una chica pelo largo, rizado y de un tono castaño. ", 
                                12, 12, LocalDate.of(1999, 12, 12),formatearFoto(Foto.FOTOB),Sexo.Mujer);
    crearUsuario("Martina",
                               "Tengo la cara redonda y los ojos pequeños, de un color verde esmeralda muy bonito.", 
                                12, 12, LocalDate.of(1999, 12, 12),formatearFoto(Foto.FOTOC),Sexo.Mujer);
    crearUsuario("Laura",
                               "Es una chica muy alegre y educada siempre dispuesta a ayudar a quienes se lo piden.", 
                                12, 12, LocalDate.of(1999, 12, 12),formatearFoto(Foto.FOTOD),Sexo.Mujer);
    
    crearUsuario("Paola",
                               "Le encanta ir al cine cuando tiene tiempo libre y, sobre todo, viajar. ", 
                                12, 12, LocalDate.of(1999, 12, 12),formatearFoto(Foto.FOTOE),Sexo.Mujer);
    crearUsuario("Chris",
                               "De hecho, este último año ha recorrido medio mundo él solo.", 
                                12, 12, LocalDate.of(1999, 12, 12),formatearFoto(Foto.FOTOF),Sexo.Hombre);
        }
    
    public void crearUsuario(String pNombre, String pDescripcion, double pLatitud, double pLongitud, LocalDate pFecha,String pFoto,Sexo pSexo)
    {
        Usuario usuario = buscarUsuario(pNombre);
        Usuario usuarioNuevo;
        if(usuario == null)
        {
            usuarioNuevo = new Usuario(pNombre, pDescripcion,18, pLatitud, pLongitud, pFecha, pFoto, pSexo); //TODO EDAD
            usuarios.add(usuarioNuevo);
        }
    }
    
    
    public void crearChat(Usuario pUsuario1, Usuario pUsuario2)
    {
        
        Chat nuevo_chat = new Chat(pUsuario1,pUsuario2);
        pUsuario1.getLista_chats().add(nuevo_chat);
        pUsuario2.getLista_chats().add(nuevo_chat);
        
    }
    
    public void llenarNombres()
    {
        for (Usuario actual : usuarios) {
            String nuevo = actual.getNombre();
            nombreUsuarios.add(nuevo);
        }
    }
   
    
    public Usuario getUsuarioMiPerfil() {
        return usuarioMiPerfil;
    }

    //Encapsulamiento
    public void setUsuarioMiPerfil(Usuario usuarioMiPerfil) {
        this.usuarioMiPerfil = usuarioMiPerfil;
    }

    public LocalDate getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(LocalDate pFechaActual) {
        this.fechaActual = pFechaActual;
    }

    public ObservableList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ObservableList<String> getNombreUsuarios() {
        return nombreUsuarios;
    }

    public String formatearFoto(Foto nueva_foto) {
        String formateo = "/data/"+nueva_foto+".jpg";
        return formateo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    
    
    
    
    
}
