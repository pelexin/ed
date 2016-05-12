
package practica5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clases conectadas a traves de Package Private
 * @author Ruben Blanco
 */
public class MASCOTAS {
   
    List<CLIENTE> mascotasCliente = new ArrayList<CLIENTE>();
	
    CALENDARIO_VACUNAS miCalendario = new CALENDARIO_VACUNAS();
    HISTORIAL_MEDICO miHistorial = new HISTORIAL_MEDICO();
  
    String CODIGO;
    String ALIAS;
    String ESPECIE;
    String RAZA;
    String COLOR_PELO;
    Date FECHA_NACIMIENTO;
    float PESO_MEDIO_VISITAS;
    float PESO_ACTUAL;
}
