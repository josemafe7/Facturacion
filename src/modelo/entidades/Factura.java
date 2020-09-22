
package modelo.entidades;

public interface Factura extends Entidad{
    
    String getIdentificador();
    Cliente getCliente();
    Double getImporte();
    
    void setIdentificador(String id);
    //void setCliente(Cliente cl);
    //void setImporte(Double im);
}
