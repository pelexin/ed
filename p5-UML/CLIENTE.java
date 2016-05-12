
package practica5;


import java.util.ArrayList;
import java.util.List;

/**
 * Clases conectadas a traves de Package Private
 * @author Ruben Blanco
 */
public class CLIENTE {

    List<PERSONA> clientePersona = new ArrayList<PERSONA>();
    List<MASCOTAS> clienteMascota = new ArrayList<MASCOTAS>();
    
    VETERINARIO miVeterinario = new VETERINARIO();
    
    String CODIGO;
    String PRIMER_APELLIDO;
    int NUMERO_CUENTA;
    String DIRECCION;
    int TELEFONO;
    String DNI_MIEMBROS;
    String NOMBRE_MIEMBROS;

}
