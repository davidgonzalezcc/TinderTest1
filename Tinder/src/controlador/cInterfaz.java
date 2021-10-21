/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;



import modelo.Usuario;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import modelo.Foto;
import modelo.Sexo;
import modelo.Tinder;

/**
 *
 * @author David
 */
public class cInterfaz implements Initializable {
    
    private Tinder modelo;
    Usuario usuarioActual;
    Usuario usuario;

    @FXML
    private Label mi_nombre;

    @FXML
    private ImageView mi_foto;


    @FXML
    private Label mi_descripcion;
    
    @FXML
    private ComboBox<Usuario> combo_usuarios;
    
    
    @FXML
    private Label fecha;

   
    @FXML
    private DatePicker pick_fecha;
    
    @FXML
    private Label mi_sexo;
   
    @FXML
    private Button bt_crear_perfil;
    
    @FXML
    private TextField crear_descripcion;

    @FXML
    private ComboBox<Sexo> combo_crear_sexo;
    
    @FXML
    private DatePicker pick_crear_cumple;
    
    @FXML
    private TextField crear_nombre;
    
    @FXML
    private ComboBox<Foto> combo_crear_foto;
    @FXML
    private Label lb_crear_usuario_confirmacion;
    @FXML
    private Button bt_like;
    @FXML
    private Button bt_dislike;
    @FXML
    private Label lb_nombre;
    @FXML
    private ImageView mi_foto1;
    @FXML
    private Label lb_sexo;
    @FXML
    private Label lb_descripcion;

    
     
    public void cambiarPerfil() {
        
        String nombre_usuario = combo_usuarios.getValue().getNombre();
        Usuario usuario = modelo.buscarUsuario(nombre_usuario);
        modelo.setUsuarioMiPerfil(usuario);
        mostrarMiPerfil(usuario);
        
        
    }
    
    @FXML
    private void handleButtonAction(javafx.event.ActionEvent event) throws Exception {
        if (event.getSource() == combo_usuarios) 
        {
            cambiarPerfil();
        }
        else if(event.getSource() == pick_fecha)
        {
            cambiarFecha();
        }
        else if(event.getSource() == bt_crear_perfil)
        {
            crearPerfil();
        }
        else if(event.getSource() == bt_like)
        {
            darLike(usuario);
        }
     }

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
    
    modelo = new Tinder();
    fecha.setText(modelo.getFechaActual().toString());
    usuarioActual = modelo.getUsuarioMiPerfil();
    usuario = modelo.getUsuario();
    updateCombobox();
    combo_crear_sexo.getItems().addAll(Sexo.Hombre,Sexo.Mujer,Sexo.Bisexual,Sexo.Cabra,Sexo.HelicopteroBlackOps,Sexo.Tostadora);
    combo_crear_foto.getItems().addAll(Foto.FOTOA,Foto.FOTOB,Foto.FOTOC,Foto.FOTOD,Foto.FOTOE,Foto.FOTOF);
    mostrarMiPerfil(usuarioActual);
    mostrarPerfil(usuario);
    
    }    
    
    
    public void mostrarMiPerfil(Usuario pUsuarioActual) 
    {
        mi_nombre.setText(pUsuarioActual.getNombre()+", "+String.valueOf(pUsuarioActual.getEdad()));
        mi_descripcion.setText(pUsuarioActual.getDescripcion());
        mi_foto.setImage(pUsuarioActual.getFoto());  
        mi_sexo.setText("( "+pUsuarioActual.getSexo().toString()+" )");
    }
    
    public void cambiarFecha()
    {
        LocalDate nueva_fecha = pick_fecha.getValue();
        modelo.setFechaActual(nueva_fecha);
        fecha.setText(nueva_fecha.toString());
    }

    public void crearPerfil()
    {
    
    String nuevo_nombre = crear_nombre.getText();
    String nueva_descripcion = crear_descripcion.getText();
    LocalDate nuevo_cumple = pick_crear_cumple.getValue();
    Sexo nuevo_sexo = combo_crear_sexo.getValue();
    Foto nueva_foto = combo_crear_foto.getValue();
    modelo.crearUsuario(nuevo_nombre, nueva_descripcion, 12, 12, nuevo_cumple, modelo.formatearFoto(nueva_foto), nuevo_sexo);
    updateCombobox();
    lb_crear_usuario_confirmacion.setText("Usuario creado con exito.");
    }
    
    public void updateCombobox()
    {
        combo_usuarios.getItems().clear();
        combo_usuarios.getItems().addAll(modelo.getUsuarios());
    }
    
    public void mostrarPerfil(Usuario pUsuario)
    {
        lb_nombre.setText(pUsuario.getNombre());
        lb_sexo.setText(pUsuario.getSexo().toString());
        lb_descripcion.setText(pUsuario.getDescripcion());
    }
    
    public void darLike(Usuario pUsuario)
    {
        pUsuario.getLista_seguidores().add(modelo.getUsuarioMiPerfil());
        if(modelo.getUsuarioMiPerfil().getLista_seguidores().contains(pUsuario))
        {
            crearNuevoChat(modelo.getUsuarioMiPerfil(), pUsuario);
        }
        
    }
    
    public void crearNuevoChat(Usuario usuario1, Usuario usuario2)
    {
        if(usuario1 != null && usuario2 != null)
        {
            modelo.crearChat(usuario1,usuario2);           
        }
    }
    
    
}
