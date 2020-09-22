
package vista.factura;

import controlador.FacturaController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.FacturaModel;
import modelo.entidades.Cliente;
import modelo.entidades.Factura;
import vista.AbstractViewImpl;
import vista.cliente.ClienteTableAndComboModel;

public class FacturaViewImpl extends AbstractViewImpl<FacturaController,FacturaModel> implements FacturaView{

    //Atributos propios de Swing
    private FacturaTableModel facturaTableModel;
    private FacturaViewImplInternal panelFactura;
    private ClienteTableAndComboModel clienteComboModel;
    
    public FacturaViewImpl() {
        facturaTableModel = new FacturaTableModel();
        //comboModel = new ClienteTableAndComboModel();
        clienteComboModel=ClienteTableAndComboModel.create();
        initComponents();

        this.panelFactura = new FacturaViewImplInternal(this);
        this.jPanelFactura.add(this.panelFactura);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFacturas = new javax.swing.JTable();
        jPanelFactura = new javax.swing.JPanel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButtonFiltrar = new javax.swing.JButton();
        jButtonQuitarFiltro = new javax.swing.JButton();

        jTableFacturas.setModel(facturaTableModel);
        jTableFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFacturasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFacturas);

        jPanelFactura.setLayout(new javax.swing.BoxLayout(jPanelFactura, javax.swing.BoxLayout.LINE_AXIS));

        jComboBoxCliente.setModel(clienteComboModel);
        jComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClienteActionPerformed(evt);
            }
        });

        jLabel1.setText("Cliente");

        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        jButtonQuitarFiltro.setText("Quitar Filtro");
        jButtonQuitarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonFiltrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonQuitarFiltro)))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonFiltrar)
                            .addComponent(jButtonQuitarFiltro))))
                .addGap(18, 18, 18)
                .addComponent(jPanelFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

         
    
    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        refresh();
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jTableFacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFacturasMouseClicked
        FacturaTableModel ctm = (FacturaTableModel) this.jTableFacturas.getModel();
        Factura factura = ctm.getRow(this.jTableFacturas.getSelectedRow());
        panelFactura.setFactura(factura);
    }//GEN-LAST:event_jTableFacturasMouseClicked

    private void jComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxClienteActionPerformed

    private void jButtonQuitarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarFiltroActionPerformed
        this.jComboBoxCliente.setSelectedItem(null);
    }//GEN-LAST:event_jButtonQuitarFiltroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonQuitarFiltro;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelFactura;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFacturas;
    // End of variables declaration//GEN-END:variables

    protected ClienteTableAndComboModel getComboModel() {
        return clienteComboModel;
    }

    

    public void refresh() {
        facturaTableModel.setFacturas(getModel().listar());//cambia el modelo de JTable(TableModel) por medio de una clase que hemos creado (ClientesTableModel)
    }
    
    protected void fireNuevaFacturaGesture(String identificador, Cliente cliente, String importe) {
        List<Serializable>datos=new ArrayList<Serializable>();
        datos.add(identificador);
        datos.add((Serializable) cliente);
        datos.add(importe);
        this.getController().nuevaEntidadGesture(datos);
    }

    protected void fireActualizaFacturaGesture(String identificador, Cliente cliente, String importe) {
        List<Serializable>datos=new ArrayList<Serializable>();
        datos.add(identificador);
        datos.add((Serializable) cliente);
        datos.add(importe);
        this.getController().actualizaEntidadGesture(datos);
    }

    protected void fireBorraFacturaGesture(String identificador) {
        this.getController().borraEntidadGesture(identificador);
    }

    

}