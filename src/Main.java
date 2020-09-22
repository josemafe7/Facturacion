/*EPD10-P
Desarrollar la misma funcionalidad realizada en la EPD anterior (EPD9: Aplicación de Facturación) haciendo uso de los tipos
genéricos.
Recordando la funcionalidad de dicho sistema, tan sólo tendería que gestionar los clientes y las facturas que tienen relacionadas. De
una manera general, la aplicación permitiría las operaciones CRUD tanto para los clientes como facturas, además de poder listar las
facturas según un cliente específico. Prestad especial atención a todas las operaciones comunes de cara a la implementación de los
tipos genéricos.
 */

/**
 *
 * @author José_Manuel_Fernández_Labrador
 */


import controlador.ClienteController;
import controlador.ClienteControllerImpl;
import controlador.FacturaController;
import controlador.FacturaControllerImpl;
import java.util.ArrayList;
import java.util.List;
import modelo.ClienteModel;
import modelo.ClienteModelImpl;
import modelo.FacturaModel;
import modelo.FacturaModelImpl;
import vista.VistaGlobal;
import vista.cliente.ClienteView;
import vista.cliente.ClienteViewImpl;
import vista.factura.FacturaView;
import vista.factura.FacturaViewImpl;

public class Main {
    public static void main(String[] args) throws Exception{

        //Cliente
        ClienteModel clienteModel = new ClienteModelImpl();

        
        ClienteView clienteView1 =new ClienteViewImpl();
        ClienteView clienteView2 =new ClienteViewImpl();
        List<ClienteView> clienteViews= new ArrayList<ClienteView>();
        clienteViews.add(clienteView1);
        clienteViews.add(clienteView2);

        ClienteController clienteController = new ClienteControllerImpl();
        
        clienteController.setup(clienteModel, clienteViews);


        //Factura
        FacturaModel facturaModel = new FacturaModelImpl();


        FacturaView facturaView1 =new FacturaViewImpl();
        FacturaView facturaView2 =new FacturaViewImpl();
        List<FacturaView> facturaViews= new ArrayList<FacturaView>();
        facturaViews.add(facturaView1);
        facturaViews.add(facturaView2);

        FacturaController facturaController = new FacturaControllerImpl();

        facturaController.setup(facturaModel, facturaViews);
        
        //VistaGlobal
        VistaGlobal vista1=new VistaGlobal(clienteView1,facturaView1);
        VistaGlobal vista2=new VistaGlobal(clienteView2,facturaView2);
        vista1.display();
        vista2.display();

    }
    
}
