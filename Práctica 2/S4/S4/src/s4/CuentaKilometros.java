package s4;
public class CuentaKilometros {
    private double distancia;
    
    CuentaKilometros(){
        distancia = 0;
    }
    
    public double getDistancia(){
        return distancia;
    }
    
    public void setDistancia(double d){
        this.distancia += d;
    }
}
