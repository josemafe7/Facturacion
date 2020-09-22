
package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.Model;
import modelo.entidades.Entidad;
import vista.View;

public abstract class AbstractControllerImpl <M extends Model, V extends View, D extends Serializable> implements Controller<M,V,D>{
    private M model;
    private List<V>views=new ArrayList<V>();
    
    public void setup(M model, List<V> views){
        this.model = model;
        model.setController(this);
        addViews(views);
    }
    
    public void start(){
        for(V v: this.views)
            v.display();
    }
    
    private void addViews(List<V>views){
        for(V c: views)
            this.addView(c);
    }
    
    public void addView(V view){
        view.setModel(this.model);
        view.setController(this);
        this.views.add(view);
    }
    
    public void removeView(V view){
        this.views.remove(view);
    }
    
    public M getModel(){
        return this.model;
    }
    
    public void setModel(M model){
        this.model = model;
    }
    
    
    public void nuevaEntidadGesture(List<D>datos){
        Entidad entidad = generaEntidad(datos);
        getModel().nuevaEntidad(entidad);
    }
    
    public void borraEntidadGesture(D pk){
        Entidad entidad = generaEntidad(pk);
        getModel().eliminarEntidad(entidad);
    }
    
    public void actualizaEntidadGesture(List<D>datos){
        Entidad entidad = generaEntidad(datos);
        getModel().actualizarEntidad(entidad);
    }
    
    
    public void fireDataModelChanged(){
        for(V v: this.views)
            v.display();
    }
    
    abstract Entidad generaEntidad(List<D>datos);
    abstract Entidad generaEntidad(D pk);
}
