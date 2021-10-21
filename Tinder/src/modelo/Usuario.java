/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.image.Image;


/**
 *
 * @author David
 */
public class Usuario {
    
    //Constantes
    
    
    //Atributos
    private String nombre;
    private String descripcion;
    private int edad;
    private double latitud;
    private double longitud;
    private LocalDate cumple;
    private Image foto;
    private Sexo sexo;
    
    private ArrayList<Usuario> lista_seguidores;
    private ArrayList<Usuario> lista_seguidos;
    private ArrayList<Chat> lista_chats;

   //Constructor
    public Usuario()
    {
        
    }
    public Usuario(String pNombre, String pDescripcion, int pEdad, double pLatitud, double pLongitud, LocalDate pCumple, String pFoto, Sexo pSexo) {
        this.nombre = pNombre;
        this.edad = pEdad;
        this.descripcion = pDescripcion;
        this.latitud = pLatitud;
        this.longitud = pLongitud;
        this.cumple = pCumple;
        this.foto = new Image(pFoto);
        this.sexo = pSexo;
        
        lista_seguidores = new ArrayList<>();
        lista_seguidos = new ArrayList<>();
        lista_chats = new ArrayList<>();
        
    }
   
   //Encapsulamiento

    

    @Override
    public String toString() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String pNombre) {
        this.nombre = pNombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String pDescripcion) {
        this.descripcion = pDescripcion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int pEdad) {
        this.edad = pEdad;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double pLatitud) {
        this.latitud = pLatitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double pLongitud) {
        this.longitud = pLongitud;
    }

    public LocalDate getCumple() {
        return cumple;
    }

    public void setCumple(LocalDate pCumple) {
        this.cumple = pCumple;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image pFoto) {
        this.foto = pFoto;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo pSexo) {
        this.sexo = pSexo;
    }

    public ArrayList<Usuario> getLista_seguidores() {
        return lista_seguidores;
    }

    public void setLista_seguidores(ArrayList<Usuario> lista_seguidores) {
        this.lista_seguidores = lista_seguidores;
    }

    public ArrayList<Usuario> getLista_seguidos() {
        return lista_seguidos;
    }

    public void setLista_seguidos(ArrayList<Usuario> lista_seguidos) {
        this.lista_seguidos = lista_seguidos;
    }

    public ArrayList<Chat> getLista_chats() {
        return lista_chats;
    }

    public void setLista_chats(ArrayList<Chat> lista_chats) {
        this.lista_chats = lista_chats;
    }

    
   
    
}
