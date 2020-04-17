package s4;
public class Velocimetro {
    private double velocidad;
    private double velocidadAlmacenada;
    
    Velocimetro(){
        velocidad = 0;
        velocidadAlmacenada = 0;
    }
    
    public double getVelocidad(){
        return velocidad;
    }
    
    public double getVelocidadAlmacenada(){
        return velocidadAlmacenada;
    }
    
    public void setVelocidad(double v){
        velocidad = v;
        if(velocidad < 0 )
            velocidad = 0;
    }
    
    public void setVelocidadAlmacenada(double v){
        velocidadAlmacenada = v;
        if(velocidadAlmacenada < 0 )
            velocidadAlmacenada = 0;
    }
    
}
