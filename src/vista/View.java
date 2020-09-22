
package vista;

import controlador.Controller;
import modelo.Model;

public interface View<C extends Controller, M extends Model> {
    
    C getController();
    void setController(C controller);
    
    M getModel();
    void setModel(M model);
    
    void dataModelChanged();
    void display();
}
