
package controlador;

import java.util.List;
import modelo.ClienteModel;
import modelo.entidades.Cliente;
import modelo.entidades.ClienteImpl;
import modelo.entidades.Entidad;
import vista.cliente.ClienteView;



public class ClienteControllerImpl extends AbstractControllerImpl<ClienteModel,ClienteView,String> implements ClienteController{

   
    Entidad generaEntidad(List<String> datos) {
        String DNI=datos.get(0);
        String nombre=datos.get(1);
        String direccion=datos.get(2);
        Cliente c = new ClienteImpl(DNI, nombre, direccion);
        return c;
    }

    Entidad generaEntidad(String pk) {
        return new ClienteImpl(pk);
    }

    
    
    
}
