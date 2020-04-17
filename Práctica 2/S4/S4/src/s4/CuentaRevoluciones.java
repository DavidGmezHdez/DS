package s4;
public class CuentaRevoluciones {
    private double revoluciones;
    private double revolucionesAlmacenada;
    
    CuentaRevoluciones(){
        revoluciones = 0;
        revolucionesAlmacenada = 0;
    }
    
    public double getRevoluciones(){
        return revoluciones;
    }
    
    public void setRevoluciones(double r){
        this.revoluciones = r;
        if(revoluciones < 0)
            revoluciones = 0;
    }
    
    public double getRevolucionesAlmacenadas(){
        return revolucionesAlmacenada;
    }
    
    public void setRevolucionesAlmacenada(double r){
        this.revolucionesAlmacenada = r;
        if(revolucionesAlmacenada < 0)
            revolucionesAlmacenada = 0;
    }
}
