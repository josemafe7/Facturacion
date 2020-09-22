
package modelo;

import controlador.ClienteController;
import modelo.entidades.Cliente;
import modelo.persistencia.GenericDAO;
import modelo.persistencia.JDBC.ClienteDAOJDBC;


public class ClienteModelImpl extends AbstractModelImpl<ClienteController,Cliente,String> implements ClienteModel{

    GenericDAO obtenerImplementacionDAO() {
        return new ClienteDAOJDBC();
    }
  
}
