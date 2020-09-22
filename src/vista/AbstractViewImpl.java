
package vista;

import controlador.Controller;
import modelo.Model;

public abstract class AbstractViewImpl <C extends Controller, M extends Model> extends javax.swing.JPanel implements View<C,M>{
    
    C controller;
    M model;
    
    public C getController(){
        return this.controller;
    }
    
    public void setController(C controller){
        this.controller=controller;
    }
    
    public M getModel(){
        return model;
    }
    
    public void setModel(M model){
         this.model=model;
    }
    
    public void dataModelChanged(){
        refresh();
    }
    
    protected abstract void refresh();

    public void display(){
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                setVisible(true);
                refresh();
            }
        });

    }
}
