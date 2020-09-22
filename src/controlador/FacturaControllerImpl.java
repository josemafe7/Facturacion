
package controlador;

import java.io.Serializable;
import java.util.List;
import modelo.FacturaModel;
import modelo.entidades.Cliente;
import modelo.entidades.Entidad;
import modelo.entidades.Factura;
import modelo.entidades.FacturaImpl;
import vista.factura.FacturaView;



public class FacturaControllerImpl extends AbstractControllerImpl<FacturaModel, FacturaView, Serializable> implements FacturaController{

    
    Entidad generaEntidad(List<Serializable> datos) {
        String identificador=(String)datos.get(0);
        Cliente cliente=(Cliente)datos.get(1);
        Double importe=new Double((String)datos.get(2));
        Factura factura = new FacturaImpl(identificador,cliente,importe);
        return factura;
    }

    
    Entidad generaEntidad(Serializable pk) {
        return new FacturaImpl((String)pk);
    }
    
    
}
