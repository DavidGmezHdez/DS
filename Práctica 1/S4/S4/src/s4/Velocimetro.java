package s4;
public class Velocimetro {
    private double velocidad;
    
    Velocimetro(){
        velocidad = 0;
    }
    
    public double getVelocidad(){
        return velocidad;
    }
    
    public void setVelocidad(double v){
        if(v>=0)
            velocidad = v;
    }
    
}
