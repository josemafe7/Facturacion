
package controlador;

import java.io.Serializable;
import java.util.List;
import modelo.Model;
import vista.View;

public interface Controller <M extends Model, V extends View, D extends Serializable>{
    void setup(M model, List<V>views);
    void start();
    
    M getModel();
    void setModel(M model);
    
    void addView(V view);
    void removeView(V view);
    
    void nuevaEntidadGesture(List<D>datos);
    void borraEntidadGesture(D pk);
    void actualizaEntidadGesture(List<D>datos);
    
    
    void fireDataModelChanged();
    
}
