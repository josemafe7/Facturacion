
package modelo.entidades;

public class FacturaImpl implements Factura{
    
    private String identificador;
    private Cliente cliente;
    private Double importe;

    public FacturaImpl(String identifiador, Cliente cliente, Double importe) {
        this.identificador = identifiador;
        this.cliente = cliente;
        this.importe = importe;
    }

    public FacturaImpl(String identificador) {
        this(identificador,null,null);
    }

    @Override
    public String getIdentificador() {
        return this.identificador;
    }

    @Override
    public Cliente getCliente() {
        return this.cliente;
    }

    @Override
    public Double getImporte() {
        return this.importe;
    }

    @Override
    public void setIdentificador(String id) {
        this.identificador = id;
    }
}
