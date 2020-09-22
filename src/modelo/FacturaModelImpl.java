
package modelo;

import controlador.FacturaController;
import java.util.List;
import modelo.entidades.Factura;
import modelo.persistencia.FacturaDAO;
import modelo.persistencia.GenericDAO;
import modelo.persistencia.JDBC.FacturaDAOJDBC;


public class FacturaModelImpl extends AbstractModelImpl<FacturaController,Factura,String> implements FacturaModel{

    GenericDAO obtenerImplementacionDAO() {
        return new FacturaDAOJDBC();
    }

    public List<Factura> listarPorCliente(String nombre) {
        FacturaDAO dao=(FacturaDAO)obtenerImplementacionDAO();
        return dao.listByCliente(nombre);
    }

    
}
