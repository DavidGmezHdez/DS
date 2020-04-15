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
        velocidad = v;
        if(velocidad < 0 )
            velocidad = 0;
    }
    
}
