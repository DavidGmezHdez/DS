package s4;
public class CuentaRevoluciones {
    private double revoluciones;
    
    CuentaRevoluciones(){
        revoluciones = 0;
    }
    
    public double getRevoluciones(){
        return revoluciones;
    }
    
    public void setRevoluciones(double r){
        this.revoluciones = r;
        if(revoluciones < 0)
            revoluciones = 0;
    }
}
